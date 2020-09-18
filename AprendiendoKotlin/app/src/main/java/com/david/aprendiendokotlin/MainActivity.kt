package com.david.aprendiendokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


data class PiezasPC(val nombre: String, val idPieza:Int)


class MainActivity : AppCompatActivity() {

    val tarjetaMadre = PiezasPC("AX270 Gamming",1233)
    val MemoriaRam = PiezasPC("XPG RGB 16GB",1234)
    val DiscoDuro = PiezasPC("Kingstone SDD",1235)
    val FuenteDePoder = PiezasPC("Corsair 650w 80+ B",1236)
    var PiezaPorDefecto = tarjetaMadre.copy()

    //Constructor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val txt = findViewById(R.id.mensaje) as TextView
        //txt.setText("La pieza de la pc es ${PiezaPorDefecto.nombre} con su id de ${PiezaPorDefecto.idPieza}")
        verEnPantalla("Si presionas el boton veras los componentes de mi pc :3")

        //Accionador del boton
        val boton = findViewById(R.id.btnPrimerBoton) as Button
        boton.setOnClickListener{
            view -> switchPieza(PiezaPorDefecto)
        }

    }

    //Esta Funcion hace que cambie de piezas cada que se da click en el boton
    //por defecto los parametros son inmutables
    fun switchPieza(pieza:PiezasPC){
        PiezaPorDefecto = pieza.copy()
        //when es la forma en como se crea el switch

        when(pieza.idPieza){
            1233 -> PiezaPorDefecto= MemoriaRam.copy()
            1234 -> PiezaPorDefecto= DiscoDuro.copy()
            1235 -> PiezaPorDefecto=FuenteDePoder.copy()
            1236 -> PiezaPorDefecto=tarjetaMadre.copy()
            else -> print("Eso jamas va a pasar")
        }
        //aqui se concatena con el ${}
        verEnPantalla("La pieza de la pc es ${PiezaPorDefecto.nombre} con su id de ${PiezaPorDefecto.idPieza}")




    }

    //Esta funcion hace que el texto en pantalla cambie
    fun verEnPantalla(s:String){
        val txt = findViewById(R.id.mensaje) as TextView
        txt.setText(s)
    }
}