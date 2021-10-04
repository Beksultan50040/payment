package com.example.demo.mappers.impl;


import com.example.demo.DAO.PaymentRepo;
import com.example.demo.feign.ClientFeign;
import com.example.demo.mappers.PageMapper;
import com.example.demo.models.Payment;
import com.example.demo.models.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageMapperImpl implements PageMapper {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ClientFeign clientFeign;


    @Override
    public Page<PaymentDto> toDto(Page<Payment> payments) {

        Page<PaymentDto> paymentDto = payments.map(this::convertToObjectDto);

        return paymentDto;
    }


    private PaymentDto convertToObjectDto(Payment p) {
        PaymentDto dto = new PaymentDto();
        dto.setId(p.getId());
        dto.setType(p.getType());
//        dto.setCost(p.getCost());
        dto.setSenderName(clientFeign.findById(p.getClientId()).getSenderName());
        return dto;
    }

    @Override
    public PaymentDto toDTO(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setType(payment.getType());
//      paymentDto.setCost(payment.getCost());
        paymentDto.setSenderName(clientFeign.findById(payment.getClientId()).getSenderName());
        return paymentDto;
    }


}

