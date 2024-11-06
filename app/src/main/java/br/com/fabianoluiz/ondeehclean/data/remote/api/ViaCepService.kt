package br.com.fabianoluiz.ondeehclean.data.remote.api

import br.com.fabianoluiz.ondeehclean.data.remote.model.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path
interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun getCep(@Path("cep") cep: String): CepResponse
}