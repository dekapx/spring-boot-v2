package com.dekapx.springboot.core.processor;

import com.dekapx.springboot.core.annotation.PostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PostProcessorHandlerImpl extends AbstractProcessorHandler implements PostProcessorHandler {
    private ProcessorExecutor processorExecutor;

    @Autowired
    public PostProcessorHandlerImpl(final ProcessorExecutor processorExecutor) {
        this.processorExecutor = processorExecutor;
    }

    @Override
    public void postProcess(final ProceedingJoinPoint joinPoint, final PostProcessor postProcessor) throws Throwable {
        joinPoint.proceed();

        final Class[] processorTypes = postProcessor.processorTypes();
        final List<Processor> processors = getProcessors(processorTypes);
        processorExecutor.execute(processors);
    }
}
