package FactoryMethodPatternExample.concrete;

import FactoryMethodPatternExample.documents.WordDocument;

public class ConcreteWordDocument implements WordDocument {
    @Override
    public void WordPrint() {
        System.out.println("WORD");
    }
}
