package andres.otalora.examplemvvm.domain

import andres.otalora.examplemvvm.data.QuoteRepository
import andres.otalora.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke() : List<QuoteModel>? = repository.getAllQuotes()


}