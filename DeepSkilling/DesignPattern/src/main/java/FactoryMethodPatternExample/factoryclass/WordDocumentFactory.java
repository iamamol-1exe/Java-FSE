package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.WordDocument;
import FactoryMethodPatternExample.concrete.ConcreteWordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public WordDocument createDocument() {
       return new ConcreteWordDocument();
    }

}
