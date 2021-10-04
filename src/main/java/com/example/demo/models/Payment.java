package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@Document(indexName = "client-payment", createIndex = true)
public class Payment {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;


    @Field(type = FieldType.Keyword)
    private Long clientId;

    private List<Type> type;

    @Field(type = FieldType.Keyword)
    private double totalCost;
}
