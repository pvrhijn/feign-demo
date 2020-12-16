package eu.van_rhijn.feigndemo;

import feign.Contract;
import feign.Feign;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Import(FeignClientsConfiguration.class)
public class ManualFeignController {

    private FeignClientInterface clientManual;

    public ManualFeignController(Contract contract) {
        this.clientManual = Feign.builder()
                .contract(contract)
                .decoder(((response, type) -> new FeignClientData(7, "manual", 10)))
                .target(FeignClientInterface.class, "http://localhost:8081");

    }

    @GetMapping("/data/manual/{id}")
    public FeignClientData getManualData(@PathVariable int id) {
        return clientManual.getData(id);
    }
}
