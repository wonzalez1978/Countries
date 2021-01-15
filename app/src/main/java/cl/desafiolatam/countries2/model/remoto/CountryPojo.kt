package cl.desafiolatam.countries2.model.remoto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries_table")
class CountryPojo (val name : String, @PrimaryKey val alpha2Code : String, val capital : String, val region : String)