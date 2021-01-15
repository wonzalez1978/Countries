package cl.desafiolatam.countries2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.countries2.model.remoto.CountryPojo
import kotlinx.android.synthetic.main.itemcountries.view.*

class AdapterCountries(private val myDataset: MutableList<CountryPojo>) :
    RecyclerView.Adapter<AdapterCountries.CountriesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val countriesList =
            LayoutInflater.from(parent.context).inflate(R.layout.itemcountries, parent, false)
        return CountriesViewHolder(countriesList)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.nombrePais.text = myDataset[position].name
        holder.nombreCapital.text = myDataset[position].capital
        holder.nombreRegion.text = myDataset[position].region
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    fun upDateAdapter(listResult: List<CountryPojo>) {
        myDataset.clear()
        myDataset.addAll(listResult)
        notifyDataSetChanged()
    }

    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombrePais: TextView = itemView.idname
        var nombreCapital: TextView = itemView.idcapital
        var nombreRegion: TextView = itemView.idregion

    }
}