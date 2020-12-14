package sud.bhatt.androidarchitecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_m_v_c.*
import kotlinx.android.synthetic.main.activity_m_v_c_recycler_view.*
import kotlinx.android.synthetic.main.activity_m_v_c_recycler_view.progress
import kotlinx.android.synthetic.main.activity_m_v_c_recycler_view.retryButton
import sud.bhatt.androidarchitecture.R
import sud.bhatt.androidarchitecture.model.CountryDetail
import sud.bhatt.androidarchitecture.mvc.CountriesController
import sud.bhatt.androidarchitecture.mvc.CountriesRecyclerViewAdapter

class MVPActivity : AppCompatActivity() ,CountriesPresenter.View {

    private val listValues: MutableList<CountryDetail> = mutableListOf()
    private lateinit var presenter: CountriesPresenter

    private lateinit var adapter: CountryDetailsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_p)

        title ="MVP Activity"

        presenter = CountriesPresenter(this)

        val decoration = DividerItemDecoration(applicationContext, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        adapter = CountryDetailsRecyclerViewAdapter(listValues)
        recyclerView.adapter =adapter


        retryButton.setOnClickListener {
            presenter.onRefresh()
            list.visibility = View.GONE
            retryButton.visibility = View.GONE
            progress.visibility = View.VISIBLE

        }


    }

    override fun setValues(countries: MutableList<CountryDetail>) {

        listValues.clear()
        listValues.addAll(countries)

        adapter.notifyDataSetChanged()
        retryButton.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        progress.visibility = View.GONE

    }

    override fun onError() {
        Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show()
        progress.visibility = View.GONE
        retryButton.visibility = View.VISIBLE
    }
}