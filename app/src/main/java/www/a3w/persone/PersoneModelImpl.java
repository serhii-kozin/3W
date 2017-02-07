package www.a3w.persone;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import www.a3w.Constant;
import www.a3w.DBHelper;

/**
 * Created by sergej on 07.02.17.
 */

public class PersoneModelImpl implements PersoneModel {
    private DBHelper mDbHelper;
    private SQLiteDatabase mSQLiteDataBase;
    private Context mContext;
    private List<Persone> mPersone;

    public PersoneModelImpl(Context context) {

        mContext = context;
    }

    @Override
    public void insert(SQLiteDatabase dataBase, String table, Persone persone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.NAME, persone.getName());
        contentValues.put(Constant.TYPE, persone.getType());
        contentValues.put(Constant.YEAR, persone.getDate().get(Calendar.YEAR));
        contentValues.put(Constant.MONTH, persone.getDate().get(Calendar.MONTH));
        contentValues.put(Constant.DAY, persone.getDate().get(Calendar.DAY_OF_MONTH));

        dataBase.insert(table, null, contentValues);
    }

    @Override
    public List<Persone> readAll() {
        if (checkDataBase()) {
            mSQLiteDataBase = SQLiteDatabase.openDatabase(Constant.DB_FULL_PATH, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } else {
            mDbHelper = new DBHelper(mContext, Constant.DB_NAME);
            mSQLiteDataBase = mDbHelper.getWritableDatabase();
        }
        mPersone = read(mSQLiteDataBase, Constant.DB_TABLE_ACCOUNT);
        mSQLiteDataBase.close();
        return mPersone;
    }

    @Override
    public List<Persone> read(SQLiteDatabase database, String table) {
        List<Persone> persone = new ArrayList<>();
        Cursor cursor = database.query(table, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    persone.add(
                            new PersoneImpl(
                                    cursor.getString(cursor.getColumnIndex(Constant.NAME)),
                                    Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constant.TYPE))),
                                    new GregorianCalendar(
                                            Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constant.YEAR))),
                                            Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constant.MONTH))),
                                            Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constant.DAY)))
                                    )));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return persone;
    }

    @Override
    public void deleteAll(SQLiteDatabase database, String table) {

    }

    @Override
    public boolean checkDataBase() {
        try {
            mSQLiteDataBase = SQLiteDatabase.openDatabase(Constant.DB_FULL_PATH, null,
                    SQLiteDatabase.OPEN_READONLY);
            mSQLiteDataBase.close();
        } catch (SQLiteException e) {
            return false;
        }
        return true;
    }

    @Override
    public void addPersone(Persone persone) {
        if (checkDataBase()) {
            mSQLiteDataBase = SQLiteDatabase.openDatabase(Constant.DB_FULL_PATH, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } else {
            mDbHelper = new DBHelper(mContext, Constant.DB_NAME);
            mSQLiteDataBase = mDbHelper.getWritableDatabase();
        }
        insert(mSQLiteDataBase, Constant.DB_TABLE_ACCOUNT, persone);
        mSQLiteDataBase.close();
    }
}
