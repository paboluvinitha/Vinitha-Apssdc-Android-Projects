package com.example.newsaggregator.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.newsaggregator.model.Articles;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FavDbHelper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NewsReader.db";
    public static final String DATABASE_TABLE="Favourite_table";
   /* private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NewsReaderContract.NewsEntry.TABLE_NAME + " (" +
                    NewsReaderContract.NewsEntry._ID + " INTEGER PRIMARY KEY," +
                    NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_TITLE + " TEXT," +
                    NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_URL + " TEXT," +
                    NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_JSON + " TEXT, UNIQUE(" +
                    NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_TITLE + "," +
                    NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_URL + "))";
    private static final String SQL_FETCH_ENTRIES = "SELECT * FROM " + NewsReaderContract.NewsEntry.TABLE_NAME;
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + NewsReaderContract.NewsEntry.TABLE_NAME;
*/

    public static final String dbname="mu";
    public static final String db_table="students";
    public static final int db_version=1;
    public static final String col_0="id";
    public static final String col_1="name";
    public static final String col_2="age";
    public static final String query="create table "+db_table+"("+col_0+" integer primary key autoincrement,"+col_1+" text unique,"+col_2+" integer);";
    /* private Gson gson;*/
    public FavDbHelper(@Nullable Context context ) {
        super(context, dbname, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+db_table);
        onCreate(sqLiteDatabase);

    }
    public long insertValues(ContentValues cv){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        long row=sqLiteDatabase.insert(db_table,null,cv);
        return row;


    }
    public Cursor retrieveValues(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from " +db_table,null);
        return c;
    }


   /* public boolean insertNews(Articles newsArticle) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        newsArticle.setArticleSaved(true);
        values.put(NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_TITLE, newsArticle.getTitle());
        values.put(NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_URL, newsArticle.getUrl());
        values.put(NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_JSON, gson.toJson(newsArticle));
        long newRowId = db.insertWithOnConflict(NewsReaderContract.NewsEntry.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        return newRowId != -1;
    }*/

    /*public List<Articles> getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Articles> articleList = new ArrayList<>();
        Cursor cursor = db.rawQuery(SQL_FETCH_ENTRIES, null);
        while (cursor.moveToNext()) {
            articleList.add(gson.fromJson(cursor.getString(3), Articles.class));
        }
        cursor.close();
        return articleList;
    }*/

    /*public int deleteNewsArticle(Articles article) {
        SQLiteDatabase db = this.getWritableDatabase();
        int delete = db.delete(NewsReaderContract.NewsEntry.TABLE_NAME, NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_URL + "=? and " + NewsReaderContract.NewsEntry.COLUMN_NAME_ARTICLE_TITLE + "=?",
                new String[]{article.getUrl(), article.getTitle()});
        db.close();
        return delete;
    }*/
}