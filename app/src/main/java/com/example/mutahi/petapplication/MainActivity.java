package com.example.mutahi.petapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mutahi.petapplication.data.petContract.PetEntry;
import com.example.mutahi.petapplication.data.petDbHelper;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PetAdapter mPetAdapter;
    private petDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_display);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setHasFixedSize(true);
        mPetAdapter = new PetAdapter();
        mRecyclerView.setAdapter(mPetAdapter);
        mDbHelper = new petDbHelper(this);
        DisplayResults();
    }

    private void DisplayResults() {
        petDbHelper mDbHelper = new petDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + PetEntry.TABLE_NAME + " ORDER BY " + PetEntry._ID, null);
        try {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    mPetAdapter.setPetData(cursor.getColumnNames());

                }
            }
        } finally {
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_new_pet) {
            Intent intent = new Intent(MainActivity.this, EditPet.class);
            startActivity(intent);
        }
        int id_delete = item.getItemId();
        if (id_delete == R.id.delete_pets) {

        }
        return super.onOptionsItemSelected(item);
    }
}
