package manitsche.projeto.exerciciojokenpo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    Button bIniciar;
    EditText cNomeJ1, cNomeJ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1);

        bIniciar = findViewById(R.id.button);
        cNomeJ1 = findViewById(R.id.campo_nome_j1);
        cNomeJ2 = findViewById(R.id.campo_nome_j2);

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1.this, Tela2.class);
                intent.putExtra("cNomeJ1", cNomeJ1.getText().toString());
                intent.putExtra("cNomeJ2", cNomeJ2.getText().toString());
                startActivity(intent);
            }
        });
    }
}