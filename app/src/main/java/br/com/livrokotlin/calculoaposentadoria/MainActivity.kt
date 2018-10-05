package br.com.livrokotlin.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // acessando itens da view
        val spnSexo = findViewById<Spinner>(R.id.spn_sexo)
        val etIdade = findViewById<EditText>(R.id.et_idade)
        val btCalcular = findViewById<Button>(R.id.bt_calcular)
        val tvResultado = findViewById<TextView>(R.id.tv_resultado)

        // adiciona itens no spinner
        spnSexo.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listOf("masculino", "feminino"))

        // evento click calcular
        btCalcular.setOnClickListener {
            val sexo = spnSexo.selectedItem as String
            val idade = etIdade.text.toString().toInt()
            var resultado = 0

            if (sexo == "masculino") resultado = 65 - idade
            else resultado = 60 - idade

            tvResultado.text = "Faltam $resultado ano para você se aposentar !"
        }
    }
}