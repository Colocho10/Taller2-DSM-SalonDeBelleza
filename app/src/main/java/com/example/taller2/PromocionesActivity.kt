package com.example.taller2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PromocionesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promociones)

        val caja1 = findViewById<ConstraintLayout>(R.id.caja1)
        val caja2 = findViewById<ConstraintLayout>(R.id.caja2)
        val caja3 = findViewById<ConstraintLayout>(R.id.caja3)


        caja1.setOnClickListener{
           val movimiento1 = Intent(this, CitaActivity::class.java)
            startActivity(movimiento1)
        }

        caja2.setOnClickListener{
            val movimiento2 = Intent(this, CitaActivity::class.java)
            startActivity(movimiento2)
        }

        caja3.setOnClickListener{
            val movimiento3 = Intent(this, CitaActivity::class.java)
            startActivity(movimiento3)
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
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