package com.example.demo.Controller;


import com.example.demo.models.Payment;
import com.example.demo.models.dto.ClientDto;
import com.example.demo.models.dto.PaymentDto;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/save")
    public String createPayment(@RequestBody Payment payment){

        return paymentService.save(payment);
    }


    @GetMapping("/findAll")
    public Page<PaymentDto> findAll(@RequestParam int page , @RequestParam int size){
       return paymentService.findAll(page, size);
    }



    @GetMapping("/findById")
    public PaymentDto findById(@RequestParam String id) {
        return paymentService.findById(id);
    }



    @DeleteMapping("/delete")
    public String deleteAll(){
        return paymentService.deleteAll();
    }
}
