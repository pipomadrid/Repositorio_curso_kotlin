package com.example.tutorial_kotlin.Envio_Datos_Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import com.example.tutorial_kotlin.R
// podemos enviar datos entre Activities gracias a los Intent usando putExtra
// Se usará un mapa <String,V> y los recibirá otra activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
       /* val intent= Intent(this,MainActivity2::class.java)
        intent.putExtra("numero",20) //  enviamos el par clave valor a la acitivity 2
        startActivity(intent)*/

        // podemos diferenciar los Intent en Implicitos y Explicitos
         // Explicitos- conocemos el nombre del componente
         // Implicitos - no conocemos el nombre, es un elemento controlado por el S.O y accederemos
        //   a el mediante un ACTION (Camara, Teléfono.....)

        val intent = Intent(AlarmClock.ACTION_SET_ALARM)  // nos manda al despertador con
        // la configuracion que le indicamos,
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Despiertate")
        intent.putExtra(AlarmClock.EXTRA_HOUR,5)
        startActivity(intent)

        // DISEÑO
        // primero estaba MATERIAL DESIGN - Guias de diseño marcadas por google( desde android 4.4)
        // todas app debian seguir estas normas, eran todas muy parecidas
        //sacan MATERIAL THEMING - da algo más de libertad

        // Para elegir colores podemos ir a la web MAterial Colors y elegir una combinación de colores
        // que nos agrade , descargarlos para android , copiar y pegar en Values/colors
        // una vez tenemos los colores en colors hay que ir a themes para configurarlos

        //*******CONSTRAINT LAYOUT************

        // Se recomienda comenzar el diseño de los componentes de abajo a arriba
        // poner id  con @id:/  por ejemplo  @id:/main_boton1
        // se pueden usar guias para ajustar los Views
        // Se recomienda indicar las restricciones en el código
        // mejor usar Material Desing en vez de los elementos que hay en diseño ,+ opciones
        // ***********************Ver layout activity_main.xml4 *****************************

    }
}