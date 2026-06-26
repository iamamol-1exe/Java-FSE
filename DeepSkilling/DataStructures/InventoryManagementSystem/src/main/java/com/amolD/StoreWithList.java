package com.amolD;

import java.util.ArrayList;
import java.util.List;

public class StoreWithList implements Store {
    private List<Product> products;

    public StoreWithList(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Added product " + product);
    }

    public List<Product> getProducts(){
        return products;
    }


    public Product updateProduct(int id,Product product){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductId()==product.getProductId()){
                products.set(i,product);
                break;
            }
        }
        System.out.println("Updated product " + product);
        return product;
    }

    public void removeProduct(int id){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductId()== id){
                products.remove(i);
                break;
            }
        }
        System.out.println("Removed product ");

    }

    public Product getProduct(int productId){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductId()==productId){
                return products.get(i);
            }
        }
        return  null;
    }

}
