package cl.desafiolatam.countries2.model.remoto

import cl.desafiolatam.countries2.model.remoto.CountryPojo
import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {
    @GET("all")
    fun getCountries():Call<List<CountryPojo>>
}