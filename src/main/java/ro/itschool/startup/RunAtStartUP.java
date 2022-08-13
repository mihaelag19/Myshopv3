package ro.itschool.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Order;
import ro.itschool.entity.Role;
import ro.itschool.service.UserService;
import ro.itschool.util.Constants;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class RunAtStartUP {
    @Autowired
    private UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        MyUser myUser = new MyUser();
        myUser.setUsername("user0");
        myUser.setPassword("user0");
        myUser.setRandomToken("randomToken");
        final Role roleUser = new Role(Constants.ROLE_USER);
        final Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user@gmail.com");
        myUser.setFullName("Popescu Laura");
        myUser.setPasswordConfirm("user0");
        myUser.setRandomTokenEmail("randomToken");


        Set<Order> orders = new HashSet<>();
        Order order= new Order();
        order.setAmount(50D);
        order.setCurrency("RON");
        order.setUser(myUser);
        order.setStatus("Saved");
        order.setDateCreated(LocalDateTime.now());

        Order order2= new Order();
        order2.setAmount(40D);
        order2.setCurrency("RON");
        order2.setUser(myUser);
        order2.setStatus("Saved");
        order2.setDateCreated(LocalDateTime.now());

        orders.add(order);
        orders.add(order2);
        myUser.setOrders(orders);

        userService.saveUser(myUser);


    }

    private void saveAdminUser() {

        MyUser myUser = new MyUser();
        myUser.setUsername("admin");
        myUser.setPassword("admin");
        myUser.setRandomToken("randomToken");
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role(Constants.ROLE_USER));
        roles.add(new Role(Constants.ROLE_ADMIN));
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user2@gmail.com");
        myUser.setFullName("Stanculet Simona");
        myUser.setPasswordConfirm("admin");
        myUser.setRandomTokenEmail("randomToken");


        Set<Order> orders = new HashSet<>();
        Order order= new Order();
        order.setAmount(120D);
        order.setCurrency("RON");
        order.setUser(myUser);
        order.setStatus("In progress");
        order.setDateCreated(LocalDateTime.now());

        Order order2= new Order();
        order2.setAmount(23D);
        order2.setCurrency("RON");
        order2.setUser(myUser);
        order2.setStatus("In progress");
        order2.setDateCreated(LocalDateTime.now());

        orders.add(order);
        orders.add(order2);
        myUser.setOrders(orders);


        userService.saveUser(myUser);
    }

    private void saveAnotherUser() {

        MyUser myUser = new MyUser();
        myUser.setUsername("user2");
        myUser.setPassword("user2");
        myUser.setRandomToken("randomToken");
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role(Constants.ROLE_USER));
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user22@gmail.com");
        myUser.setFullName("Safciu Giulia");
        myUser.setPasswordConfirm("user2");
        myUser.setRandomTokenEmail("randomToken");



        Set<Order> orders = new HashSet<>();
        Order order= new Order();
        order.setAmount(45D);
        order.setCurrency("RON");
        order.setUser(myUser);
        order.setStatus("In progress");
        order.setDateCreated(LocalDateTime.now());

        Order order2= new Order();
        order2.setAmount(33D);
        order2.setCurrency("RON");
        order2.setUser(myUser);
        order2.setStatus("In progress");
        order2.setDateCreated(LocalDateTime.now());

        orders.add(order);
        orders.add(order2);
        myUser.setOrders(orders);


        userService.saveUser(myUser);


    }


    private void saveAnotherUser2() {

        MyUser myUser = new MyUser();
        myUser.setUsername("user3");
        myUser.setPassword("user3");
        myUser.setRandomToken("randomToken");
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role(Constants.ROLE_USER));
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user223@gmail.com");
        myUser.setFullName("Pop Violeta");
        myUser.setPasswordConfirm("user3");
        myUser.setRandomTokenEmail("randomToken");


        Set<Order> orders = new HashSet<>();
        Order order= new Order();
        order.setAmount(67D);
        order.setCurrency("RON");
        order.setUser(myUser);
        order.setStatus("In progress");
        order.setDateCreated(LocalDateTime.now());

        Order order2= new Order();
        order2.setAmount(89D);
        order2.setCurrency("RON");
        order2.setUser(myUser);
        order2.setStatus("In progress");
        order2.setDateCreated(LocalDateTime.now());

        orders.add(order);
        orders.add(order2);
        myUser.setOrders(orders);

        userService.saveUser(myUser);
    }
}
