package sud.bhatt.androidarchitecture.mvp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sud.bhatt.androidarchitecture.R
import java.util.zip.Inflater

class CountryDetailsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.row_layout_2, parent, false)
    ) {
    private var name: TextView? = null
    private var capital: TextView? = null

    init {
        name = itemView.findViewById(R.id.listText1)
        capital = itemView.findViewById(R.id.listText2)

    }

    fun bind(country: String?, countryCapital: String?) {
        name?.text = country
        capital?.text ="Capital : $countryCapital"
    }
}