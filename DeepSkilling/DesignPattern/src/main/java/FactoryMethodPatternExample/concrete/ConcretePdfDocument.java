package FactoryMethodPatternExample.concrete;

import FactoryMethodPatternExample.documents.PdfDocument;

public class ConcretePdfDocument implements PdfDocument {
    @Override
    public void PdfPrint() {
        System.out.println("PDF");
    }
}
