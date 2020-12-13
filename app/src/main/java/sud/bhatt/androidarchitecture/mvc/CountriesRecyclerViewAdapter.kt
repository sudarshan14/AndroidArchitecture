package sud.bhatt.androidarchitecture.mvc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sud.bhatt.androidarchitecture.model.Country

class CountriesRecyclerViewAdapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountriesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val movie: String = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size


}