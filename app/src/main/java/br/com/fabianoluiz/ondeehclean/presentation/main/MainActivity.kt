package br.com.fabianoluiz.ondeehclean.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fabianoluiz.ondeehclean.R
import br.com.fabianoluiz.ondeehclean.databinding.ActivityMainBinding
import br.com.fabianoluiz.ondeehclean.domain.model.Cep
import br.com.fabianoluiz.ondeehclean.domain.usecase.GetCepUseCase
import br.com.fabianoluiz.ondeehclean.presentation.extensions.addCepMask
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModel()
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding .inflate( layoutInflater)
        setContentView( binding.root)
        binding.etCep.addCepMask()

        binding.btPesquisar .setOnClickListener {
            val cep = binding.etCep.text.toString()
            viewModel.fetchCep( cep)
        }
        viewModel .cepData.observe( this, Observer { cep ->
            binding.tvBairro .text = cep.bairro
            binding .tvLocalidade .text = cep.localidade
            binding .tvLogradouro .text = cep.logradouro
            binding .tvUF.text = cep.uf
        })
    }
}