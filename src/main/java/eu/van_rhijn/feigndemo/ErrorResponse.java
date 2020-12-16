package eu.van_rhijn.feigndemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private List<String> details;
}
