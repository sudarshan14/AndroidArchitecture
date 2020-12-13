package sud.bhatt.androidarchitecture.mvc

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import kotlinx.android.synthetic.main.activity_m_v_c.*
import kotlinx.android.synthetic.main.activity_m_v_c.progress
import kotlinx.android.synthetic.main.activity_m_v_c.retryButton
import kotlinx.android.synthetic.main.activity_m_v_c_recycler_view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import sud.bhatt.androidarchitecture.R


class MVCActivity : AppCompatActivity() {
    //The List type in Kotlin is not mutable.
// If you want to cause your list to change, you need to declare it as a MutableList.
//    private val listValues: List<String> = arrayListOf()
    private val listValues: MutableList<String> = mutableListOf()
    private lateinit var controller: CountriesController

    //    private var adapter: ArrayAdapter<String?>? = null
//    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var adapter: CountriesRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_m_v_c)
        setContentView(R.layout.activity_m_v_c_recycler_view)
        title = "MVC Activity"
        controller = CountriesController(this)

//        adapter =
//            ArrayAdapter(this, R.layout.row_layout, R.id.listText, listValues.toList())
//        list.adapter = adapter
        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
        recyclerView.addItemDecoration(decoration)

        adapter = CountriesRecyclerViewAdapter(listValues)
        recyclerView.adapter =adapter


        retryButton.setOnClickListener {
            controller.onRefresh()
            list.visibility = View.GONE
            retryButton.visibility = View.GONE
            progress.visibility = View.VISIBLE

        }


//        setValues(mutableListOf("India", "Japan", "Greenland"))
    }

    fun setValues(values: MutableList<String>) {
        listValues.clear()
        listValues.addAll(values)

        adapter.notifyDataSetChanged()
        retryButton.visibility = View.GONE
//        list.visibility = View.VISIBLE
        recyclerView.visibility = View.VISIBLE
        progress.visibility = View.GONE


    }

    fun onError() {
        Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show()
        progress.visibility = View.GONE
//        list.visibility = View.GONE
        retryButton.visibility = View.VISIBLE
    }
}