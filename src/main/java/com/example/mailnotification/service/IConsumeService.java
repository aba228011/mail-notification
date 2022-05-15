package com.example.mailnotification.service;

import com.example.mailnotification.model.PaymentDTO;

public interface IConsumeService {
    void consumeMessage(PaymentDTO message);
}
