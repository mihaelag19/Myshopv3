package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.itschool.exception.CustomException;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //-------------------DELETE ORDER BY ID-------------------------------------------

    @RequestMapping(value = "/order/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteById(id);
        } catch (CustomException e) {
            return "this order can't be deleted";
        }
        return "deleted";
    }

//    //-------------------UPDATE ORDER ------------------------------------------
//    @GetMapping("/order/updateorder")
//    public String addAccount(Model model) {
//        Order order = new Order();
//        model.addAttribute("order", order);
//
//        return "orders";
//    }
//
//    @PostMapping("/order/updateorder")
//    public String addAccount(@ModelAttribute Order order) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        order.setUser(userService.findUserByUserName(auth.getName()));
//        orderService.save(order);
//        return Constants.REDIRECT_TO_INDEX;
//    }


}
