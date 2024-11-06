package br.com.fabianoluiz.ondeehclean.domain.usecase

import br.com.fabianoluiz.ondeehclean.domain.model.Cep
import br.com.fabianoluiz.ondeehclean.domain.repository.CepRepository

class GetCepUseCase(private val repository: CepRepository) {
    suspend operator fun invoke(cep: String): Cep {
        return repository.getCep(cep)
    }
}