package sud.bhatt.androidarchitecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import sud.bhatt.androidarchitecture.model.Country
import sud.bhatt.androidarchitecture.model.CountryApi
import sud.bhatt.androidarchitecture.model.CountryDetail
import sud.bhatt.androidarchitecture.model.CountryService

class CountriesViewModel : ViewModel() {

    private val countries: MutableLiveData<MutableList<String>> = MutableLiveData()
    private val countryError: MutableLiveData<Boolean> = MutableLiveData()

    private val service: CountryService = CountryService

    init {
        fetchCountriesRxJava()
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

                        }
                        countries.value = countyNames
                        countryError.value = false
                    }
                }

                override fun onError(e: Throwable?) {
                    countryError.value = true
                }
            })

    }

    fun updateCountriesData() {
        countries.value = mutableListOf("India", "Japan", "Greenland")
    }

    fun getCountries(): LiveData<MutableList<String>> {

        return countries
    }

    fun getCountryError(): LiveData<Boolean> {
        return countryError
    }
}