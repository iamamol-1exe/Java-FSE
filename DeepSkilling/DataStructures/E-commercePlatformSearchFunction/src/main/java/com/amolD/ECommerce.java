package com.amolD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ECommerce {
    private List<Product> products;

    public ECommerce() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }
    public Product getProductsByLinearSearch(int id){
        for(Product product:products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public Product getProductsByBinarySearch(int id ){
        products.sort(Comparator.comparingInt(Product::getId));
        int i =0;
        int j = products.size()-1;
        while (i <= j){
            int mid = (i+j)/2;
            if (products.get(mid).getId() == id){
                return products.get(mid);
            } else if (products.get(mid).getId() <  id ) {
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return null;
    }
}
