package com.example.tutorial_kotlin.ejercicios1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial_kotlin.R

// es la pantalla visual de una app - ficehro kotlin/java y otro XML(diseño)
// muy importante la pila de actividades, si no necesitamos la acitividad anterior hay que terminarla

/*
***************CICLO DE VIDA****************
* On Create  - Lógica de arranque,ocurre sólo una vez en toda la vida de la actividad
* On Start  - Método donde la app inicializa el código que mantiene la IU- nomalmente no lo llamamos nosotros
* On Resume  - El usuario puede trabajar con la UI, estremos en este estado simepre que la actividad no pierda el foco
* la aplicacion esta corriendo
* despues pueden variar la casuistica
* On Pause - cuando la aplicación está parcialemente visible, sepueden realziar acciones para aliviar
*             al S.O por ejemplo bloquear los textos que se visualizan(no se ven los textos, solo una imagen)
* On Stop   - Cuando no veamos la interfaz, detener lo que no sea necesario
* on Restart - si volvemos a la aplicación , sin haber salido
* On Create - volvemos a la app después de salir
* On Destroy  - se destruye la aplicacion saliendo al sistema operativo o usando la función finish
*
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    // para cominicarnos entre componentes Android usamos los Intent
        val intent= Intent(this,MainActivity2::class.java)
        startActivity(intent)
        finish()  // termina la actividad principal y desaparece de la pila
    }
}

