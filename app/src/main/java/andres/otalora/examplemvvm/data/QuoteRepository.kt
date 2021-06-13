package andres.otalora.examplemvvm.data

import andres.otalora.examplemvvm.data.model.QuoteModel
import andres.otalora.examplemvvm.data.model.QuoteProvider
import andres.otalora.examplemvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes() : List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}