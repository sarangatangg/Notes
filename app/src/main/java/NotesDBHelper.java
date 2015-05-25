package com.spartacus.notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by sarangatangg on 4/22/15.
 */

public class NotesDBHelper extends SQLiteOpenHelper {

    private static NotesDBHelper instance = null;

    public static NotesDBHelper getInstance(Context context){
        if(instance == null ){
            instance = new NotesDBHelper(context);
        }

        return instance;
    }

    public NotesDBHelper(Context context) {
        super(context, NotesDBContract.DATABASE_NAME, null, NotesDBContract.DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotesDBContract.SQL_CREATE_NOTE);
        db.execSQL(NotesDBContract.SQL_CREATE_TAG);
        db.execSQL(NotesDBContract.SQL_CREATE_NOTE_TAG);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NotesDBContract.SQL_DELETE_NOTE_TAG);
        db.execSQL(NotesDBContract.SQL_DELETE_NOTE);
        db.execSQL(NotesDBContract.SQL_DELETE_TAG);
        onCreate(db);
    }
}
