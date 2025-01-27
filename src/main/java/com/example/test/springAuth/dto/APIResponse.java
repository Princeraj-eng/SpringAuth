package com.example.test.springAuth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class APIResponse<T> {

    private String message;
    private String status;
    private List<ErrorDTO> error;
    private T result;
    private Object isSoftUpdate;
    private Boolean isHardUpdate;
}
