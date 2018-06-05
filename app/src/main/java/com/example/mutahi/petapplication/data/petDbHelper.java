package com.example.mutahi.petapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mutahi.petapplication.data.petContract.PetEntry;

/**
 * Created by mutahi on 6/2/2018.
 */

public class petDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "home.db";
    private static final int DATABASE_VERSION = 1;

    public petDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String pets_table = "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_WEGHT + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_GENDER + " TEXT NOT NULL, );";
        db.execSQL(pets_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
