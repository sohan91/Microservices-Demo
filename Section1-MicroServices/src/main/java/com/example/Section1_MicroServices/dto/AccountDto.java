package com.example.Section1_MicroServices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Schema(
        name="Accounts",
        description="this schema hold accounts details"
)
public class AccountDto {

    @Schema(
            name = "accountNumber",
            example = "2321432332"
    )
    @NotEmpty
    @Pattern(regexp ="(^$|[0-9]{10})",message = "Enter correct AccountNumber")
    private Long accountNumber;

    @Schema(
            name = "accountType",
            example = "savings"
    )
    @NotEmpty(message = "AccountType can't be null")
    private String accountType;

    @Schema(name = "branchAddress",
    example = "123 INDIA")
    @NotEmpty(message = "BranchAddress can't be null")
    private String branchAddress;
}
