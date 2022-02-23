package com.naugo.gastodecombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEntrar.setOnClickListener(this)

    }

    override fun onClick(view: View)
    {
        val id = view.id
        if (id == R.id.buttonEntrar)
        {
            entrar()
        }
    }

    private fun entrar()
    {
        val intent = Intent(this, TelaPrincipalActivity:: class.java)
        startActivity(intent)
    }

}