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
    var contadorRonda: Int = 0;
    var secuencia = ArrayList<Int>()
    var posicion: Int = 0;

    val rojo = Color.alpha(R.color.red)
    val verde = Color.alpha(R.color.green)
    val amarillo = Color.alpha(R.color.yellow)
    val azul = Color.alpha(R.color.blue)

    val rojoClaro = Color.parseColor("#FF4B4B")
    val verdeClaro = Color.parseColor("#93FF4B")
    val amarilloClaro = Color.parseColor("#FFFE00")
    val azulClaro = Color.parseColor("#00FFF9")


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("estado", "se crea pantalla de inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonJugar: Button = findViewById(R.id.jugar)

        val brojo: Button = findViewById(R.id.rojo)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val bazul: Button = findViewById(R.id.azul)
        botonJugar.setOnClickListener() {
            mostrarRonda()
            ejecutarSecuencia()
        }


    }

    fun mostrarRonda() {
        val tContador: TextView = findViewById(R.id.contador)
        contadorRonda++
        tContador.text=( "RONDA: "+contadorRonda.toString())
        Log.d("estado", "aparece marcador de ronda")
        Toast.makeText(this, "Mostramos contador " + contadorRonda, Toast.LENGTH_LONG).show()

        Log.d("estado", "ronda:" + contadorRonda)

    }


    fun ejecutarSecuencia() {

        val bverde: Button = findViewById(R.id.verde)
        val brojo: Button = findViewById(R.id.rojo)
        val bazul: Button = findViewById(R.id.azul)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val randomInt = (1..4).random()
        Log.d("estado", "se ejecuta la secuencia " + randomInt)




        //for(i in 1..contadorRonda) {

        when (randomInt) {


            1 -> {
                secuencia.add(1)
            }
            2 -> {
                secuencia.add(2)
            }
            3 -> {
                secuencia.add(3)
            }
            4 -> {
                secuencia.add(4)
            }

            /*
                1 -> secuencia[posicion] = 1;
                2 -> secuencia[posicion] = 2;
                3 -> secuencia[posicion] = 3;
                else -> secuencia[posicion] = 4;

*/
        }
        println(secuencia)
        //Log.d("estado" , "se guarda la secuencia " + secuencia[posicion])
        //posicion++
        posicion=0
        for (i in 1..contadorRonda) {


        when (secuencia[posicion]) {


            1 -> {
                val job = GlobalScope.launch(Dispatchers.Main) {
                    suspenderVerde(bverde, verdeClaro, verde)
                }
            }

            2 -> {
                val job2 = GlobalScope.launch(Dispatchers.Main) {
                    suspenderRojo(brojo, rojoClaro, rojo)
                }
            }
            3 -> {
                val job3 = GlobalScope.launch(Dispatchers.Main) {
                    suspenderAzul(bazul, azulClaro, azul)
                }
            }
            4 -> {
                val job4 = GlobalScope.launch(Dispatchers.Main) {
                    suspenderAmarillo(bamarillo, amarilloClaro, amarillo)
                }
            }

        }
            posicion++



    }
    }

        fun comprobarSecuencia(){

        }








        suspend fun suspenderVerde(bverde: Button, colorChange: Int, colorDefault: Int) {
            bverde.setBackgroundColor(colorChange)
            delay(500L)
            bverde.setBackgroundColor(colorDefault)
            delay(500L)
        }

        suspend fun suspenderRojo(brojo: Button, colorChange: Int, colorDefault: Int) {
            brojo.setBackgroundColor(colorChange)
            delay(500L)
            brojo.setBackgroundColor(colorDefault)
            delay(500L)
        }

        suspend fun suspenderAzul(brojo: Button, colorChange: Int, colorDefault: Int) {
            brojo.setBackgroundColor(colorChange)
            delay(500L)
            brojo.setBackgroundColor(colorDefault)
            delay(500L)
        }

        suspend fun suspenderAmarillo(bamarillo: Button, colorChange: Int, colorDefault: Int) {
            bamarillo.setBackgroundColor(colorChange)
            delay(500L)
            bamarillo.setBackgroundColor(colorDefault)
            delay(500L)
        }


    }





