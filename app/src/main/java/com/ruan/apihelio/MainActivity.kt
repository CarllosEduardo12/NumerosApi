package com.ruan.apihelio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {

    private lateinit var textFact: TextView
    private lateinit var inputNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        textFact = findViewById(R.id.textFact)
        inputNumber = findViewById(R.id.inputNumber)

        val btnGetFact: Button = findViewById(R.id.btnGetFact)
        val btnGetDate: Button = findViewById(R.id.btnGetDate)
        val btnGetYear: Button = findViewById(R.id.btnGetYear)
        val btnMath: Button = findViewById(R.id.btnMath)
        val btnTrivia: Button = findViewById(R.id.btnTrivia)

        btnGetFact.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val fact = ApiCliente.instance.getRandomNumber()
                    textFact.text = fact.text
                } catch (e: Exception) {
                    textFact.text = "Erro: ${e.message}"
                }
            }
        }

        btnGetDate.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val fact = ApiCliente.instance.getRandomDateFact()
                    textFact.text = fact.text
                } catch (e: Exception) {
                    textFact.text = "Erro: ${e.message}"
                }
            }
        }

        btnGetYear.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val fact = ApiCliente.instance.getRandomYear()
                    textFact.text = fact.text
                } catch (e: Exception) {
                    textFact.text = "Erro: ${e.message}"
                }
            }
        }

        btnMath.setOnClickListener {
            val number = inputNumber.text.toString()
            if (number.isNotEmpty()) {
                lifecycleScope.launch {
                    try {
                        val fact = ApiCliente.instance.getMathFact(number.toInt())
                        textFact.text = fact.text
                    } catch (e: Exception) {
                        textFact.text = "Erro: ${e.message}"
                    }
                }
            } else {
                textFact.text = "Digite um número primeiro."
            }
        }

        btnTrivia.setOnClickListener {
            val number = inputNumber.text.toString()
            if (number.isNotEmpty()) {
                lifecycleScope.launch {
                    try {
                        val fact = ApiCliente.instance.getTriviaFact(number.toInt())
                        textFact.text = fact.text
                    } catch (e: Exception) {
                        textFact.text = "Erro: ${e.message}"
                    }
                }
            } else {
                textFact.text = "Digite um número primeiro."
            }
        }
    }
}