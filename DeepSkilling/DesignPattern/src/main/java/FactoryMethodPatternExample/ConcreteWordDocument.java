package FactoryMethodPatternExample;

public class ConcreteWordDocument implements WordDocument{
    @Override
    public void WordPrint() {
        System.out.println("WORD");
    }
}
