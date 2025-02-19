package com.andrebritovita.appgorjeta

import android.os.Build
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

        intent.extras?.let { bundle ->
            val resultado: Resumo? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(KEY_RESULTS, Resumo::class.java)
            } else {
                bundle.getParcelable(KEY_RESULTS)
            }
            resultado?.let (::exibirResultados)
        }
        binding.btnNewCalc.setOnClickListener { finish() }
    }
    private fun exibirResultados(resultado: Resumo) {
        with(binding) {
            tvResult.text = String.format(Locale.US, "%.2f REAIS", resultado.totalWithTipsPc)
            tvParcial.text = String.format(Locale.US, "Valor sem gorjeta: R$ %.2f reais", resultado.totalParcialPc)
            tvGorjeta.text = String.format(Locale.US, "Gorjeta: R$ %.2f reais", resultado.tipsPc)
            tvPorcentGorjeta.text = "Porcentagem de gorjeta: ${resultado.percentagePc} %"
            tvNumPessoas.text = "Número de pessoas: ${resultado.numPeoplePc}"
            tvTotalTodos.text = "Valor total da mesa: R$ ${resultado.totalPc} reais"
        }
    }
}
