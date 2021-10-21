package com.pmdm.primertrimestre.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int =0;


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("estado" , "se crea pantalla de inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val botonJugar: Button = findViewById(R.id.jugar)
        botonJugar.setOnClickListener(){
            mostrarRonda()
            ejecutarSecuencia()
        }


    }
    val tContador: TextView = findViewById(R.id.contador)
    fun mostrarRonda(){
        Log.d("estado" , "aparece marcador de ronda")
        tContador.setText(contadorRonda)
    }
    fun ejecutarSecuencia(){
        Log.d("estado" , "se ejecuta la secuencia")

        val randomInt = (0..4).random()
        var posicion:Int =0;
        var array=emptyArray<Int>()
        val drawableResource = when (randomInt) {
            1 -> array[posicion] = 1;
            2 -> array[posicion] = 2;
            3 -> array[posicion] = 3;
            else -> array[posicion] = 4;
        }


    }






}

