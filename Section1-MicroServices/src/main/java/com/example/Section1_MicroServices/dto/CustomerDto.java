package com.example.Section1_MicroServices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "Customer",
        description = "this schema holds Customer & Account details"
)
public class CustomerDto {

    @Schema(
            name="customerName",
            example = "John Doe"
    )
    @NotEmpty
    @Size(min=5, max=30, message = "Reduce name length by 30")
    private String name;

    @Schema(
            name="customerEmail",
            example = "johndoe@gmail.com"
    )
    @NotEmpty
    @Email(message = "Enter valid e-mail address")
    private String email;

    @Schema(
            name="customerMobileNumber",
            example = "2321324342"
    )
    @Pattern(regexp ="(^$|[0-9]{10})",message = "Enter correct mobileNumber")
    private String mobileNumber;

    private AccountDto accountDto;
}
