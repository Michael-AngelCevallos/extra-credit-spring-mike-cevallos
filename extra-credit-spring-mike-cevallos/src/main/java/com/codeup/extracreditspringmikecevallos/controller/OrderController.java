package com.codeup.extracreditspringmikecevallos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {

    @GetMapping("/orders") // shows ALL ORDERS
        public String allOrders (){
            return "/orders/show";
        }


    @GetMapping("/orders/create") // shows create form
    public String getRecordForm(){
       return "orders/create";
    }

    @PostMapping("/orders/create") // Create a new order form
    public String postRecord(){


        return "redirect:/orders";
    }


    @GetMapping("/orders/{id}") //View the information about a specific order
    public String showOneRecord(@PathVariable long id, Model mode){

        return "orders/show";
    }


//    @GetMapping("/orders/{id}/update") // View the form to modify an existing order
//
//    @PostMapping("/orders/{id}/update") // Modifies the existing order
//
//    @PostMapping("/orders/{id}/delete") // delete an order


}
