package com.example.tutorial_kotlin.basesKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tutorial_kotlin.R

class BasesKotlin : AppCompatActivity() {
    lateinit var miVariable: String // usada como ejemplo *E1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variables
        variables()
        //funciones
        println("********FUNCIONES**************")
        println(suma(3, 4))

        resta(6, 3)

        //clases abstractas
        println("*********CLASES ABSTRACTAS***********")
        val avion= Avion(1200, "seat")
        avion.arrancar()
        avion.detener()

        println("********ARRAYS**************")

        arrays()

        listas()

        mapas()
    }

    private fun variables() {
        //*********VARIABLES*************

        // var son variables y val constantes
        // las variables pueden cambiar de valor pero no de tipo
        // en kotlin todos los tipos son tratados como objetos

        var num1 = 3   // no hay que especificar el tipo
        val num2 = 3L  // se asigna como Long
        val palabra: String = "hola"

        data class persona(val nombre: String) {}  //data class usada para ejemplo, tiene que tener al menos un constructor

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
// ************CLASES ABSTRACTAS**************

    // Funcionamiento parecido Java

    abstract class Transporte{
        protected  var capacidad: Int=0
        protected  lateinit var  marca :String

        fun arrancar(){  // Esta función la heredaría las clase que hereden de transporte
         // si quisiera modificar esta funcion en las clases hinjas tendria que añadir open:

         // open fun arrancar()......
         // también se usa el open para hacer que una clase puede ser heredada por otras
            //open class Avion{........}
            // class Avinoneta: Avion{.......}
            println("El Transporte está arrancando")
        }
        abstract fun detener() // Esta función la deberán implementar las clases que hereden de transporte

    }

    class Avion : Transporte {
        constructor(capacidad:Int, marca:String)

        override fun detener() {
            println("El Avión se está deteniendo")
        }

    }


    // *********ARRAYS****************

    // tenemos la clase Array y tenemos diferentes formas de inicializarlos:
    /*
      1 -- val pares = Array<Int>(10) {i -> (i+1) * 2}     Usa indice, necesita instanciación
      2 -- var semana = arrayOf<String>("Lunes", "Martes".....)   No usa Indice , iniciamos array con datos
      3 -- var colores = arrayOfNulls<String>      Crea un array de nulos
     */
    fun arrays(){
        // 1
        val numeros = Array<String>(5){
            "Numero: $it"  //  el it corresponde al iterador por defecto que va aumentando en cada vuelta
        }

        // tb se puede personalizar el it
        val numeros2 = Array<String>(5){num -> "Prueba segunda Numero: ${num+1}"}
        for(i in numeros){
            println(i)
        }
        for(i in numeros2){
            println(i)
        }

        //2
        val colores = arrayOf("Rojo", "Azul", "Amarillo") // inicialización obligatoria

        for(i in colores){println(i)}
        //3

        val todoSePuede = arrayOfNulls<Int>(5) // podemos llenarlo más tarde
        for(i in todoSePuede){println(i)}

        todoSePuede[0]= 23
        todoSePuede[1]= 25
        for(i in todoSePuede){println(i)}

    }

    //************LISTAS************************
    // muy util cuando no sabemos el tamaño que vamos a necesitar
    // hay list y MutableList--> List no se puede modificar, MutableList si.

     fun listas() {
         println("*************LISTAS*************")
         // listas inmutables
         val colores = listOf("Rojo", "Azul", "Verde", null) // tamaño inmutable, solo lectura
         for (i in colores) {
             println(i)
         }

         val ejemplo = listOfNotNull(null, "Pedro") //comprueba si hay valores nulos y los descarta

         // lista mutable

         val lista = mutableListOf<String>("pedro", "juan", "felipe")

         lista[0] = "Sara"
         lista.add("pepito")
         for (i in 0 until lista.size) {
             println(lista.get(i))
         }  // otra forma de hacer el bucle

         lista.forEach { println(it) }   // otra forma de hacer el for, usa el it como iterador

         lista.forEachIndexed { index, s ->     // esta forma nos facilita el uso de el indice y asi evitartener que declarar una variable
             println("la posicion ${index + 1} pertenece a $s")

         }
     }


         fun mapas(){

             // es una estructura para guardar datos
             // optimizada para insertar y recuperar pero no apra recorrer de principio a fin
             // cada valor está identificado mediante un atributo, no se pueden repetir
             // es como un diccionario real, la clave y valor pueden ser de cualquier tipo
             // cada item del mapa estácompuesto por una Entry<K,V>
             // existen Map y MutableMap

            data class Planeta(val pos:Int, val nombre: String, val habitable: Boolean){
                override fun toString(): String {
                    return "Planeta(Posición : $pos, nombre : $nombre , ¿es habitable?: ${
                        if (habitable) "SI"
                        else "NO"
                    })"
                }

            }
             val mercurio = Planeta(1,"Mercurio",false)
             val venus = Planeta(2,"Venus",false)
             val tierra = Planeta(3,"Tierra",true)
             val marte = Planeta(4,"Marte",false)

             val planetas = mutableMapOf<String,Planeta>()
             planetas.put("mercurio",mercurio)
             planetas.put("venus",venus)
             println(planetas.get("mercurio"))

             val planetasInt = mapOf<String,List<Planeta>>( // mapa donde el valor es una lista de planetas
                     "interiores" to listOf(mercurio, venus, tierra,marte)
             )
             println(planetasInt.get("interiores"))

         }


}