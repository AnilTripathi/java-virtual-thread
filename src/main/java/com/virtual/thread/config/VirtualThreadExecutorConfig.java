package com.virtual.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class VirtualThreadExecutorConfig {

    // For internal async/background operations
    @Bean(name = "internalAsyncExecutor")
    public ExecutorService internalAsyncExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}
