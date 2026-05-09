package com.eazybytes.accounts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "student")
@Getter
@Setter
public class DefaultAccountConfigDto{

    public String message;
    public Map<String,String> identity;
    public List<String> phoneNumber;
}
