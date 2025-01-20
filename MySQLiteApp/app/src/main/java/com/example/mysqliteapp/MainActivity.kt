package com.example.mysqliteapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mysqliteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var articleDBHelper: ArticleDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        articleDBHelper = ArticleDBHelper(this)

        addToSQL()
        showLogs()
    }

    private fun addToSQL() {
        binding.button.setOnClickListener {
            val newEntry = ContentValues().apply {
                put("Title", binding.tvTitle.text.toString())
                put("Body", binding.tvBody.text.toString())
            }
            binding.tvBody.setText("")
            binding.tvTitle.setText("")
            articleDBHelper.writableDatabase.insert("Article", null, newEntry)
        }
    }

    @SuppressLint("Recycle")
    private fun showLogs() {
        binding.logButton.setOnClickListener {
            val log = articleDBHelper.readableDatabase.rawQuery(
                "SELECT * FROM Article",
                arrayOf<String>()
            )

            while (log.moveToNext()) {
                val id = log.getInt(0)
                val title = log.getString(1)
                val body = log.getString(2)
                Log.d("Article", "$id - $title - $body")
            }
        }
    }
}