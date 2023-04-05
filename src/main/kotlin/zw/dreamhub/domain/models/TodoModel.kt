package zw.dreamhub.domain.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 5/4/2023
 */

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class TodoModel(
    @Column(nullable = false, unique = true) var title: String?,
    @Column(nullable = false) var description: String?
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    var id: Long? = null

    @UpdateTimestamp
    var updatedAt: Instant? = null

    @CreationTimestamp
    var createdAt: Instant? = null

    fun update(title: String, description: String) {
        this.description = description
        this.title = title
    }

}