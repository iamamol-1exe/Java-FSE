package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.Document;
import FactoryMethodPatternExample.documents.ExeclDocument;
import FactoryMethodPatternExample.concrete.ConcreteExcelDocument;

public class ExeclDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name, int size) {
        return  new ConcreteExcelDocument(name,size);
    }
}
