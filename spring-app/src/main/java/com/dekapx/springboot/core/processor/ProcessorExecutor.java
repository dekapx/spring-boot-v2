package com.dekapx.springboot.core.processor;

import java.util.List;

public interface ProcessorExecutor {
    void execute(List<Processor> processors);
}
