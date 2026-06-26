package com.amolD;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product();
        p1.setProductId(1);
        p1.setProductName("Biscuit");
        p1.setPrice(24);
        p1.setQuantity(100);

        Product p2 = new Product();
        p2.setProductId(2);
        p2.setProductName("Kurkure");
        p2.setPrice(10);
        p2.setQuantity(100);

        Product p3 = new Product();
        p3.setProductId(3);
        p3.setProductName("Maggi");
        p3.setPrice(20);
        p3.setQuantity(100);

        Store storeWithMap = new StoreWithHashMap();

        storeWithMap.addProduct(p1);
        storeWithMap.addProduct(p2);
        storeWithMap.addProduct(p3);

        System.out.println("HashMap Store:");
        System.out.println(storeWithMap.getProducts());

        System.out.println("Product with ID 2:");
        System.out.println(storeWithMap.getProduct(2));

        Product updatedProduct = new Product();
        updatedProduct.setProductId(2);
        updatedProduct.setProductName("Kurkure (Updated)");
        updatedProduct.setPrice(15);
        updatedProduct.setQuantity(200);

        storeWithMap.updateProduct(2, updatedProduct);

        System.out.println("After Update:");
        System.out.println(storeWithMap.getProduct(2));

        storeWithMap.removeProduct(1);

        System.out.println("After Removing Product ID 1:");
        System.out.println(storeWithMap.getProducts());



        Store storeWithList = new StoreWithList();

        storeWithList.addProduct(p1);
        storeWithList.addProduct(p2);
        storeWithList.addProduct(p3);

        System.out.println("\nArrayList Store:");
        System.out.println(storeWithList.getProducts());

        System.out.println("Product with ID 3:");
        System.out.println(storeWithList.getProduct(3));

        Product updatedProduct2 = new Product();
        updatedProduct2.setProductId(3);
        updatedProduct2.setProductName("Maggi (Updated)");
        updatedProduct2.setPrice(25);
        updatedProduct2.setQuantity(150);

        storeWithList.updateProduct(3, updatedProduct2);

        System.out.println("After Update:");
        System.out.println(storeWithList.getProduct(3));

        storeWithList.removeProduct(2);

        System.out.println("After Removing Product ID 2:");
        System.out.println(storeWithList.getProducts());
    }
}


//StoreWithList
//Time Complexity:
//Average: O(1)
//Worst: O(n) (when the ArrayList resizes)
//Normally, the product is added at the end. Occasionally, the internal array becomes full
// and a larger array is created, requiring all elements to be copied.



//2. StoreWithHashMap
//Map<Integer, Product> products = new HashMap<>();
//
//Add Product
//products.put(product.getProductId(), product);

//Time Complexity:
//
//Average: O(1)
//Worst: O(n) (many hash collisions or during resizing)


//Update Product
//Product p = products.get(id);
//if(p != null){
//        p.setPrice(newPrice);
//}
//
//Time Complexity:
//
//Average: O(1)
//Worst: O(n)

//
//| Operation | ArrayList    | HashMap      |
//        | --------- | ------------ | ------------ |
//        | Add       | O(1) average | O(1) average |
//        | Search    | O(n)         | O(1) average |
//        | Update    | O(n)         | O(1) average |
//        | Delete    | O(n)         | O(1) average |


//
//How can these operations be optimized?
//For StoreWithList
//Using a HashMap instead of a list if products are frequently searched by productId.
//Keep the list only if insertion order or indexed access is important.
//If searching by name is common, maintain another map indexed by product name.

//For StoreWithHashMap
//Using productId as the key, since it is unique.
//Choose a suitable initial capacity if many products are expected to reduce resizing: