package com.example.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PojoRequest {
    @NotBlank(message = "ID Cannot be blank")
    private String Id;
    @NotBlank(message = " Request ID cannot be blank")
    private String requestId;
    @NotBlank(message = " Name cannot be blank")
    private String name;
    @NotBlank(message = " CorrelationId ID cannot be blank")
    private String CorrelationId;
}
