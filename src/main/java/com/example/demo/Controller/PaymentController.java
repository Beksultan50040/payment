package com.example.demo.Controller;

import com.example.demo.DAO.PaymentRepo;
import com.example.demo.feign.ClientFeign;
import com.example.demo.models.Payment;
import com.example.demo.models.dto.ClientDto;
import org.elasticsearch.search.suggest.SortBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    PaymentRepo paymentRepo;


    @PostMapping("/save")
    public String createPayment(@RequestBody Payment payment){
        paymentRepo.save(payment);
        return "created";
    }


    @GetMapping("/findAll")
    public Page<Payment> findAll(){
        Page<Payment> page = paymentRepo.findAll(PageRequest.of(0,3, Sort.Direction.ASC,"id"));
        return page;
    }

    @GetMapping("/getByType")
    public List<Payment> getByType(@RequestParam String type){

        return paymentRepo.findByType(type);
    }

    @GetMapping("/openFeign/AllClients")
    public List<ClientDto> findAllClients(){
        return clientFeign.findAll();

    }@GetMapping("/openFeign/clientById")
    public ClientDto findClientById(@RequestParam Long id){
        return clientFeign.findById(id);
    }

    @DeleteMapping("/delete")
    public String deleteAll(){
        paymentRepo.deleteAll();
        return "Ok";
    }
}
