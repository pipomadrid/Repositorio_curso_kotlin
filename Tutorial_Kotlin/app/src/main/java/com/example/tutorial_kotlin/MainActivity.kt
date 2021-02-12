package com.example.tutorial_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var miVariable: String // usada como ejemplo *E1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variables()

        println(suma(3, 4))

        resta(6, 3)


    }

    private fun variables() {
        //*********VARIABLES*************

        // var son variables y val constantes
        // las variables pueden cambiar de valor pero no de tipo
        // en kotlin todos los tipos son tratados como objetos

        var num1 = 3   // no hay que especificar el tipo
        val num2 = 3L  // se asigna como Long
        val palabra: String = "hola"

        data class persona(val nombre: String) {}  //data class usada para ejemplo

        val nombrePersona = persona("pedro")

        // usamos la inyección de variables
        println("Num1 es $num1 y Num2 es $palabra")

        //tambien podriamos acceder a atributo  de clases inyectando entre llaves
        println("el atributo a imprimir es ${nombrePersona.nombre}")


        // las variable deben ser inicilizadas
        // es dificil encontrar nullPointerExeption en kotlin
        // si no queremos inicializarla podemos usar lateinit menos en numericos y booleanos
        // ver *E1

        //para controlar los nulos y evitar las excepciones podemos hacer:

        if (this::miVariable.isInitialized) {
            println("el valor de mi variable es $miVariable")
        } else {
            Log.d("MAIN_ACTIVITY", "La variable no ha sido inicializada")
        }

        /*
            * ? --> comprobar que no es nulo
            *  !!  --> asertar que no es nulo
            *  ?:  --> si no
         */

        // si queremos forzar el uso de nulos tendremos que usar ?
        // var myVar:Int = null  esto no compilaria tendriamos que usar:
        var myVar: Int? = null  // estamos forzando a usar null
        // para poder usar esta variable tendriamos checkear el nulo
        // var myVar2= myVar.toDouble()  esto no compilaria tendriamos que operar de esta manera
        var myVar2 = myVar?.toDouble()  // seria como hacer un if
        var myvar3 = myVar?.toDouble()
                ?: 0.1  // esto seria como un if -else , el operador Elvis (?:) actúa como el else
        println("la variable con  ?  es: $myVar2")
        println("la variable con ? y ?: es: $myvar3")

        // si no quisieramos checkear los nulos podemos usar el operador !!
        //No es muy recomendable, se debe usar solo cuando estes seguro de que la variable no será nula

        //var myvar4 = myVar!!.toDouble() // esto compilaria y si myVar es nulo lanzará nullPointerException
    }

    //********FUNCIONES**************
    // se declaran con palabra reservada fun
    //Las funciones Void en kotlin se denominan Unit en vez de Void
    private fun suma(num1: Int, num2: Int): Int {  // funcion con dos parametros Int y devuelve otro Int
        return num1 + num2
    }

    private fun resta(num1: Int, num2: Int) { // no devuelve nada
        println(num1 - num2)
    }

}