package br.com.havan.common.data.remote.source.login

import com.google.gson.annotations.SerializedName

class LoginResponseModel(
    @SerializedName("access_token")
    val token: String,
    @SerializedName("expires_in")
    val token_expira_em: Short,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("refresh_token_expires_in")
    val refresh_token_expira_em: Short
)