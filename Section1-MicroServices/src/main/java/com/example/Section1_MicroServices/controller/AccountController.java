package com.example.Section1_MicroServices.controller;

import com.example.Section1_MicroServices.constants.AccountConstants;
import com.example.Section1_MicroServices.dto.AccountDto;
import com.example.Section1_MicroServices.dto.CustomerDto;
import com.example.Section1_MicroServices.dto.ErrorResponseDto;
import com.example.Section1_MicroServices.dto.ResponseDto;
import com.example.Section1_MicroServices.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD REST APIs for Accounts in SimpleBank",
        description = "(CRUD REST APIs in SimpleBank to CREATE,UPDATE,FETCH AND DELETE account details)"
)
public class AccountController {

    private IAccountService iAccountService;

   @Operation(
           summary = "Create Account RestAPI",
           description = "REST API to create new Customer & Account inside SimpleBank"
   )
    @ApiResponse(
            responseCode ="201",
            description = "HTTP status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> greet(@RequestBody @Valid CustomerDto customerDto)
    {
        iAccountService.createAccount(customerDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }



    @Operation(
            summary = "Fetch Account Details RestAPI",
            description = "REST API to fetch Customer & Account details based on mobile number"
    )
    @ApiResponse(
            responseCode ="200",
            description = "HTTP status OK"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam
                                                        @Pattern(regexp ="(^$|[0-9]{10})",message = "Enter correct mobileNumber")
                                                        String mobileNumber)
    {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerDto);
    }




    @Operation(
            summary = "Update Account Details RestAPI",
            description = "REST API to update Customer & Account details based on account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode ="200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode ="500",
                    description = "HTTP status Internal Server Error"
            ),
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@RequestBody @Valid CustomerDto customerDto)
    {
        boolean isUpdated = iAccountService.updateAccount(customerDto);
        if(isUpdated)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
    }

    @Operation(
            summary = "Delete Account & Details RestAPI",
            description = "REST API to delete Customer & Account details based on mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode ="200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode ="500",
                    description = "HTTP status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam
                                                          @Pattern(regexp ="(^$|[0-9]{10})",message = "Enter correct mobileNumber")
                                                          String mobile)
    {
        if(iAccountService.deleteCustomer(mobile))
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
    }
}
