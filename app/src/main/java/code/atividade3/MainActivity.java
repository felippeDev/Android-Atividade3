package code.atividade3;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarando variaveis dos objs de layout
        ListView listLembretes = (ListView) findViewById(R.id.listLembretes);
        Button btnInserirLembrete = (Button) findViewById(R.id.btnInserirLembrete);

        // Obtendo todos os lembretes
        DbManager dbManager = new DbManager(this);
        ArrayList listItems = dbManager.getAllLembretes();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listLembretes.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // BtnListener - ir para activity TelaInserir
        btnInserirLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaInserir.class));
            }
        });
    }
}