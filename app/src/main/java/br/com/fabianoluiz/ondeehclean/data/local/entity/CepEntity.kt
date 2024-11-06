package br.com.fabianoluiz.ondeehclean.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.fabianoluiz.ondeehclean.domain.model.Cep

@Entity(tableName = "cep_table" )
data class CepEntity(
    @PrimaryKey val cep: String,
    val logradouro: String,
    val complemento : String,
    val bairro: String,
    val localidade: String,
    val uf: String
) {
    fun toCep(): Cep {
        return Cep(
            cep = cep,
            logradouro = logradouro,
            complemento = complemento ,
            bairro = bairro,
            localidade = localidade,
            uf = uf
        )
    }
}