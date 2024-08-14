package com.dekapx.apps.core.search;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value;
}
