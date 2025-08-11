package com.ruan.apihelio

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.ruan.apihelio.NumbersResponse

class MainActivity : AppCompatActivity() {

    private lateinit var textFact: TextView
    private lateinit var btnGetFact: Button
    private lateinit var btnGetDate: Button
    private lateinit var btnGetYear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFact = findViewById(R.id.textFact)
        btnGetFact = findViewById(R.id.btnGetFact)
        btnGetDate = findViewById(R.id.btnGetDate)
        btnGetYear = findViewById(R.id.btnGetYear)

        btnGetFact.setOnClickListener{
            getRandomNumber()
        }

        btnGetDate.setOnClickListener{
            getRandomDateFact()
        }

        btnGetYear.setOnClickListener{
            getRandomYear()
        }

        getRandomYear()
        getRandomDateFact()
        getRandomNumber()
    }

    private fun getRandomNumber() {
        val call = ApiCliente.instance.getRandomNumber()
        call.enqueue(object : Callback<NumbersResponse> {
            override fun onResponse(
                call: Call<NumbersResponse>,
                response: Response<NumbersResponse>
            ) {
                if (response.isSuccessful) {
                    val numberFact = response.body()
                    textFact.text = numberFact?.text ?: "Fato não encontrado"
                } else {
                    textFact.text = "Erro na resposta: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<NumbersResponse>, t: Throwable) {
                textFact.text = "Falha: ${t.message}"
            }
        })
    }

    private fun getRandomDateFact() {
        val call = ApiCliente.instance.getRandomDateFact()
        call.enqueue(object : Callback<NumbersResponse> {
            override fun onResponse(call: Call<NumbersResponse>, response: Response<NumbersResponse>) {
                if (response.isSuccessful) {
                    val dateFact = response.body()
                    textFact.text = dateFact?.text ?: "Fato não encontrado"
                } else {
                    textFact.text = "Erro na resposta: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<NumbersResponse>, t: Throwable) {
                textFact.text = "Falha: ${t.message}"
            }
        })
    }

    private fun getRandomYear() {
        val call = ApiCliente.instance.getRandomYear()
        call.enqueue(object : Callback<NumbersResponse> {
            override fun onResponse(call: Call<NumbersResponse>, response: Response<NumbersResponse>) {
                if (response.isSuccessful) {
                    val yearFact = response.body()
                    textFact.text = yearFact?.text ?: "Fato não encontrado"
                } else {
                    textFact.text = "Erro na resposta: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<NumbersResponse>, t: Throwable) {
                textFact.text = "Falha: ${t.message}"
            }
        })
    }
}