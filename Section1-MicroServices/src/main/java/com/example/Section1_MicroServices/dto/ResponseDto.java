package com.example.Section1_MicroServices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Response",
        description = "show the response messages"
)
public class ResponseDto {

    @Schema(
            name="shows status_code",
            example = "500"
    )
    private String statusCode;

    @Schema(
            name = "shows response message",
            example = "Successfully created"
    )
    private String statusMessage;
}
