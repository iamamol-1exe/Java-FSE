package FactoryMethodPatternExample.concrete;

import FactoryMethodPatternExample.documents.PdfDocument;
import FactoryMethodPatternExample.documents.WordDocument;

public class ConcreteWordDocument implements WordDocument {

    String name;
    int size;

   public  ConcreteWordDocument(String name,int size) {
       this.name = name;
        this.size = size;
   }

    @Override
    public void WordPrint() {
        System.out.println("WORD");
    }

    @Override
    public void printDeatails() {
        System.out.println(PdfDocument.type);

        System.out.println(STR."Name : \{name}");
        System.out.println(STR."Size : \{size}");

    }
}
