package com.RezarPay.Controlleer;

import com.RezarPay.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymet")
@RequiredArgsConstructor
public class PaymetController {

private final PaymentService paymentService;   

    @PostMapping("/createOrder")
    public String createOrder(@RequestParam int amount) {
        try {
            return paymentService.createOrder(amount, "INR");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while creating order: " + e.getMessage();
        }
    }


}
