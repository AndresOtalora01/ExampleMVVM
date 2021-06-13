package andres.otalora.examplemvvm.viewmodel

import andres.otalora.examplemvvm.model.QuoteModel
import andres.otalora.examplemvvm.model.QuoteProvider
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuoteViewModel : ViewModel () {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}