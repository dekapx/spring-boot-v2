package com.dekapx.springboot.core.aspect;

import com.dekapx.springboot.core.annotation.PostProcessor;
import com.dekapx.springboot.core.processor.PostProcessorHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class PostProcessorAspect {
    private PostProcessorHandler postProcessorHandler;

    @Autowired
    public PostProcessorAspect(final PostProcessorHandler postProcessorHandler) {
        this.postProcessorHandler = postProcessorHandler;
    }

    @Around("execution(* *(..)) && @annotation(postProcessor)")
    public Object around(final ProceedingJoinPoint joinPoint, final PostProcessor postProcessor) {
        Object result = null;
        try {
            result = this.postProcessorHandler.postProcess(joinPoint, postProcessor);
        } catch (Throwable throwable) {
            log.error("Exception while handling PostProcessor...", throwable);
        }
        return result;
    }
}
