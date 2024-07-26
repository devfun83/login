package com.example.email.config;
 
import java.util.concurrent.Executor;
 
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {
 
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);    // 실행 대기 중인 최소 Thread의 개수
        executor.setMaxPoolSize(5);     // 동시에 동작하는 최대 Thread의 개수
        executor.setQueueCapacity(10);  // 큐의 최대 용량 (CorePool의 크기를 넘어서면 큐에 저장함)
        executor.setThreadNamePrefix("Async MailExecutor");
        executor.initialize();
        return executor;
    }
 
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }
}