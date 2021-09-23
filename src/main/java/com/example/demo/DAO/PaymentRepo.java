package com.example.demo.DAO;

import com.example.demo.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PaymentRepo extends ElasticsearchRepository<Payment, String> {

    Page<Payment> findAll();
    List<Payment> findByType(String type);
}
