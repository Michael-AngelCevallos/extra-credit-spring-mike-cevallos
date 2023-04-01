package com.codeup.extracreditspringmikecevallos.controller;

import com.codeup.extracreditspringmikecevallos.Repository.OrderRepository;
import com.codeup.extracreditspringmikecevallos.model.Order;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class OrderController {

    private final OrderRepository ordersDao;


    public OrderController(OrderRepository ordersDao){
        this.ordersDao = ordersDao;
    }

    @GetMapping("/orders") // shows ALL ORDERS
        public String allOrders (Model model){
        model.addAttribute("ads", ordersDao.findAll());
            return "/orders/show";
        }


    @GetMapping("/orders/create") // shows create form
    public String getRecordForm(){
       return "orders/create";
    }

    @PostMapping("/orders/create") // Create a new order form
    public String postRecord(@RequestParam (name = "email") String email, @RequestParam(name ="totalPrice") double totalPrice){
        Order order = new Order(email, totalPrice);
        ordersDao.save(order);
        return "redirect:/orders";
    }


    @GetMapping("/orders/{id}") //View the information about a specific order
    public String showOneRecord(@PathVariable long id, Model model){
    Order order = ordersDao.findById(id);
        model.addAttribute(order == null? new Order("not found", 0) : order);
        return "orders/show";
    }


//    @GetMapping("/orders/{id}/update") // View the form to modify an existing order

    @GetMapping("/orders/{id}/update")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        // TODO: Implement the code to retrieve the order with the given id and pass it to the view for updating
        Order order = ordersDao.getOrderById(id);
        model.addAttribute("order", order);
        return "orders/updateOrder";
    }
//
//    @PostMapping("/orders/{id}/update") // Modifies the existing order

//    @PostMapping("/orders/{id}/update")
//    public String updateOrder(@PathVariable Long id, @ModelAttribute Order updatedOrder) {
//        // TODO: Implement the code to update the order with the given id using the values from the updatedOrder object
//        Order oldOrder = ordersDao.getOrderById(id);
//        oldOrder.setEmail(updatedOrder.getEmail());
//        oldOrder.setTotalPrice(updatedOrder.getTotalPrice());
//        ordersDao.updateOrder(oldOrder);
//        return "redirect:/orders" + id;
//    }

//    @PostMapping("/orders/{id}/delete") // delete an order


}
