package com.example.mailnotification.service;

import com.example.mailnotification.model.PaymentDTO;

public interface ISendService {
    void send(PaymentDTO paymentDTO);
}
