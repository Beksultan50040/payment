package com.example.demo.service;

import com.example.demo.models.Payment;
import com.example.demo.models.dto.PaymentDto;
import org.springframework.data.domain.Page;

public interface PaymentService {

    String save(Payment payment);
    Page<PaymentDto> findAll(int page, int size);
    PaymentDto findById(String id);
    String deleteAll();
}
