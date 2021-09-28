package com.example.demo.mappers;

import com.example.demo.models.Payment;
import com.example.demo.models.dto.PaymentDto;
import org.springframework.data.domain.Page;

public interface PageMapper {

    Page<PaymentDto> toDto(Page<Payment> payments);

    PaymentDto toDTO(Payment payment);
}
