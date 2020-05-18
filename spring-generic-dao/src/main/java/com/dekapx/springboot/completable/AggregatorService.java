package com.dekapx.springboot.completable;

import java.util.concurrent.ExecutionException;

public interface AggregatorService {
    AggregatedResponse aggregate() throws ExecutionException, InterruptedException;
}
