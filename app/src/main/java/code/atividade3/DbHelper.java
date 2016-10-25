package code.atividade3;

/**
 * Created by lflgoncalves on 10/24/16.
 */

import android.content.Context;
import android.database.sqlite.*;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "Atividade3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cria tabela lembrete e insiere dados iniciais
        db.execSQL(SQLHelper.createTableLembrete());

        //insere lembretes de teste
        db.execSQL(SQLHelper.insertLembrete("Lembrete teste1"));

        //insere lembretes de teste
        db.execSQL(SQLHelper.insertLembrete("Lembrete teste2"));

        //insere lembretes de teste
        db.execSQL(SQLHelper.insertLembrete("Lembrete teste3"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
