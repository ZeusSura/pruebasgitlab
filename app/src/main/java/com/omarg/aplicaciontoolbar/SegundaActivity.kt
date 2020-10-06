package com.omarg.aplicaciontoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.gson.Gson

class SegundaActivity : AppCompatActivity() {

    var toolbar: Toolbar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        val intent = intent.extras
        val listaStringUsuarios = intent?.getString("listaUsuarios")
        val gson= Gson()
        val listaUsuario =gson.fromJson(listaStringUsuarios,ArrayList<Usuario>()::class.java)
        Toast.makeText(applicationContext,listaStringUsuarios,Toast.LENGTH_SHORT).show()
        configurateToolbar()
    }

    fun configurateToolbar()
    {
        toolbar = findViewById(R.id.toolbar_main)
        toolbar?.setTitle(R.string.toolbarTitleSegunda)
        setSupportActionBar(toolbar)
        val actionBar= supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_segunda,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId)
        {

            R.id.action_crear_video->{
                Toast.makeText(applicationContext,"Creando nuevo video", Toast.LENGTH_SHORT).show()
            }
            else ->  return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }


}
