package com.example.mailnotification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "client_table")
public class ClientEntity {
    @Id
    @Field(type = FieldType.Keyword)
    private String clientId;

    @Field(type = FieldType.Text)
    private String fullName;

    @Field(type = FieldType.Text)
    private String email;
}
