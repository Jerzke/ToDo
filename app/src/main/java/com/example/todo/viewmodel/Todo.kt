package com.example.todo.viewmodel
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
const val BASE_URL = "https://jsonplaceholder.typicode.com/todos"
interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
    companion object{
        var todosService: TodosAPI? = null

        fun getInstance(): TodosApi {
            if (todosService === null){
                todosService = RetroFit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactoryu(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosService
        }
    }
}