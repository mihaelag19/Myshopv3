package ro.itschool.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Role;
import ro.itschool.service.OrderService;
import ro.itschool.service.ProductService;
import ro.itschool.service.UserService;
import ro.itschool.util.Constants;

import java.util.HashSet;
import java.util.Set;

@Component
public class RunAtStartUP {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;



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


//        Set<Order> orders = new HashSet<>();
//        Order order= new Order();
//        order.setAmount(50D);
//        order.setCurrency("RON");
//        order.setUser(myUser);
//        order.setStatus("Completed");
//        order.setDateCreated(LocalDateTime.now());
//        Set<Product> products = new HashSet<>();
//        Product product =new Product();
//        product.setName("Prom dress4");
//        product.setDescription("This is prom dress4");
//        product.setPrice(440D);
//        product.setPictureUrl("d:\\Users\\Asus\\Desktop\\Pictures\\4.jpg");
//        products.add(product);
//        order.setProducts(products);
//        orders.add(order);
//        myUser.setOrders(orders);
//        orderService.save(order);
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


//        Set<Order> orders = new HashSet<>();
//        Order order= new Order();
//        order.setAmount(120D);
//        order.setCurrency("RON");
//        order.setUser(myUser);
//        order.setStatus("In progress");
//        order.setDateCreated(LocalDateTime.now());

//        Set<Product> products = new HashSet<>();
//        Product product =new Product();
//        product.setName("Prom dress3");
//        product.setDescription("This is prom dress3");
//        product.setPrice(440D);
//        product.setPictureUrl("d:\\Users\\Asus\\Desktop\\Pictures\\3.jpg");

//        products.add(product);
//        order.setProducts(products);
//        orders.add(order);
//        myUser.setOrders(orders);
//        orderService.save(order);
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

//
//        Set<Order> orders = new HashSet<>();
//        Order order= new Order();
//        order.setAmount(45D);
//        order.setCurrency("RON");
//        order.setUser(myUser);
//        order.setStatus("In progress");
//        order.setDateCreated(LocalDateTime.now());

//        Set<Product> products = new HashSet<>();
//        Product product =new Product();
//        product.setName("Prom dress2");
//        product.setDescription("This is prom dress2");
//        product.setPrice(400D);
//        product.setPictureUrl("d:\\Users\\Asus\\Desktop\\Pictures\\2.jpg");
//
//        products.add(product);
//        order.setProducts(products);
//        orders.add(order);
//        myUser.setOrders(orders);
//        orderService.save(order);
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

//
//        Set<Order> orders = new HashSet<>();
//        Order order= new Order();
//        order.setAmount(67D);
//        order.setCurrency("RON");
//        order.setUser(myUser);
//        order.setStatus("In progress");
//        order.setDateCreated(LocalDateTime.now());

//        Set<Product> products = new HashSet<>();
//        Product product =new Product();
//        product.setName("Prom dress1");
//        product.setDescription("This is prom dress1");
//        product.setPrice(500D);
//        product.setPictureUrl("d:\\Users\\Asus\\Desktop\\Pictures\\1.jpg");
//
//        products.add(product);
//        order.setProducts(products);
//        orders.add(order);
//        myUser.setOrders(orders);
//        orderService.save(order);
        userService.saveUser(myUser);
    }
}
