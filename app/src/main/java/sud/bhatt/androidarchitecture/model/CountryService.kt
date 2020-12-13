package sud.bhatt.androidarchitecture.model

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryService {
//    private val countryService: CountryApi = TODO()


    private const val BASE_URL = "https://restcountries.eu/rest/v2/"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//        countryService = retrofit.create(CountryApi::class.java)

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }


}