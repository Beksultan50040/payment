package com.example.demo.feign;


import com.example.demo.models.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "eureka-client-service")
public interface ClientFeign {

    @GetMapping("/api/v1/client/findAll")
    List<ClientDto> findAll();

    @GetMapping("/api/v1/client/{id}")
    ClientDto findById(@RequestParam Long id);

}
