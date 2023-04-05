package zw.dreamhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import zw.dreamhub.domain.models.TodoModel
import java.util.*

@Repository
interface TodoRepository : JpaRepository<TodoModel, Long> {
    fun findByTitle(title: String): Optional<TodoModel>
}