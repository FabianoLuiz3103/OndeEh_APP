package br.com.fabianoluiz.ondeehclean.di

import androidx.room.Room
import br.com.fabianoluiz.ondeehclean.data.local.AppDatabase
import br.com.fabianoluiz.ondeehclean.data.remote.api.ViaCepService
import br.com.fabianoluiz.ondeehclean.data.repository.CepRepositoryImpl
import br.com.fabianoluiz.ondeehclean.domain.repository.CepRepository
import br.com.fabianoluiz.ondeehclean.domain.usecase.GetCepUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl( "https://viacep.com.br/ws/" )
            .addConverterFactory( GsonConverterFactory .create())
            .build()
            .create( ViaCepService ::class.java)
    }
}
val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase ::class.java,
            "cep_database" )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase >().cepDao() }
}

val repositoryModule = module {
    single<CepRepository> { CepRepositoryImpl(get(), get()) }
}
val useCaseModule = module {
    factory { GetCepUseCase(get()) }
}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}