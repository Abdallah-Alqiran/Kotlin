package com.example.mysqliteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ArticleDBHelper(context: Context) : SQLiteOpenHelper(context, "Article", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val data = "CREATE TABLE Article (" +
                "ID INTEGER PRIMARY KEY NOT NULL," +
                "Title TEXT NOT NULL," +
                "Body TEXT NOT NULL )"
        db?.execSQL(data)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}


}