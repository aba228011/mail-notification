package com.example.mailnotification.service;

import com.example.mailnotification.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class SendService implements ISendService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public void send(PaymentDTO PaymentDTO) {
        System.out.println(PaymentDTO.getPaymentId());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("it.sapiens.228@gmail.com");
        simpleMailMessage.setTo("abulai2001@gmail.com");

        String title = "Тема: Оплата квитанции №" + PaymentDTO.getPaymentId();
        simpleMailMessage.setSubject(title);

        String serviceStrRow = "";
        double amount = 0;
        if (PaymentDTO.getTypeOfServices().length > 0) {
            for (ServiceClass serviceClass: PaymentDTO.getTypeOfServices()) {
                ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.getServiceTypeEntityByCode(serviceClass.getCodeService());
                serviceStrRow += serviceTypeEntity.getName_ru() + " - " + serviceClass.getPriceService() + "\n";
                amount += serviceClass.getPriceService();
            }
        }

        String fullNameOfClient = clientRepository.getClientEntityByClientId(PaymentDTO.getClientId()).getFullName();
        String body = MessageFormat.format(
                "Благодарим вас, {0}, за оплату коммунальных услуг с помощью нашего сервиса. \n" +
                        "        Оплачены услуги: \n" +
                        "        {1}" +
                        "        Всего: {2} тенге",
                fullNameOfClient, serviceStrRow, amount);

        simpleMailMessage.setText(body);

        this.mailSender.send(simpleMailMessage);
        System.out.println("Mail sent success..");
    }
}
