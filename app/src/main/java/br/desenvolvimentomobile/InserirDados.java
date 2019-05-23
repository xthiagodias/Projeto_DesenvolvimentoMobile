package br.desenvolvimentomobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class InserirDados extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoAvaliar = (Button) findViewById(R.id.btCadastrar);
        Button botaoConsultar = (Button) findViewById(R.id.btConsultar);
        Button botaoVerificarMedia = (Button) findViewById(R.id.btConsultarMedia);

        botaoAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                TextInputEditText curso = (TextInputEditText) findViewById(R.id.idCurso);
                RatingBar media = (RatingBar) findViewById((R.id.idMedia));
                TextInputEditText sugestao = (TextInputEditText) findViewById(R.id.idNome);
                String cursoString = curso.getText().toString();
                double mediadouble = media.getRating();
                String nomeString = sugestao.getText().toString();
                String resultado;

                //VERIFICAÇÃO DOS CAMPOS//
                if (curso.getText().length() == 0) {

                    curso.setError("O campo CURSO não pode ser vazio");
                    return;
                } else if (curso.getText().length() < 5) {

                    curso.setError("Mínimo 5 letras");
                    return;

                } else if (sugestao.getText().length() == 0) {

                    sugestao.setError("O campo SUGESTÃO/RECLAMAÇÃO não pode ser vazio");
                    return;
                } else if (sugestao.getText().length() < 5) {

                    sugestao.setError("Mínimo 5 letras");
                    return;

                } else if (media.getRating() == 0) {

                    Toast.makeText(getApplicationContext(), "Você deve informar sua NOTA para o curso", Toast.LENGTH_LONG).show();
                    media.requestFocus();
                    return;


                } else {
                    //FIM VERIFICAÇÃO DE CAMPOS//

                    //FAZ A INSERÇÃO DOS DADOS//
                    resultado = crud.insereDado(cursoString, mediadouble, nomeString);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                    //RESETA OS CAMPOS//
                    curso.setText("");
                    media.setRating(0);
                    sugestao.setText("");
                    curso.requestFocus();
                }
            }

        });


        //CONSULTA DE REGISTROS INSERIDOS//
        botaoConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputEditText curso = (TextInputEditText) findViewById(R.id.idCurso);
                RatingBar media = (RatingBar) findViewById((R.id.idMedia));
                TextInputEditText sugestao = (TextInputEditText) findViewById(R.id.idNome);

                Intent i = new Intent(getApplicationContext(), Consulta.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                //RESETA OS CAMPOS//
                curso.setText("");
                media.setRating(0);
                sugestao.setText("");
                curso.requestFocus();

            }
        });

        //CONSULTA MÉDIA GERAL//
        botaoVerificarMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputEditText curso = (TextInputEditText) findViewById(R.id.idCurso);
                RatingBar media = (RatingBar) findViewById((R.id.idMedia));
                TextInputEditText sugestao = (TextInputEditText) findViewById(R.id.idNome);

                Intent i = new Intent(getApplicationContext(), MediaGeral.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                //RESETA OS CAMPOS//
                curso.setText("");
                media.setRating(0);
                sugestao.setText("");
                curso.requestFocus();
            }
        });


    }
}
