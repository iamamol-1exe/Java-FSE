package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.Document;
import FactoryMethodPatternExample.documents.PdfDocument;
import FactoryMethodPatternExample.concrete.ConcretePdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name, int size) {
        return new ConcretePdfDocument(name,size);
    }
}
