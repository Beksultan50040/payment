package com.example.demo.service.impl;

import com.example.demo.DAO.PaymentRepo;
import com.example.demo.feign.ClientFeign;
import com.example.demo.feign.EmailFeign;
import com.example.demo.mappers.PageMapper;
import com.example.demo.models.Payment;
import com.example.demo.models.dto.ClientDto;
import com.example.demo.models.dto.PaymentDto;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ClientFeign clientFeign;

    @Autowired
    private EmailFeign emailFeign;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public String save(Payment payment) {

        // Calculate the total cost of payments and save it
        payment.setTotalCost(payment.getType().stream().mapToDouble(o->o.getCost()).sum());
        paymentRepo.save(payment);

        // Get all the data of the client by sending client id to the Client - Service
        ClientDto clientDto = clientFeign.findById(payment.getClientId());

        // Send email to the client
        emailFeign.clientEmail(clientDto.getEmail());

        // Send email to the worker
        emailFeign.workerEmail(payment.getId());
        return "created";

//        ClientDto clientDto = clientFeign.findById(payment.getClientId());
//
//        if(clientDto==null){
//            return "there is no such user";
//        }
    }

    @Override
    public Page<PaymentDto> findAll(int page, int size) {

        Page<Payment> page1 = paymentRepo.findAll(PageRequest.of(page,size, Sort.Direction.ASC,"id"));

        return pageMapper.toDto(page1);
//        return page1;
    }

    @Override
    public PaymentDto findById(String id) {
        Payment payment = paymentRepo.findById(id).get();
        return pageMapper.toDTO(payment);
    }

    @Override
    public String deleteAll() {
        paymentRepo.deleteAll();
        return "deleted";
    }
}
