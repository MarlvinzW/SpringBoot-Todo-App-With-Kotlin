package zw.dreamhub.domain.dto.payload

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 5/4/2023
 */
data class TodoPayload(
    @NotNull @NotBlank
    var title: String,

    @NotNull @NotBlank
    var description: String
)
