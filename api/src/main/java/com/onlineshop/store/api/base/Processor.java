package com.onlineshop.store.api.base;

public interface Processor<I extends ProcessorInput, R extends ProcessorResult>{
    R process(I input);
}
