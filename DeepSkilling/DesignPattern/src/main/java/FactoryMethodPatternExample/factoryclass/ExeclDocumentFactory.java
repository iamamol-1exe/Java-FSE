package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.ExeclDocument;
import FactoryMethodPatternExample.concrete.ConcreteExcelDocument;

public class ExeclDocumentFactory extends DocumentFactory {
    @Override
    public ExeclDocument createDocument() {
        return  new ConcreteExcelDocument();
    }
}
