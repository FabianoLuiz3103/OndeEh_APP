package br.com.fabianoluiz.ondeehclean.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fabianoluiz.ondeehclean.data.local.dao.CepDao
import br.com.fabianoluiz.ondeehclean.data.local.entity.CepEntity

@Database(entities = [ CepEntity::class], version = 1, exportSchema =
false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cepDao(): CepDao
}