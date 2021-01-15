package cl.desafiolatam.countries2

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.desafiolatam.countries2.model.remoto.CountryDao
import cl.desafiolatam.countries2.model.remoto.CountryPojo
import cl.desafiolatam.countries2.model.remoto.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {
    var countryDao: CountryDao = CountryDatabase.getDatabase(context).dao()
    val getAll: LiveData<List<CountryPojo>> = countryDao.getAll()

    fun loadApiData() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getCountries()
        call.enqueue(object : Callback<List<CountryPojo>> {
            override fun onResponse(
                call: Call<List<CountryPojo>>,
                response: Response<List<CountryPojo>>
            ) {
                Log.d("Main", "${response.isSuccessful}")
                Log.d("Main", "${response.body()?.size}")
                Log.d("Main", response.body().toString())
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let { countryDao.insertCountries(it).toString() }
                }
            }

            override fun onFailure(call: Call<List<CountryPojo>>, t: Throwable) {
                Log.d("Main", "$t")
            }

        })
    }
}