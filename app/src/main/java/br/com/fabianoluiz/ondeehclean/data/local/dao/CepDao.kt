package br.com.fabianoluiz.ondeehclean.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fabianoluiz.ondeehclean.data.local.entity.CepEntity

@Dao
interface CepDao {
    @Insert(onConflict = OnConflictStrategy .REPLACE)
    suspend fun insertCep(cep: CepEntity)
    @Query("SELECT * FROM cep_table WHERE cep = :cep LIMIT 1 ")
    suspend fun getCep(cep: String): CepEntity?
}