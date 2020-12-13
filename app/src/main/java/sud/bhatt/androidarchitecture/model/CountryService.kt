package sud.bhatt.androidarchitecture.model

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object CountryService {
//    private val countryService: CountryApi = TODO()


    private const val BASE_URL = "https://restcountries.eu/rest/v2/"
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()

//        countryService = retrofit.create(CountryApi::class.java)

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

//    fun getCountries(): Single<List<Country>>{
//        return  retrofit.getCountries
//    }

}