package com.example.Section1_MicroServices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "shows error response"
)
public class ErrorResponseDto {

    @Schema(
            name = "api",
            example = "/login"
    )
    private String apiAuth;

    private HttpStatus statusCode;

    @Schema(
            name = "errorMessage",
            example = "Bad Request"
    )
    private String errorMessage;

    private LocalDateTime localDateTime;
}
