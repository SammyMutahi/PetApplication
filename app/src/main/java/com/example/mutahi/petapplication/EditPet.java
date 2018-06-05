package com.example.mutahi.petapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.mutahi.petapplication.data.petContract.PetEntry;
import com.example.mutahi.petapplication.data.petDbHelper;

public class EditPet extends AppCompatActivity {
    public static final int LOADER_CONSTANT_ID = 22;
    private EditText mPetName;
    private EditText mPetWeight;
    private EditText mPetBreed;
    private EditText mPetGender;
    private petDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pet);
        mPetName = (EditText) findViewById(R.id.pet_name);
        mPetWeight = (EditText) findViewById(R.id.pet_weight);
        mPetBreed = (EditText) findViewById(R.id.pet_breed);
        mPetGender = (EditText) findViewById(R.id.pet_gender);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mDbHelper = new petDbHelper(this);
    }

    private void insertPet() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PetEntry.COLUMN_PET_NAME, mPetName.getText().toString());
        contentValues.put(PetEntry.COLUMN_PET_WEGHT, mPetWeight.getText().toString());
        contentValues.put(PetEntry.COLUMN_PET_BREED, mPetBreed.getText().toString());
        contentValues.put(PetEntry.COLUMN_PET_GENDER, mPetGender.getText().toString());

        long logId = db.insert(PetEntry.TABLE_NAME, null, contentValues);
        Log.v("EditText", "New row id" + logId);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_pet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        int id_insert = item.getItemId();
        if (id_insert == R.id.save_pet) {
            insertPet();
        }
        return super.onOptionsItemSelected(item);
    }

}
