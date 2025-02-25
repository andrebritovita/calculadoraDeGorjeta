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

        binding.btnNewCalc.setOnClickListener { finish()
        }
    }
    private fun exibirResultados(resultado: Resumo) {
        with(binding) {
            tvResult.text = String.format(Locale.US, "%.2f", resultado.totalWithTipsPc)
            tvParcial.text = String.format(Locale.US, "%.2f", resultado.totalParcialPc)
            tvGorjeta.text = String.format(Locale.US, "%.2f", resultado.tipsPc)
            tvTotalTodos.text = String.format(Locale.US, "%.2f", resultado.totalPc)
            tvPorcentGorjeta.text = "${resultado.percentagePc} %"
            tvNumPessoas.text = "${resultado.numPeoplePc}"
            tvTotalTodosNoTips.text = "${resultado.totalNoTips}"
        }
    }
}
