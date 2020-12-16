package eu.van_rhijn.feigndemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AppController {
    private final FeignClientInterface client;

    @GetMapping("/data/{id}")
    public FeignClientData getData(@PathVariable int id) {
        FeignClientData feignClientData = null;
        try {
            feignClientData = client.getData(id);
        } catch (CustomException e) {
           e.getErrorResponse().getDetails().forEach(log::info);
        }
        return feignClientData;
    }
}
