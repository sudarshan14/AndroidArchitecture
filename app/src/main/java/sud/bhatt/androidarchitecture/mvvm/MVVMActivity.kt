package sud.bhatt.androidarchitecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_m_v_v_m.*
import sud.bhatt.androidarchitecture.R

class MVVMActivity : AppCompatActivity() {

    private lateinit var countryViewModel: CountriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_v_m)

        title = "MVVM Activity"

        countryViewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        observeViewModels()

        updateList.setOnClickListener {
            countryViewModel.updateCountriesData()
        }
    }

    private fun observeViewModels() {
        countryViewModel.getCountries().observe(this) {
            var countryNames: String = ""
            if (it != null)
                for (country in it) {
                    countryNames += "\n $country"
                }
            countryText.text = countryNames//it.size.toString()

        }

        countryViewModel.getCountryError().observe(this) {
//            if (it)
//                countryText.text = "Error"
//            else
//                countryText.text = "Success"
        }

    }
}