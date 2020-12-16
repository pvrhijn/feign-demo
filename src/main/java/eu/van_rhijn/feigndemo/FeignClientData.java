package eu.van_rhijn.feigndemo;

import lombok.Value;

@Value
public class FeignClientData {
    int id;
    String name;
    int amount;
}
