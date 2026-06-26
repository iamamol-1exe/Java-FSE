package com.amolD;

import java.util.List;

public interface Store {
    void addProduct(Product product);
    List<Product> getProducts();
    Product getProduct(int id);
    Product updateProduct(int id, Product product);
    void removeProduct(int id);

}
