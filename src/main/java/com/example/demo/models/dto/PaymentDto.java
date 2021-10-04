package com.example.demo.models.dto;

import com.example.demo.models.Type;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data

public class PaymentDto {


    private String id;

    private List<Type> type;

    private double totalCost;

    private String senderName;


}
