package FactoryMethodPatternExample;

public class ConcreteExcelDocument implements  ExeclDocument{
    @Override
    public void ExeclPrint() {
        System.out.println("Excel");
    }
}
