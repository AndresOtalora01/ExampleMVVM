package andres.otalora.examplemvvm.ui.viewmodel

import andres.otalora.examplemvvm.data.model.QuoteModel
import andres.otalora.examplemvvm.data.model.QuoteProvider
import andres.otalora.examplemvvm.domain.GetQuotesUseCase
import andres.otalora.examplemvvm.domain.GetRandomQuoteUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    var getQuotesUseCase = GetQuotesUseCase()

    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}