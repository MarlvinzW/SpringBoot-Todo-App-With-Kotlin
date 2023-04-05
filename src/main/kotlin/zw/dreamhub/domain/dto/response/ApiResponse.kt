package zw.dreamhub.domain.dto.response


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 5/4/2023
 */
data class ApiResponse(
    var status: Int,
    var successful: Boolean,
    var message: String
)
