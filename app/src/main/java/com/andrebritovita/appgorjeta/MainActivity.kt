package com.andrebritovita.appgorjeta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.andrebritovita.appgorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_RESULTS = "RESULTSACTIVITY_KEY_RESULTS"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var percentage: Float = 0.0f
    override fun onResume() {
        super.onResume()
        clean()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rbTipCustom.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.tilTipValue.visibility = if (isChecked) View.VISIBLE else View.GONE
                binding.tvHintTipValue.visibility = if (isChecked) View.VISIBLE else View.GONE
            }
        }
        binding.rbNoTip.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.tilTipValue.visibility = View.GONE
                binding.tvHintTipValue.visibility = View.GONE
                binding.tieTipValue.text?.clear()
                percentage = 0.0f
            }
        }
        binding.btnDone.setOnClickListener {
            calcular()
        }
        binding.btnClean.setOnClickListener {
            clean()
        }
    }
    private fun clean (){
        binding.apply {
            tieTotal.text?.clear()
            tieNumPeople.text?.clear()
            rgTipOptions.clearCheck()
            tieTipValue.text?.clear()
            tilTipValue.visibility = View.GONE
            binding.tvHintTipValue.visibility = View.GONE
        }
        percentage = 0.0f
    }
    private fun calcular() {
        val totalStr: String = binding.tieTotal.text.toString()
        val nPeopleStr: String = binding.tieNumPeople.text.toString()
        val verificado: Boolean = verificarCampos(totalStr, nPeopleStr)
        if (verificado) {
            if (binding.rbTipCustom.isChecked){
                percentage = binding.tieTipValue.text.toString().toFloat()
            }
            val totalF = totalStr.toFloatOrNull() ?: return
            val nPeopleInt = nPeopleStr.toIntOrNull() ?: return
            val totalParcial = totalF / nPeopleInt
            val tips = totalParcial * percentage / 100
            val totalWithTips = totalParcial + tips
            val totalValue = totalWithTips * nPeopleInt
            startActivity(Intent(this, ResultActivity::class.java).apply {
                putExtra(KEY_RESULTS, Resumo(tips, totalF,totalValue, nPeopleInt, totalParcial, totalWithTips, percentage))
            })
        }
    }
    private fun showErrorMessage(view: TextInputEditText, message: String): Boolean {
        view.error = message
        view.requestFocus()
        view.postDelayed({ view.clearFocus() }, 1000)
        return false
    }
    private fun verificarCampos(vTotal: String, qntPeople: String): Boolean {
        if (vTotal.isEmpty()) return showErrorMessage(binding.tieTotal, getString(R.string.error_empty_bill))
        if (qntPeople.isEmpty()) return showErrorMessage(binding.tieNumPeople, getString(R.string.error_empty_people))
        if (!binding.rbTipCustom.isChecked && !binding.rbNoTip.isChecked) {
            showSnackbar(getString(R.string.snackbar_add_tip))
            return false
        }
        if (binding.rbTipCustom.isChecked && binding.tieTipValue.text.toString().isEmpty()) {
            showSnackbar(getString(R.string.snackbar_choose_percentage))
            return false
        }
        return true
    }
    private fun showSnackbar(message: String) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        Snackbar.make(binding.btnClean, message, Snackbar.LENGTH_LONG).show()
    }
}

