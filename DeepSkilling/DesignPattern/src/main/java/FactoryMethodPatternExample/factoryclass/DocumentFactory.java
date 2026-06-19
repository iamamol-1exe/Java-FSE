package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument(String name,int size);
}
