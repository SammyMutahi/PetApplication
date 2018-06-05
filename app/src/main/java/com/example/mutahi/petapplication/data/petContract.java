package com.example.mutahi.petapplication.data;

import android.provider.BaseColumns;

/**
 * Created by mutahi on 6/2/2018.
 */

public class petContract {
    private petContract() {
    }

    public static final class PetEntry implements BaseColumns {
        public static final String TABLE_NAME = "pets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_WEGHT = "weight";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
    }
}
