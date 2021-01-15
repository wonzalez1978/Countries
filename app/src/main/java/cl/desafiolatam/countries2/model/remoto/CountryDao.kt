package cl.desafiolatam.countries2.model.remoto

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * FROM  countries_table")
    fun getAll(): LiveData<List<CountryPojo>>

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertCountries(coutries : List<CountryPojo>)
}