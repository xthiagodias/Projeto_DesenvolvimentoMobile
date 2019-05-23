package br.desenvolvimentomobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

public class CriacaoBD extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bancoAVS.db";
    public static final String TABELA = "avaliacoes";
    public static final String ID = "_id";
    public static final String CURSO = "curso";
    public static final String MEDIA = "media";
    public static final String SUGESTAO = "sugestao";
    private static final int VERSAO = 4;

    public CriacaoBD(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {


            String sql = "CREATE TABLE " + TABELA + "("
                    + ID + " INTEGER primary key autoincrement,"
                    + CURSO + " TEXT NOT NULL,"
                    + MEDIA + " REAL NOT NULL,"
                    + SUGESTAO + " TEXT NOT NULL "
                    + ")";
            db.execSQL(sql);

        } catch (SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }



}
