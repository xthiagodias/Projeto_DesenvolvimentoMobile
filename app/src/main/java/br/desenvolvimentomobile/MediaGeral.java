package br.desenvolvimentomobile;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import static br.desenvolvimentomobile.CriacaoBD.TABELA;

public class MediaGeral extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_geral);

        final BancoController crud = new BancoController(getBaseContext());
        Cursor cursor1 = crud.carregaDados();


        String[] nomeCampos = new String[]{CriacaoBD.CURSO, CriacaoBD.MEDIA, CriacaoBD.SUGESTAO};
        int[] idViews = new int[]{R.id.idCursoAvaliado, R.id.idMediaGeral, R.id.idMensagem};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_media_cursos, cursor1, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView2);

        if (cursor1.getCount() > 0) {
            lista.setAdapter(adaptador);

        } else {
            Toast.makeText(this, "Nenhum registro encontrado", Toast.LENGTH_SHORT).show();
        }


    }
}
