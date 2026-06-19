package FactoryMethodPatternExample;

public class ExeclDocumentFactory extends DocumentFactory{
    @Override
    public  ExeclDocument createDocument() {
        return  new ConcreteExcelDocument();
    }
}
