package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.Document;
import FactoryMethodPatternExample.documents.WordDocument;
import FactoryMethodPatternExample.concrete.ConcreteWordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name, int size) {
       return new ConcreteWordDocument(name,size);
    }

}
