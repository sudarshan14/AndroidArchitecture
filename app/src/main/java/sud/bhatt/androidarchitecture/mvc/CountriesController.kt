package sud.bhatt.androidarchitecture.mvc

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import sud.bhatt.androidarchitecture.model.Country
import sud.bhatt.androidarchitecture.model.CountryApi
import sud.bhatt.androidarchitecture.model.CountryService

class CountriesController(view: MVCActivity) {

    private val view: MVCActivity = view
    private val service: CountryService = CountryService

    init {
        fetchCountriesRxJava();
    }


    private fun fetchCountiesRetrofit() {
        val request = service.buildService(CountryApi::class.java)
        val call = request.getCountries2()
//call.enque
    }

    private fun fetchCountriesRxJava() {

        service.buildService(CountryApi::class.java)
            .getCountries()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                override fun onSuccess(value: List<Country>?) {
                    val countyNames: MutableList<String> = mutableListOf()
                    if (value != null) {
                        for (country in value) {
                            countyNames.add(country.countryName.toString())
                            view.setValues(countyNames)
                        }

                    }
                }

                override fun onError(e: Throwable?) {
                    view.onError();
                }
            })

    }

    fun onRefresh() {
        fetchCountriesRxJava()
    }

}