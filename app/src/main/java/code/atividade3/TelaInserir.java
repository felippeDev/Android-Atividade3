package code.atividade3;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInserir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inserir);

        // Declarando variaveis dos objs de layout
        final EditText txtLembrete = (EditText) findViewById(R.id.txtLembrete);
        Button btnInserir = (Button) findViewById(R.id.btnInserir);

        // BtnListener - adicionar lembrete
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddLembrete(txtLembrete.getText().toString());
            }
        });
    }

    private void AddLembrete(String lembrete){
        try {
            // Adicionando lembrete
            DbManager dbManager = new DbManager(this);
            dbManager.addLembrete(lembrete);

            startActivity(new Intent(TelaInserir.this, MainActivity.class));

            Toast.makeText(getApplicationContext(), "Lembrete adicionado.", Toast.LENGTH_SHORT).show();
        } catch (SQLException ex) {
            Toast.makeText(getApplicationContext(), "Erro: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
