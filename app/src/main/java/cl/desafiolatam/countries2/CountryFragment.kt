package cl.desafiolatam.countries2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {
    private lateinit var adapterCountries: AdapterCountries
    val myViewModel: MyViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country, container, false)
        adapterCountries = AdapterCountries(mutableListOf())
        //creamos el ViewModel
        myViewModel.obtenerValor()
        myViewModel.getAll.observe(viewLifecycleOwner, Observer {
            adapterCountries.upDateAdapter(it)
        })
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = recyclerviewcountry
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterCountries
    }
}