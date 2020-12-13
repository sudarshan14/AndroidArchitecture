package sud.bhatt.androidarchitecture.mvc

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sud.bhatt.androidarchitecture.R
import sud.bhatt.androidarchitecture.model.Country
import java.util.zip.Inflater

class CountriesViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.row_layout, parent, false
    )
) {
    private var title: TextView? = null

    init {
        title = itemView.findViewById(R.id.listText)
    }

    fun bind(country: String) {
        title?.text = country
    }
}