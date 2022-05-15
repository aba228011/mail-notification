package com.example.mailnotification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;

    private String clientId;

    private Date paymentDate;

    private ServiceClass[] typeOfServices;
}
