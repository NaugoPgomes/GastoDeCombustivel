package com.naugo.gastodecombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_principal.*

class TelaPrincipalActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            calcular()
        }
    }

    private fun calcular() {
        if (validado()) {
            try {
                val distancia = IdDistancia.text.toString().toFloat()
                val preco = IdPreco.text.toString().toFloat()
                val autonomia = IdAutonomia.text.toString().toFloat()

                val resultado = (distancia * preco) / autonomia

                textResultado.text = "R$ ${"%.2f".format(resultado)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.valor0), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.campoVazio), Toast.LENGTH_LONG).show()
        }
    }

    private fun validado(): Boolean {
        return (IdDistancia.text.toString() != "" && IdPreco.text.toString() != ""
                && IdAutonomia.text.toString() != "" && IdAutonomia.text.toString() != "0")
    }
}