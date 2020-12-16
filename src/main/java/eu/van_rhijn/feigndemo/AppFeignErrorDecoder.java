package eu.van_rhijn.feigndemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class AppFeignErrorDecoder implements ErrorDecoder {

    ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
                return new CustomException(errorResponse);
            default:
                return new RuntimeException();
        }
    }
}
