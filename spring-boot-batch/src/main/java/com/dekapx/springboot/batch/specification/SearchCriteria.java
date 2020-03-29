package com.dekapx.springboot.batch.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;
}
