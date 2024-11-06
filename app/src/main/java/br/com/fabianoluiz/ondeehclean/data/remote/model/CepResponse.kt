package br.com.fabianoluiz.ondeehclean.data.remote.model

import br.com.fabianoluiz.ondeehclean.data.local.entity.CepEntity
import br.com.fabianoluiz.ondeehclean.domain.model.Cep

data class CepResponse (
    val cep: String,
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
    fun toCepEntity (): CepEntity {
        return CepEntity(
            cep = cep,
            logradouro = logradouro,
            complemento = complemento ,
            bairro = bairro,
            localidade = localidade,
            uf = uf
        )
    }
}
