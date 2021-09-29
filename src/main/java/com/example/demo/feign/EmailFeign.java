package com.example.demo.feign;


import com.example.demo.models.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "eureka-email-service")
public interface EmailFeign {


    @PostMapping("/email/client-email/")
    String clientEmail(@RequestParam String email);

    @PostMapping("/email/worker-email/")
    String workerEmail(@RequestParam String id);
}
