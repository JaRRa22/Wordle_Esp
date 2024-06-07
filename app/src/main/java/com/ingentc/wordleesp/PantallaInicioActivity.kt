package com.ingentc.wordleesp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ingentc.wordleesp.databinding.ActivityPantallaInicioBinding

class PantallaInicioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPantallaInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaInicioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.botonInicio.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v){
            binding.botonInicio -> iniciarJuego()
        }
    }

    private fun iniciarJuego(){
        startActivity(Intent(this, MainActivity :: class.java))
    }
}