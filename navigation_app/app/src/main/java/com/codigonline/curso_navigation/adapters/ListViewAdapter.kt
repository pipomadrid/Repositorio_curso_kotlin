package com.codigonline.curso_navigation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codigonline.curso_navigation.databinding.ItemProductoListViewBinding
import com.codigonline.curso_navigation.models.Producto


// listview es una view de android que nops permite crear un elemento tantas veces como sea necesario en forma de lista ,un elemento debajo  de otro
// incluye una scrollbar automáticamente
/*
para crear  un Listview necesitamos 3 componentes:
    Listaview - dentro del layout donde se va a mostrar
    Adaptador - clase que rellena el list view item a item
    Item Layout  - layout utilizaado con la estructura deseada (ejm  android.R.layout.simple_list_item_1  = es un layout preprogamado por android)
    Los datos se envian al adaptador y de este a la lista
 */

class ListViewAdapter(context: Context, val vista: Int, val productos: List<Producto>)
    : ArrayAdapter<Producto>(context, vista, productos) {


    //SE INVOCARÁ TANTAS VECES COMO ELEMENTOS EXISTAN EN LA LISTA

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(vista, null)
        }
        //INFLATE ES CUANDO QUEREMOS INFLAR LA VISTA EN EL BINDING
        //BIND ES SOLO CUANDO QUEREMOS VINCULARLA A UNA QUE YA EXISTE

        val binding = ItemProductoListViewBinding.bind(view!!)

        val producto = productos[position]

        binding.itemProductoId.text = producto.id.toString()
        binding.itemProductoNombre.text = producto.nombre
        binding.itemProductoClases.text = producto.clases.toString()
        binding.itemProductoDescripcion.text = producto.descripcion
        binding.itemProductoPrecio.text = producto.precio.toString()

        return view

    }

}