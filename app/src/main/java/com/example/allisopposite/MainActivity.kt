package com.example.allisopposite

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var resultOfConvert: TextView
    private lateinit var symbolsOnResult: TextView
    private lateinit var buttonConvert: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inputText = findViewById(R.id.inputText)
        resultOfConvert = findViewById(R.id.resultOfConvert)
        symbolsOnResult = findViewById(R.id.symbolsOnResult)
        buttonConvert = findViewById(R.id.buttonConvert)

        clickToButton(buttonConvert)
    }

    fun clickToButton(view: View) {
        val text = inputText.text
        resultOfConvert.text = text.reversed()
        symbolsOnResult.text = (text.filterNot { it == ' ' }).length.toString()
    }
}