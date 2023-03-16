package com.joan.webservice.repository

import com.joan.webservice.repository.model.Actividades
import com.joan.webservice.repository.model.ActividadesUsuario
import com.joan.webservice.repository.model.Usuarios
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GimnasioAPI {
    @Headers("Accept: application/json")
    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuarios?>?>?

    @Headers("Accept: application/json")
    @GET("actividades")
    fun getActividades(): Call<List<Actividades?>?>?

    @Headers("Accept: application/json")
    @GET("actividades_usuario")
    fun getActividadesUsuario(): Call<List<ActividadesUsuario?>?>?
}
