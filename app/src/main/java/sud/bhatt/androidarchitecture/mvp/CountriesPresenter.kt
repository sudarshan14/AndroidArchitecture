package sud.bhatt.androidarchitecture.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import sud.bhatt.androidarchitecture.model.Country
import sud.bhatt.androidarchitecture.model.CountryApi
import sud.bhatt.androidarchitecture.model.CountryDetail
import sud.bhatt.androidarchitecture.model.CountryService

class CountriesPresenter(view: View) {

    val view: View = view
    private val service: CountryService = CountryService

    init {
        fetchCountriesRxJava()
    }

    private fun fetchCountriesRxJava() {

        service.buildService(CountryApi::class.java)
            .getCountryDetails()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<CountryDetail>>() {
                override fun onSuccess(value: List<CountryDetail>?) {
                    val countyNames: MutableList<CountryDetail> = mutableListOf()
                    if (value != null) {
                        for (country in value) {
                            countyNames.add(country)
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

     interface View {

        fun setValues(countries: MutableList<CountryDetail>)
        fun onError()
    }
}