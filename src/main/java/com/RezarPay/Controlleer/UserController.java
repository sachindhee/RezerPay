package com.RezarPay.Controlleer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/Massage")
    public String getMassage(){
        return "Wellcome to this Page";
    }


}
