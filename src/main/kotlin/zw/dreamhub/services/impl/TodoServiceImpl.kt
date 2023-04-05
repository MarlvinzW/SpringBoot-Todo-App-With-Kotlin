package zw.dreamhub.services.impl

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import zw.dreamhub.domain.dto.payload.TodoPayload
import zw.dreamhub.domain.dto.response.ApiResponse
import zw.dreamhub.domain.models.TodoModel
import zw.dreamhub.domain.repositories.TodoRepository
import zw.dreamhub.services.TodoService
import kotlin.jvm.optionals.getOrNull

@Service
class TodoServiceImpl(private val repository: TodoRepository) : TodoService {

    val alreadyExists: String = "Todo already exists"
    val successCreate: String = "Successfully created todo"
    val successUpdate: String = "Successfully updated todo"
    val successDelete: String = "Successfully deleted todo"
    val notFound: String = "Todo not found"


    override fun getTodos(): MutableList<TodoModel> {
        return repository.findAll()
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun createTodo(payload: TodoPayload): ApiResponse {

        val todo: TodoModel? = repository.findByTitle(payload.title).getOrNull()

        todo?.let {
            return ApiResponse(HttpStatus.BAD_REQUEST.value(), false, alreadyExists)
        }

        val newTodo = TodoModel(payload.title, payload.description)
        repository.save(newTodo)

        return ApiResponse(HttpStatus.CREATED.value(), true, successCreate)
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun updateTodo(id: Long, payload: TodoPayload): ApiResponse {
        val todo: TodoModel? = repository.findById(id).getOrNull()

        todo?.let {
            it.title?.let { it1 -> it.description?.let { it2 -> it.update(it1, it2) } }
            repository.save(it)
            return ApiResponse(HttpStatus.OK.value(), true, successUpdate)
        }

        return ApiResponse(HttpStatus.BAD_REQUEST.value(), false, notFound)
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun deleteTodo(id: Long): ApiResponse {
        val todo: TodoModel? = repository.findById(id).getOrNull()

        todo?.let {
            repository.delete(it)
            return ApiResponse(HttpStatus.OK.value(), true, successDelete)
        }

        return ApiResponse(HttpStatus.BAD_REQUEST.value(), false, notFound)
    }
}