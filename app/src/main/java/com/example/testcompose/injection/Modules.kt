package com.example.testcompose.injection



import PokemonListViewModel
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingSource
import com.example.testcompose.data.api.PokemonApi
import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.data.repository.PokemonListRepositoryImp
import com.example.testcompose.domain.mapper.PokemonListMapperImp
import com.example.testcompose.domain.mapper.abs.PokemonListMapper
import com.example.testcompose.domain.repository.PokemonListRepository
import com.example.testcompose.domain.usercase.PokemonListUseCaseImp
import com.example.testcompose.domain.usercase.abs.PokemonListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Modules {
    private const val BASE_URL = "http://pokeapi.co/api/v2/"

    private val network = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    private val api = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(PokemonApi::class.java)
        }
    }
//    private val paging = module {
//        single<PagingSource<Int, Pokemon>> { PokemonListPagingSource(api = get()) }
//        single { PagingConfig(PokemonListRepositoryImp.DEFAULT_LIST_SIZE) }
//        single { Pager(get()) { get<PagingSource<Int, Pokemon>>() } }
//    }

    private val repository = module {
        single<PokemonListRepository> {
            PokemonListRepositoryImp(pokemonApi = get())
        }
    }

    private val mapper = module {
        single<PokemonListMapper> {
            PokemonListMapperImp()
        }
    }

    private val useCase = module {
        single<PokemonListUseCase> {
            PokemonListUseCaseImp(
                mapper = get(),
                pokemonListRepository = get()
            )
        }
    }

    private val viewModel = module {
        viewModel {
            PokemonListViewModel(
                useCase = get()
            )
        }
    }


    var all = listOf(
        network,
        api,
        repository,
        mapper,
        useCase,
        viewModel,

    )
}

