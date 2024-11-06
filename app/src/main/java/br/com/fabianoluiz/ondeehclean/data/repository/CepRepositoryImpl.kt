package br.com.fabianoluiz.ondeehclean.data.repository

import br.com.fabianoluiz.ondeehclean.data.local.dao.CepDao
import br.com.fabianoluiz.ondeehclean.data.remote.api.ViaCepService
import br.com.fabianoluiz.ondeehclean.domain.model.Cep
import br.com.fabianoluiz.ondeehclean.domain.repository.CepRepository

class CepRepositoryImpl (
    private val cepDao: CepDao,
    private val viaCepService : ViaCepService
) : CepRepository {
    override suspend fun getCep(cep: String): Cep {
        val cachedCep = cepDao.getCep(cep)
        return if (cachedCep != null) {
            cachedCep.toCep()
        } else {
            val response = viaCepService .getCep(cep)
            cepDao.insertCep( response.toCepEntity())
            response.toCep()
        }
    }
}