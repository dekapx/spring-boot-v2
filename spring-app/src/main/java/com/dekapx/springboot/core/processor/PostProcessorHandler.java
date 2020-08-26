package com.dekapx.springboot.core.processor;

import com.dekapx.springboot.core.annotation.PostProcessor;
import org.aspectj.lang.ProceedingJoinPoint;

public interface PostProcessorHandler {
    Object postProcess(ProceedingJoinPoint joinPoint, PostProcessor postProcessor) throws Throwable;
}
