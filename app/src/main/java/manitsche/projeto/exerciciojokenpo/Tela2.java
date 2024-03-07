package manitsche.projeto.exerciciojokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Tela2 extends AppCompatActivity {

    TextView tNomeJ1, tNomeJ2, tGanhador;
    ImageView iJogadaJ1, iJogadaJ2;
    Button bJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        tNomeJ1 = findViewById(R.id.tNomeJ1);
        tNomeJ2 = findViewById(R.id.tNomeJ2);
        tGanhador = findViewById(R.id.tGanhador);
        iJogadaJ1 = findViewById(R.id.iJogadaJ1);
        iJogadaJ2 = findViewById(R.id.iJogadaJ2);
        bJogar = findViewById(R.id.bJogar);

        String nomeJ1 = getIntent().getStringExtra("cNomeJ1");
        String nomeJ2 = getIntent().getStringExtra("cNomeJ2");

        tNomeJ1.setText(nomeJ1);
        tNomeJ2.setText(nomeJ2);

        bJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJogo();
            }
        });
    }

    public void iniciarJogo() {
        // Gerando jogadas aleatórias para os dois jogadores
        int jogadaJ1 = gerarJogadaAleatoria();
        int jogadaJ2 = gerarJogadaAleatoria();

        exibirJogada(iJogadaJ1, jogadaJ1);
        exibirJogada(iJogadaJ2, jogadaJ2);

        determinarVencedor(jogadaJ1, jogadaJ2);
    }

    private int gerarJogadaAleatoria() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private void exibirJogada(ImageView imageView, int jogada) {
        switch (jogada) {
            case 0:
                imageView.setImageResource(R.drawable.pedra);
                break;
            case 1:
                imageView.setImageResource(R.drawable.papel);
                break;
            case 2:
                imageView.setImageResource(R.drawable.tesoura);
                break;
        }
    }

    private void determinarVencedor(int jogadaJ1, int jogadaJ2) {
        if (jogadaJ1 == jogadaJ2) {
            tGanhador.setText("Empate!");
        } else if ((jogadaJ1 == 0 && jogadaJ2 == 2) || (jogadaJ1 == 1 && jogadaJ2 == 0) || (jogadaJ1 == 2 && jogadaJ2 == 1)) {
            tGanhador.setText(tNomeJ1.getText().toString() + " venceu!");
        } else {
            tGanhador.setText(tNomeJ2.getText().toString() + " venceu!");
        }
    }
}