package br.com.livrokotlin.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adiciona itens no spinner
        spn_sexo.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listOf("masculino", "feminino"))

        // evento click calcular
        bt_calcular.setOnClickListener {
            val sexo = spn_sexo.selectedItem as String
            val idade = et_idade.text.toString().toInt()
            var resultado = 0

            if (sexo == "masculino") resultado = 65 - idade
            else resultado = 60 - idade

            tv_resultado.text = "Faltam $resultado ano para você se aposentar !"
        }
    }
}