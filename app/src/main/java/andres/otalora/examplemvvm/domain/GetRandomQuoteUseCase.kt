package andres.otalora.examplemvvm.domain

import andres.otalora.examplemvvm.data.model.QuoteModel
import andres.otalora.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke() : QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}