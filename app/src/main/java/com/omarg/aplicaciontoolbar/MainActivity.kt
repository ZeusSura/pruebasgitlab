package com.omarg.aplicaciontoolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {


    var toolbar: Toolbar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar_main)
        toolbar?.setTitle(R.string.toolbarTitleMain)
        setSupportActionBar(toolbar)

    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main,menu)
        var itemBusqueda = menu?.findItem(R.id.toolbar_busqueda_main)
        val itemCompartir = menu?.findItem(R.id.action_share)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView

        val shareProvider = MenuItemCompat.getActionProvider(itemCompartir) as ShareActionProvider
        compartirIntent(shareProvider)
        vistaBusqueda.queryHint="Escribe tu nombre..."

        vistaBusqueda.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("onQueryTextSubmit",query)
                return  true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("onQueryTextChange",newText)
                return  true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {

            R.id.action_fav->{
                Toast.makeText(applicationContext,"Elemento añadido a favorito",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,SegundaActivity::class.java)
                var listaUsuarios = generateUsuarios()
                var gson=Gson()
                var listaString =gson.toJson(listaUsuarios)
                intent.putExtra("listaUsuarios",listaString)
                startActivity(intent)
            }
            else ->  return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }



    private fun compartirIntent(actionProvider: ShareActionProvider) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Este es un mensaje compartir")
        actionProvider.setShareIntent(intent)
    }


    private fun generateUsuarios():ArrayList<Usuario>{

        var listaUsuarios = arrayListOf<Usuario>()
        listaUsuarios.add(Usuario(1,"Omar Alejandro Guzman Herera","ADMIN_ROLE"))
        listaUsuarios.add(Usuario(6,"Renato Placencia Jr","ADMIN_ROLE"))
        listaUsuarios.add(Usuario(3,"Jaime Diego Misael","ADMIN_ROLE"))
        listaUsuarios.add(Usuario(2,"Diego Alonso","ADMIN_ROLE"))
        listaUsuarios.add(Usuario(4,"Sara calderon Arellano","USER_ROLE"))
        listaUsuarios.add(Usuario(5,"Alicia Gastelum Mora","USER_ROLE"))
        listaUsuarios.add(Usuario(6,"Daniel ","USER_ROLE"))
        return listaUsuarios
    }



}
