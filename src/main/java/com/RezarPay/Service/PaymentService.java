package com.RezarPay.Service;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    @Value("${razorpay.key_id}")
    private String razorpayKeyId;


    @Value("${razorpay.key_secret}")
    private String razorpaySecret;

    public String createOrder(int amount, String currency) throws Exception {
        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpaySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // paise me (500 = ₹5)
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", "txn_123456");

        Order order = razorpay.orders.create(orderRequest);
        return order.toString();
    }
}



