package com.hesen.share.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Hesen
 * @Date   2018/4/19 13:09
 *
 * 配置线程池
 */
@Configuration
@EnableAsync
public class AsyncTaskExecutePool {

    private final static Logger LOG = LoggerFactory.getLogger(AsyncTaskExecutePool.class);

    private int corePoolSize = 20;

    private int maxPoolSize = 50;

    private int keepAliveSeconds = 300;

    private int queueCapacity = 200;

    @Bean("threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(getCorePoolSize());
        executor.setMaxPoolSize(getMaxPoolSize());
        executor.setQueueCapacity(getQueueCapacity());
        executor.setKeepAliveSeconds(getKeepAliveSeconds());
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }




    public int getCorePoolSize() {
        return corePoolSize;
    }

    public AsyncTaskExecutePool setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        return this;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public AsyncTaskExecutePool setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        return this;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public AsyncTaskExecutePool setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
        return this;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public AsyncTaskExecutePool setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
        return this;
    }
}
