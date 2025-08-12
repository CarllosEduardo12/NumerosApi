package com.ruan.apihelio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var textFact: TextView
    private lateinit var btnGetFact: Button
    private lateinit var btnGetDate: Button
    private lateinit var btnGetYear: Button
    private lateinit var btnMath: Button
    private lateinit var btnTrivia: Button
    private lateinit var inputNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFact = findViewById(R.id.textFact)
        btnGetFact = findViewById(R.id.btnGetFact)
        btnGetDate = findViewById(R.id.btnGetDate)
        btnGetYear = findViewById(R.id.btnGetYear)
        btnMath = findViewById(R.id.btnMath)
        btnTrivia = findViewById(R.id.btnTrivia)
        inputNumber = findViewById(R.id.inputNumber)

        btnGetFact.setOnClickListener { fetchRandomNumber() }
        btnGetDate.setOnClickListener { fetchRandomDateFact() }
        btnGetYear.setOnClickListener { fetchRandomYear() }
        btnMath.setOnClickListener { fetchMathFact() }
        btnTrivia.setOnClickListener { fetchTriviaFact() }
    }

    private fun fetchRandomNumber() {
        lifecycleScope.launch {
            try {
                val response = ApiCliente.instance.getRandomNumber()
                textFact.text = response.text
            } catch (e: Exception) {
                textFact.text = "Erro: ${e.message}"
            }
        }
    }

    private fun fetchRandomDateFact() {
        lifecycleScope.launch {
            try {
                val response = ApiCliente.instance.getRandomDateFact()
                textFact.text = response.text
            } catch (e: Exception) {
                textFact.text = "Erro: ${e.message}"
            }
        }
    }

    private fun fetchRandomYear() {
        lifecycleScope.launch {
            try {
                val response = ApiCliente.instance.getRandomYear()
                textFact.text = response.text
            } catch (e: Exception) {
                textFact.text = "Erro: ${e.message}"
            }
        }
    }

    private fun fetchMathFact() {
        val num = inputNumber.text.toString().toIntOrNull()
        if (num != null) {
            lifecycleScope.launch {
                try {
                    val response = ApiCliente.instance.getMathFact(num)
                    textFact.text = response.text
                } catch (e: Exception) {
                    textFact.text = "Erro: ${e.message}"
                }
            }
        } else {
            textFact.text = "Digite um número válido."
        }
    }

    private fun fetchTriviaFact() {
        val num = inputNumber.text.toString().toIntOrNull()
        if (num != null) {
            lifecycleScope.launch {
                try {
                    val response = ApiCliente.instance.getTriviaFact(num)
                    textFact.text = response.text
                } catch (e: Exception) {
                    textFact.text = "Erro: ${e.message}"
                }
            }
        } else {
            textFact.text = "Digite um número válido."
        }
    }
}
