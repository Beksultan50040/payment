package com.example.demo.models.dto;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data

public class PaymentDto {


    private String id;


    private String type;


    private double cost;


    private String senderName;


}
