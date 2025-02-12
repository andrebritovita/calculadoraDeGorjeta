package com.andrebritovita.appgorjeta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrebritovita.appgorjeta.databinding.ResultActivityBinding
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ResultActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null){
            val gorjeta = bundle.getFloat(KEY_TIPS, 0.0f)
            val totalTodos = bundle.getFloat(KEY_TOTAL, 0.0f)
            val numPessoas = bundle.getInt(KEY_NUM_PEOPLE, 0)
            val totalSemGorjeta = bundle.getFloat(KEY_NO_TIPS, 0.0f)
            val totalComGorjeta = bundle.getFloat(KEY_WITH_TIPS, 0.0f)
            val porcGorjeta = bundle.getFloat(KEY_PERCT_TIPS, 0.0f)
            binding.tvResult.text = String.format(Locale.US, "%.2f REAIS", totalComGorjeta)
            binding.tvParcial.text = String.format(Locale.US, "Valor sem gorjeta: R$ %.2f reais", totalSemGorjeta)
            binding.tvGorjeta.text = String.format(Locale.US, "Gorjeta: R$ %.2f reais", gorjeta)
            binding.tvPorcentGorjeta.text = "Porcentagem de gorjeta: $porcGorjeta %"
            binding.tvNumPessoas.text = "Número de pessoas: $numPessoas"
            binding.tvTotalTodos.text = "Valor total da mesa: R$ $totalTodos reais"
        }
        binding.btnNewCalc.setOnClickListener {
            finish()
        }
    }
}