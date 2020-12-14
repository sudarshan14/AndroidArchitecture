package sud.bhatt.androidarchitecture.mvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sud.bhatt.androidarchitecture.model.CountryDetail
import sud.bhatt.androidarchitecture.mvc.CountriesViewHolder

class CountryDetailsRecyclerViewAdapter(private val countryDetails: MutableList<CountryDetail>) :
    RecyclerView.Adapter<CountryDetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryDetailsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountryDetailsViewHolder, position: Int) {
        val countryName: String? = countryDetails[position].countryName
        val countryCapital: String? = countryDetails[position].countryCapital
        holder.bind(countryName,countryCapital)
    }

    override fun getItemCount(): Int {
        return countryDetails.size
    }


}