package www.a3w;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sergej on 03.02.17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + Constant.DB_TABLE_ACCOUNT
                + " ("
                + "id integer primary key autoincrement,"
                + Constant.NAME + " text,"
                + Constant.TYPE + " text,"
                + Constant.YEAR + " text,"
                + Constant.MONTH + " text,"
                + Constant.DAY + " text"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
