package code.atividade3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by lflgoncalves on 10/24/16.
 */
public class DbManager {
    private static DbHelper dbHelper = null;

    public DbManager(Context context){
        if(dbHelper == null) {
            dbHelper = new DbHelper(context);
        }
    }

    public void addLembrete(String lembrete) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(SQLHelper.insertLembrete(lembrete));
    }

    public ArrayList<String> getAllLembretes(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sqlQuery = SQLHelper.getAllLembretes();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<String> lembretes = new ArrayList<String>();

        if(lembretes != null && cursor.moveToFirst()) {
            do {
                lembretes.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lembretes;
    }
}
