package br.desenvolvimentomobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static br.desenvolvimentomobile.CriacaoBD.CURSO;
import static br.desenvolvimentomobile.CriacaoBD.TABELA;

public class BancoController {

    private SQLiteDatabase db;
    private CriacaoBD banco;

    public BancoController(Context context) {
        banco = new CriacaoBD(context);
    }

    public String insereDado(String curso, double media, String sugestoes) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriacaoBD.CURSO, curso);
        valores.put(CriacaoBD.MEDIA, media);
        valores.put(CriacaoBD.SUGESTAO, sugestoes);

        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Não foi possível inserir sua avaliação, tente novamente.";
        else
            return "Sua avaliação foi inserida com sucesso.";

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.CURSO, banco.MEDIA, banco.SUGESTAO, banco.ID};
        db = banco.getReadableDatabase();
        cursor = db.query(TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaMediaGeral() {
        Cursor cursor;
        db = banco.getReadableDatabase();
        cursor = db.rawQuery( "select (AVG(media)) AS media from "+TABELA, null );

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
