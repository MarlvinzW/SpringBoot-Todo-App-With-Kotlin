package zw.dreamhub.services

import zw.dreamhub.domain.dto.payload.TodoPayload
import zw.dreamhub.domain.dto.response.ApiResponse
import zw.dreamhub.domain.models.TodoModel


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 5/4/2023
 */
interface TodoService {

    fun getTodos(): MutableList<TodoModel>

    fun createTodo(payload: TodoPayload): ApiResponse

    fun updateTodo(
        id: Long,
        payload: TodoPayload
    ): ApiResponse

    fun deleteTodo(
        id: Long
    ): ApiResponse

}