package FactoryMethodPatternExample.concrete;

import FactoryMethodPatternExample.documents.ExeclDocument;
import FactoryMethodPatternExample.documents.PdfDocument;

public class ConcretePdfDocument implements PdfDocument {

    String name;
    int size;

    public ConcretePdfDocument(String name,int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void PdfPrint() {
        System.out.println("PDF");
    }

    public void printDeatails() {
        System.out.println(PdfDocument.type);

        System.out.println(STR."Name : \{name}");
        System.out.println(STR."Size : \{size}");

    }
}
