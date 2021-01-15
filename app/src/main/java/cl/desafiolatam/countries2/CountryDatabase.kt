package cl.desafiolatam.countries2

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.countries2.model.remoto.CountryDao
import cl.desafiolatam.countries2.model.remoto.CountryPojo

@Database(entities = [CountryPojo::class], version = 1)
public abstract class CountryDatabase : RoomDatabase() {

    abstract fun dao(): CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        //esta funsion crea la instancia que crea la conexion a la base de datos(Singleton)
        fun getDatabase(context: Context): CountryDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java, "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    //archivo de Kotlin que será el punto de partida de nuestra aplicación,
    //en él se iniciará la Base de datos.
    class RecetasApp : Application() {
        companion object {
            lateinit var database: CountryDatabase
        }

        override fun onCreate() {
            super.onCreate()
            RecetasApp.database =
                Room.databaseBuilder(
                    this, CountryDatabase::class.java,
                    "tast_db"
                ).build()
        }
    }

}