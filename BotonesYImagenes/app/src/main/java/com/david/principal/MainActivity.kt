package com.david.principal

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

data class fotos(val url: String, val idFoto:Int , val descripcion:String   )


class MainActivity : AppCompatActivity() {

    val foto1 = fotos("https://bit.ly/35KZQpK",1,"Esta fue de las primeras fotos que tomamos con mi cel")
    val foto2 = fotos("https://bit.ly/3ktWifO",2,"Aunque tengas un ojo borroso me encanta la cara tan linda que tienes en esta")
    val foto3 = fotos("https://bit.ly/33xvXGA",3,"De las primeras veces que fuimos a galerias esta fue en navidad")
    val foto4 = fotos("https://bit.ly/33I96bL",4,"Aun recuerdo cuando estabamos arriba de la mega torre y si no te digo que traes lo lentes ni te acuerdas")
    val foto5 = fotos("https://bit.ly/2RDhLqk",5,"Mi foto favorita <3")
    val foto6 = fotos("https://bit.ly/3cgJNRN",6,"Ese paseo en bicicleta fue increible")
    val foto7 = fotos("https://bit.ly/2FImRyS",7,"Jamas habia sido voluntario de nada ni me acuerdo por que fui, solo se que fue por ti")
    val foto8 = fotos("https://bit.ly/3ktMGBy",8,"Si vez esta foto recuerdame de cuando fue jeje")
    val foto9 = fotos("https://bit.ly/2FFhoJh",9,"y como olvidar nuestra primer foto como novios")
    val foto10 = fotos("https://bit.ly/2FQrSVL",10,"Quiero que siempre estes conmigo! te amo y si vez esto yo gano :P ")
    var fotoPorDefecto = foto1.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //asi se crea un mediaplayer con una cancion en kotlin
        val mp = MediaPlayer.create(this,R.raw.song)
        val boton2 = findViewById(R.id.buttonCancion) as Button
        boton2.setOnClickListener{
            view-> mp.start()
        }


        verEnPantalla("Si presionas el boton veras los fotos muy lindas y un lindo mensaje")
        Glide.with(this).load("https://bit.ly/35TyayS")
            .placeholder(android.R.drawable.btn_default).into(imgImagen)

        //Accionador del boton
        val boton = findViewById(R.id.btn_boton) as Button
        boton.setOnClickListener{
                view -> switchFoto(fotoPorDefecto)

                Glide.with(this).load(fotoPorDefecto.url)
                .placeholder(android.R.drawable.btn_default).into(imgImagen)

        }



    }

    fun switchFoto(foto:fotos){
        fotoPorDefecto = foto.copy()
        //when es la forma en como se crea el switch

        when(foto.idFoto){
            1 -> fotoPorDefecto= foto2.copy()
            2 -> fotoPorDefecto= foto3.copy()
            3 -> fotoPorDefecto= foto4.copy()
            4 -> fotoPorDefecto= foto5.copy()
            5 -> fotoPorDefecto= foto6.copy()
            6 -> fotoPorDefecto= foto7.copy()
            7 -> fotoPorDefecto= foto8.copy()
            8 -> fotoPorDefecto= foto9.copy()
            9 -> fotoPorDefecto= foto10.copy()
            10 -> fotoPorDefecto= foto1.copy()
            else -> print("Eso jamas va a pasar")
        }
        verEnPantalla(fotoPorDefecto.descripcion)

    }

    fun verEnPantalla(s:String){
        val txt = findViewById(R.id.txtMensaje) as TextView
        txt.setText(s)
    }


}