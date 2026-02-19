package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "java")
public  record JavaVersionDto(String path) {

}
