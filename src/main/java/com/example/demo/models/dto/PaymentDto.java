package com.example.demo.models.dto;

import lombok.Data;

@Data

public class PaymentDto {


    private String id;


    private String type;


    private double cost;


    private Long clientId;
}
