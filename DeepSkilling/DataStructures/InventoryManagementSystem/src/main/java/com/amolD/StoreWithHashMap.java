package com.amolD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//most operations are O(1) on average, but they can degrade in the worst case because of hash collisions.


public class StoreWithHashMap implements Store {
    private HashMap<Integer, Product> products;

    public StoreWithHashMap(){
        products = new HashMap<>();
    }

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry : products.entrySet()){
            productList.add(entry.getValue());
        }
        return productList;
    }

    public void addProduct(Product product){
        products.put(product.getProductId(),product);
        System.out.println("Added product with id " + product.getProductId());
    }

    // average time complexity O(1) and worst is O(n)
    public Product getProduct(int productId){
        return products.get(productId);
    }
    // average time complexity O(1) and worst is O(n)
    public void removeProduct(int productId){
        products.remove(productId);
        System.out.println("Removed product " + productId);
    }

    // average time complexity O(1) and worst is O(n)
    public Product updateProduct(int productId, Product product){
        products.put(productId, product);
        System.out.println("Updated product " + productId);
        return product;
    }

}
