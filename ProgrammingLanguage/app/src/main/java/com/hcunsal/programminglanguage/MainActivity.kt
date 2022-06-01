package com.hcunsal.programminglanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hcunsal.programminglanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var languageList = ArrayList<Language>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val java = Language("Java", "1995", R.drawable.java)
        val cplusplus = Language("C++", "1983", R.drawable.cplusplus)
        val python = Language("Python", "1990", R.drawable.python)

        languageList.add(java)
        languageList.add(cplusplus)
        languageList.add(python)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var languageAdapter = LanguageAdapter(languageList)
        binding.recyclerView.adapter = languageAdapter


    }
}