package eu.van_rhijn.feigndemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feign-client-interface", url = "http://localhost:8081")
public interface FeignClientInterface {

    @GetMapping("/data/{dataId}")
    FeignClientData getData(@PathVariable int dataId);
}
