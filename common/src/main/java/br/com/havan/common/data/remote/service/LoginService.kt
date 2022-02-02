package br.com.havan.common.data.remote.service

import br.com.havan.common.data.remote.source.login.LoginResponseModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun logar(
        @Field("grant_type") grant_type: String = "password",
        @Field("username") codigo: String,
        @Field("password") senha: String,
        @Field("client_id") client_id: String = ""
    ): LoginResponseModel
}