package com.icube.intelli_cube.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.icube.intelli_cube.sqlite.database.model.Cube;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "cubes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Cube.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Cube.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    // TODO: move it somewhere else (?)

    //
    // INSERT...
    //
    public long insertCube(String cubeName) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Cube.COLUMN_NAME, cubeName);

        // insert row
        long id = db.insert(Cube.TABLE_NAME, null, values);

        // close db connnection
        db.close();

        // return newly inserted row id
        return id;
    }

    //
    // GET...
    //
    public Cube getCube(long id) {
        // get readable database as we are not interesting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Cube.TABLE_NAME,
                new String[] {Cube.COLUMN_ID, Cube.COLUMN_NAME, Cube.COLUMN_TIMESTAMP},
                Cube.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        // prepare cube object...
        Cube cube = new Cube(
          cursor.getInt(cursor.getColumnIndex(Cube.COLUMN_ID)),
          cursor.getString(cursor.getColumnIndex(Cube.COLUMN_NAME)),
          cursor.getString(cursor.getColumnIndex(Cube.COLUMN_TIMESTAMP))
        );

        // close db connection
        cursor.close();

        return cube;
    }

    public List<Cube> getAllCubes() {
        List<Cube> cubes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + Cube.TABLE_NAME + " ORDRER BY " +
                Cube.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if(cursor.moveToFirst()) {
            do {
                Cube cube = new Cube();
                cube.setId(cursor.getInt(cursor.getColumnIndex(Cube.COLUMN_ID)));
                cube.setName(cursor.getString(cursor.getColumnIndex(Cube.COLUMN_NAME)));
                cube.setTimestamp(cursor.getString(cursor.getColumnIndex(Cube.COLUMN_TIMESTAMP)));

                cubes.add(cube);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        return cubes;
    }

    public int getCubesCount() {
        String countQuery = "SELECT * FROM " + Cube.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    //
    // UPDATE...
    //
    public int updateCube(Cube cube) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Cube.COLUMN_NAME, cube.getName());

        // updating row
        return db.update(Cube.TABLE_NAME, values, Cube.COLUMN_ID + " =?",
                new String[]{String.valueOf(cube.getId())});
    }

    //
    // DELETE...
    //
    public void deleteCube(Cube cube) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Cube.TABLE_NAME, Cube.COLUMN_ID + " =?",
                new String[]{String.valueOf(cube.getId())});
        db.close();
    }






















}
