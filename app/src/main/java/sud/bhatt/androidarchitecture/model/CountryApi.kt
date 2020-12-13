package sud.bhatt.androidarchitecture.model

import retrofit2.http.GET

interface CountryApi {
    @GET("all")
    fun getCountries(): List<Country>
}