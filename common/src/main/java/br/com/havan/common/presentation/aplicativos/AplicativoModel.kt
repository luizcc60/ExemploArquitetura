package br.com.havan.common.presentation.aplicativos

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
class AplicativoModel(val nome: String, @DrawableRes val imagem: Int) : Parcelable