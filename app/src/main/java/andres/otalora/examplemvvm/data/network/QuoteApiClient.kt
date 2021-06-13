package andres.otalora.examplemvvm.data.network

import andres.otalora.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun  getAllQuotes() : Response<List<QuoteModel>>
}