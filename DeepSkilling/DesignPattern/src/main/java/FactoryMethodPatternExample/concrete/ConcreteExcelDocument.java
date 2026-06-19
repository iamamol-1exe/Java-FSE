package FactoryMethodPatternExample.concrete;

import FactoryMethodPatternExample.documents.ExeclDocument;

public class ConcreteExcelDocument implements ExeclDocument {


    private  String name;
    private int size;



    @Override
    public void ExeclPrint() {
        System.out.println("Excel");
    }

    public ConcreteExcelDocument(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void show(){
        System.out.println("Name: "+name);
    }

    @Override
    public void printDeatails() {
        System.out.println(ExeclDocument.type);

        System.out.println(STR."Name : \{name}");
        System.out.println(STR."Size : \{size}");

    }
}
