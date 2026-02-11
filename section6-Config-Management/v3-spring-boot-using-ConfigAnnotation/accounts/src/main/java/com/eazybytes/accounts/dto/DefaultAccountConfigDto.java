package com.eazybytes.accounts.dto;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "student")
public record DefaultAccountConfigDto(String message, Map<String,String> identity, List<String> phoneNumber) {
}
