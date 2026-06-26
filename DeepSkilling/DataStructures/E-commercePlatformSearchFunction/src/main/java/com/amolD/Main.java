package com.amolD;


import java.util.Scanner;

//Linear search checks each product one by one until it finds the required product or reaches the end of the list.
//Best Case: O(1) (the product is the first element)
// Average Case: O(n)
// Worst Case: O(n) (the product is the last element or does not exist)


//Binary Search
//Sorting: O(n log n)
//Binary Search: O(log n)
//Total Time (your current implementation): O(n log n)
//If the products are already sorted, then:
//Best Case: O(1)
//Average Case: O(log n)
//Worst Case: O(log n)


//Linear Search is suitable for small datasets because it is simple and does not require sorting.
//Binary Search is better for large datasets, but only if the products are already sorted.


class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Product p1 = new Product(1,"Mobile",10000,1000);
        Product p2 = new Product(2,"Tablet",2000,2000);
        Product p3 = new Product(3,"Washing Machine",3000,3000);
        Product p4 = new Product(4,"Desktop",4000,4000);
        Product p5 = new Product(5,"Laptop",5000,5000);

        ECommerce eCommerce = new ECommerce();
        eCommerce.addProduct(p1);
        eCommerce.addProduct(p2);
        eCommerce.addProduct(p3);
        eCommerce.addProduct(p4);
        eCommerce.addProduct(p5);


        while(true){
            System.out.println("Choose an option for search 1 for Linear search and 2 for binary search");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter product id:");
                int id = sc.nextInt();
                Product product = eCommerce.getProductsByLinearSearch(id);
                System.out.println(product);
            }
            else if(choice==2){
                System.out.println("Enter product id:");
                int id = sc.nextInt();
                Product product = eCommerce.getProductsByBinarySearch(id);
                System.out.println(product);
            }
        }



    }
}