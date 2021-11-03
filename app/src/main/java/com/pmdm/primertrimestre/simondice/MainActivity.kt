package com.pmdm.primertrimestre.simondice

import android.graphics.Color
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int =0;

    val rojo = Color.alpha(R.color.red)
    val verde = Color.alpha(R.color.green)
    val amarillo = Color.alpha(R.color.yellow)
    val azul = Color.alpha(R.color.blue)

    val rojoClaro = Color.parseColor("#FF4B4B")
    val verdeClaro = Color.parseColor("#93FF4B")
    val amarilloClaro = Color.parseColor("#FFFE00")
    val azulClaro = Color.parseColor("#00FFF9")




    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("estado" , "se crea pantalla de inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonJugar: Button = findViewById(R.id.jugar)

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
        tContador.setText(textocontador)
    }


    fun ejecutarSecuencia(){

        val bverde: Button = findViewById(R.id.verde)
        val brojo: Button = findViewById(R.id.rojo)
        val bazul: Button = findViewById(R.id.azul)
        val bamarillo: Button = findViewById(R.id.amarillo)

        val randomInt = (1..4).random()
        Log.d("estado" , "se ejecuta la secuencia " + randomInt)
        var posicion:Int =0;
        var secuencia: Array<Int> = arrayOf()
        val job = GlobalScope.launch(Dispatchers.Main){
            suspenderVerde(bverde, verdeClaro,  verde)
        }


        //for(i in 1..contadorRonda) {
            when (randomInt) {


                1 -> {
                    val job = GlobalScope.launch(Dispatchers.Main){
                        suspenderVerde(bverde, verdeClaro,  verde)
                    }
                }

                2 -> {
                    val job2 = GlobalScope.launch(Dispatchers.Main){
                        suspenderRojo(brojo, rojoClaro,  rojo)
                    }
                }
                3 -> {
                    val job3 = GlobalScope.launch(Dispatchers.Main){
                        suspenderAzul(bazul, azulClaro,  azul)
                    }
                }
                4 -> {
                    val job4 = GlobalScope.launch(Dispatchers.Main){
                        suspenderAmarillo(bamarillo, amarilloClaro,  amarillo)
                    }
                }

                /*
                1 -> secuencia[posicion] = 1;
                2 -> secuencia[posicion] = 2;
                3 -> secuencia[posicion] = 3;
                else -> secuencia[posicion] = 4;

*/
            }
            //Log.d("estado" , "se guarda la secuencia " + secuencia[posicion])
            //posicion++

        }

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



    suspend fun suspenderVerde(bverde: Button, colorChange : Int, colorDefault: Int){
        bverde.setBackgroundColor(colorChange)
        delay(500L)
        bverde.setBackgroundColor(colorDefault)
    }
    suspend fun suspenderRojo(brojo: Button, colorChange : Int, colorDefault: Int){
        brojo.setBackgroundColor(colorChange)
        delay(500L)
        brojo.setBackgroundColor(colorDefault)
    }
    suspend fun suspenderAzul(brojo: Button, colorChange : Int, colorDefault: Int){
        brojo.setBackgroundColor(colorChange)
        delay(500L)
        brojo.setBackgroundColor(colorDefault)
    }
    suspend fun suspenderAmarillo(bamarillo: Button, colorChange : Int, colorDefault: Int){
        bamarillo.setBackgroundColor(colorChange)
        delay(500L)
        bamarillo.setBackgroundColor(colorDefault)
    }



}




