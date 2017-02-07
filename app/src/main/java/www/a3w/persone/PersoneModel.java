package www.a3w.persone;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by sergej on 07.02.17.
 */

public interface PersoneModel {
    void insert(SQLiteDatabase dataBase, String table, Persone persone);

    List<Persone> readAll();

    List<Persone> read(SQLiteDatabase database, String table);

    void deleteAll(SQLiteDatabase database, String table);

    boolean checkDataBase();

    void addPersone(Persone persone);



}
