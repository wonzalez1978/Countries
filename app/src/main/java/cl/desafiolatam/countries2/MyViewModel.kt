package cl.desafiolatam.countries2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.desafiolatam.countries2.model.remoto.CountryPojo

class MyViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: Repository = Repository(application)

    val getAll: LiveData<List<CountryPojo>> = repository.getAll

    fun obtenerValor() {
        repository.loadApiData()
    }
}