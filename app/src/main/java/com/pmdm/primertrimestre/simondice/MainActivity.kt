package com.pmdm.primertrimestre.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int =0;


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("estado" , "se crea pantalla de inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonJugar: Button = findViewById(R.id.jugar)
        val bverde: Button = findViewById(R.id.verde)
        val brojo: Button = findViewById(R.id.rojo)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val bazul: Button = findViewById(R.id.azul)
        botonJugar.setOnClickListener(){
            mostrarRonda()
            ejecutarSecuencia()
        }



    }

    fun mostrarRonda(){
        contadorRonda++
        val tContador: TextView = findViewById(R.id.contador)
        Log.d("estado" , "aparece marcador de ronda")
        Toast.makeText(this, "Mostramos contador " + contadorRonda, Toast.LENGTH_LONG).show()
        var textocontador: String = contadorRonda.toString()
        Log.d("estado" , "ronda:" + contadorRonda)
        //tContador.setText(contadorRonda)
    }


    fun ejecutarSecuencia(){

        val randomInt = (0..4).random()
        Log.d("estado" , "se ejecuta la secuencia " + randomInt)
        var posicion:Int =0;
        var secuencia: Array<Int> = arrayOf()

        /*
        for(i in 1..contadorRonda) {
            when (randomInt) {

                1 -> secuencia[posicion] = 1;
                2 -> secuencia[posicion] = 2;
                3 -> secuencia[posicion] = 3;
                else -> secuencia[posicion] = 4;

            }
            Log.d("estado" , "se guarda la secuencia " + secuencia[posicion])
            posicion++

        }
*/
        /*
        posicion ++

        var x:Int =0

        while ( x > array.size) {
            val activarsecuencia = when (array[x]) {
                1 -> "corrutina2";
                2 -> "corrutina2";
                3 -> "corrutina2";
                else -> "corrutina2";
            }
            x++


        }

*/
    }


    suspend fun suspenderVerde(bverde: Button){

       // delay(1500L)
    }






}

