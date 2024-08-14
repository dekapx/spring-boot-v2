package com.dekapx.apps.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class BaseModel {
    @Schema(description = "Unique identifier.", example = "1", required = true)
    private Long id;
}
