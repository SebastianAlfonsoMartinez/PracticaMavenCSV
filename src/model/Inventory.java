package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }





}
