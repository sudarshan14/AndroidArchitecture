package sud.bhatt.androidarchitecture.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("all")
    fun getCountries2(): String

    @GET("all")
    fun getCountryDetails(): Single<List<CountryDetail>>

    @GET("all")
    fun getCountries(): Single<List<Country>>
}