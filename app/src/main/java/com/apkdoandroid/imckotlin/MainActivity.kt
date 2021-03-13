package com.apkdoandroid.imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apkdoandroid.imckotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calcular = binding.buttonCalcular
        val mensagem = binding.textViewResultado

        calcular.setOnClickListener {
            val edipeso = binding.editPeso.text.toString()
            val edialtura = binding.editAltura.text.toString()
            if (edipeso.isEmpty()){
            mensagem.setText("Informe o seu peso")
            }else if(edialtura.isEmpty()){
                mensagem.setText("Informe a sua altura")
            }else{
                calcularIMC()
            }
        }
    }

    private fun calcularIMC() {
        val peso = binding.editPeso.text.toString().toDouble()
        val altura = binding.editAltura.text.toString().toDouble()
        val resultado = binding.textViewResultado


        val imc = peso / (altura * altura)
       val mensagem = when{
           imc <= 18.5 -> "Peso baixo"
           imc <= 24.9 -> "Peso normal"
           imc <= 29.9 -> "Sobrepeso"
           imc <= 34.9 -> "Obesidade (Grau 1)"
           imc <= 39.9 -> "Obesidade (Grau 2)"
           else -> "Obsidade Mórbida (Grau 3)"

        }
        imc.toString()
        resultado.setText("IMC: ${imc} \n ${mensagem}")
    }
}