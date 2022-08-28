package ro.itschool.global;

import ro.itschool.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart=new ArrayList<Product>();
    }
}
