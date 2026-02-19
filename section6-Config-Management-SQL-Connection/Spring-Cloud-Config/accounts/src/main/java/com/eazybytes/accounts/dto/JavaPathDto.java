package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "java")
public  record JavaPathDto(String path) {

}
