package zw.dreamhub.controllers

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import zw.dreamhub.domain.dto.payload.TodoPayload
import zw.dreamhub.domain.dto.response.ApiResponse
import zw.dreamhub.domain.models.TodoModel
import zw.dreamhub.services.TodoService


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 5/4/2023
 */
@RestController
@RequestMapping("/todo")
class TodoController(private val service: TodoService) {

    @GetMapping
    fun getTodos(): MutableList<TodoModel> {
        return service.getTodos();
    }

    @PostMapping
    fun createTodo(@Valid @RequestBody payload: TodoPayload): ResponseEntity<ApiResponse> {
        val response: ApiResponse = service.createTodo(payload);
        return ResponseEntity.status(response.status).body(response);
    }

    @PutMapping
    fun updateTodo(
        @RequestParam id: Long,
        @Valid @RequestBody payload: TodoPayload
    ): ResponseEntity<ApiResponse> {
        val response: ApiResponse = service.updateTodo(id, payload);
        return ResponseEntity.status(response.status).body(response);
    }

    @DeleteMapping
    fun deleteTodo(
        @RequestParam id: Long
    ): ResponseEntity<ApiResponse> {
        val response: ApiResponse = service.deleteTodo(id);
        return ResponseEntity.status(response.status).body(response);
    }


}