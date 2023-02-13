package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class CustomerController {
    @GetMapping("/customers")
    public String showList(){
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "customers/list";
    }
}
