import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.domain.uimodel.PokemonUi
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.testcompose.domain.usercase.abs.PokemonListUseCase

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val useCase: PokemonListUseCase
) : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<PokemonUi>>(emptyList())
    val pokemonList = _pokemonList
    val error = MutableStateFlow<Boolean>(false)
    val loading = MutableStateFlow<Boolean>(false)

    fun loadData() {
        loading.value = true
        viewModelScope.launch {
            try {
                val result = useCase.fetchPokemons()
                _pokemonList.value = result.mapNotNull { it }
                loading.value = false
            } catch (e: Exception) {
                error.value = true
                loading.value = false
            }
        }
    }
}
