package com.example.taller2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.content.ContentValues

class CitaActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val boton1 = findViewById<Button>(R.id.boton1)
        val boton2 = findViewById<Button>(R.id.boton2)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val et4 = findViewById<EditText>(R.id.et4)
        val et5 = findViewById<EditText>(R.id.et5)

        boton1.setOnClickListener{

            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et1.getText().toString())
            registro.put("correo", et2.getText().toString())
            registro.put("tratamiento", et3.getText().toString())
            registro.put("hora", et4.getText().toString())
            registro.put("fecha", et5.getText().toString())
            bd.insert("registro", null, registro)
            bd.close()

            et1.setText("")
            et2.setText("")
            et3.setText("")
            et4.setText("")
            et5.setText("")


            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener{
            val movimiento1 = Intent(this, ReportecitasActivity::class.java)
            startActivity(movimiento1)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val intento1 = Intent(this, MainActivity::class.java)
        val intento2 = Intent(this, TratamientosActivity::class.java)
        val intento3 = Intent(this, PromocionesActivity::class.java)
        val intento4 = Intent(this, CitaActivity::class.java)
        val intento5 = Intent(this, ReportecitasActivity::class.java)

        when (item.itemId) {
            R.id.nav_item_one -> startActivity(intento1)
            R.id.nav_item_two -> startActivity(intento2)
            R.id.nav_item_three -> startActivity(intento3)
            R.id.nav_item_four -> startActivity(intento4)
            R.id.nav_item_five -> startActivity(intento5)
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}