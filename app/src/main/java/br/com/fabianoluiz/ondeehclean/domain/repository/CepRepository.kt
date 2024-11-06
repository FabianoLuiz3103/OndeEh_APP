package br.com.fabianoluiz.ondeehclean.domain.repository

import br.com.fabianoluiz.ondeehclean.domain.model.Cep

interface CepRepository {
    suspend fun getCep(cep: String): Cep
}