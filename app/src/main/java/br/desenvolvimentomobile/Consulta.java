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

public class Consulta extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        final BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{CriacaoBD.CURSO, CriacaoBD.MEDIA, CriacaoBD.SUGESTAO};
        int[] idViews = new int[]{R.id.idCurso, R.id.idMedia, R.id.idSugestao};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);

        if (cursor.getCount() > 0) {
            lista.setAdapter(adaptador);

        } else {
            Toast.makeText(this, "Nenhum registro encontrado", Toast.LENGTH_SHORT).show();
        }


    }
}
