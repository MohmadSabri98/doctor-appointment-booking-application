package com.example.doctor.shared.abstractions;

import java.util.concurrent.CompletableFuture;

public interface QueryHandler<TQuery extends Query, TResult> {
    TResult handle(TQuery query);
}