package com.andrebritovita.appgorjeta

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resumo(
    val tipsPc: Float,
    val totalPc: Float,
    val numPeoplePc: Int,
    val totalParcialPc: Float,
    val totalWithTipsPc: Float,
    val percentagePc: Float
) : Parcelable
