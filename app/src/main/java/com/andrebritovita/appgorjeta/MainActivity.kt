package com.andrebritovita.appgorjeta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.andrebritovita.appgorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.math.RoundingMode

const val KEY_TIPS = "RESULTSACTIVITY_KEY_TIPS"
const val KEY_TOTAL = "RESULTSACTIVITY_KEY_TOTAL"
const val KEY_NUM_PEOPLE = "RESULTSACTIVITY_KEY_NUM_PEOPLE"
const val KEY_NO_TIPS = "RESULTSACTIVITY_KEY_NO_TIPS"
const val KEY_WITH_TIPS = "RESULTSACTIVITY_KEY_WITH_TIPS"
const val KEY_PERCT_TIPS = "RESULTSACTIVITY_KEY_PERCT_TIPS"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var percentage: Float = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rbTipCustom.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.tilTipValue.visibility = if (isChecked) View.VISIBLE else View.GONE
            }
        }
        binding.rbNoTip.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.tilTipValue.visibility = View.GONE
                binding.tieTipValue.text?.clear()
                percentage = 0.0f
            }
        }
        binding.btnDone.setOnClickListener {
            calcular()
        }
        binding.btnClean.setOnClickListener {
            binding.tieTotal.text?.clear()
            binding.tieNumPeople.text?.clear()
            binding.rgTipOptions.clearCheck()
            binding.tieTipValue.text?.clear()
            binding.tilTipValue.visibility = View.GONE
            percentage = 0.0f
        }
    }
    private fun calcular() {
        val totalStr: String = binding.tieTotal.text.toString()
        val nPeopleStr: String = binding.tieNumPeople.text.toString()
        val verificado: Boolean = verificarCampos(totalStr, nPeopleStr)
        if (verificado) {
            if (binding.rbTipCustom.isChecked){
                percentage = binding.tieTipValue.text.toString().toFloat()
            }
            val totalF = totalStr.toFloat()
            val nPeopleInt = nPeopleStr.toInt()
            val totalParcial = totalF / nPeopleInt
            val tips = totalParcial * percentage / 100
            val totalWithTips = totalParcial + tips
            val totalValue = totalWithTips * nPeopleInt
            val intent = Intent (this, ResultActivity::class.java)
            intent.putExtra(KEY_TIPS, tips)
            intent.putExtra(KEY_TOTAL, totalValue)
            intent.putExtra(KEY_NUM_PEOPLE, nPeopleInt)
            intent.putExtra(KEY_NO_TIPS, totalParcial)
            intent.putExtra(KEY_WITH_TIPS, totalWithTips)
            intent.putExtra(KEY_PERCT_TIPS, percentage)
            startActivity(intent)
        }
    }
    private fun verificarCampos(vTotal: String, qntPeople: String): Boolean {
        if (vTotal.isEmpty()) {
            binding.tieTotal.error = "Digite o valor total da conta."
            binding.tieTotal.requestFocus()
            binding.tieTotal.postDelayed({
                binding.tieTotal.clearFocus()
            }, 1000)
            return false
        } else if (qntPeople.isEmpty()) {
            binding.tieNumPeople.error = "Digite o número de pessoas!"
            binding.tieNumPeople.requestFocus()
            binding.tieNumPeople.postDelayed({
                binding.tieNumPeople.clearFocus()
            }, 1000)
            return false
        } else if (!binding.rbTipCustom.isChecked && !binding.rbNoTip.isChecked) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            Snackbar.make(
                binding.btnClean,
                "Deseja adicionar gorjeta?",
                Snackbar.LENGTH_LONG
            ).show()
            return false
        } else if (binding.rbTipCustom.isChecked && binding.tieTipValue.text.toString().isEmpty()) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            Snackbar.make(
                binding.btnClean,
                "Escolha a porcentagem de gorjeta!",
                Snackbar.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }
}

