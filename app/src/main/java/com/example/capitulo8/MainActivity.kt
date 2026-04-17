package com.example.capitulo8

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capitulo8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)

        // Sincroniza o item
        toggle.syncState()
        supportActionBar?.title = "Aplicativo"

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars())

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_import -> Toast.makeText(this, "Clicou no import", Toast.LENGTH_SHORT).show()
                R.id.nav_ferramenta -> Toast.makeText(this, "Clicou no tools", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}