package com.example.books.model.test.config;

import lombok.Getter;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RestConfig {
    @Getter
    CacheControl cacheControlEnums = CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic();
}
