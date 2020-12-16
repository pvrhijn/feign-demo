package eu.van_rhijn.feigndemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException{
    private ErrorResponse errorResponse;
    private static final long serialVersionUID = 1L;

    public CustomException(ErrorResponse errorResponse) {
        super();
        this.errorResponse = errorResponse;
    }
}
