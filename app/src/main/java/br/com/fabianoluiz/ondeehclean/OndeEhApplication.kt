package br.com.fabianoluiz.ondeehclean

import android.app.Application
import br.com.fabianoluiz.ondeehclean.di.databaseModule
import br.com.fabianoluiz.ondeehclean.di.networkModule
import br.com.fabianoluiz.ondeehclean.di.repositoryModule
import br.com.fabianoluiz.ondeehclean.di.useCaseModule
import br.com.fabianoluiz.ondeehclean.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class OndeEhApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@OndeEhApplication )
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}