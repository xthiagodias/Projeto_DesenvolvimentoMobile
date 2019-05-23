package br.desenvolvimentomobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        Handler handle = new Handler();


        //CRIA A HANDLE DE CHAMADA PARA A PROXIMA TELA, INSERIR DADOS, COM 2 SEGUNDOS//
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                irParaAvaliacoes();
            }
        }, 3000);
    }


    private void irParaAvaliacoes() {
        Intent intent = new Intent(TelaSplash.this,
                InserirDados.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

}
