package FactoryMethodPatternExample;

public class ConcretePdfDocument implements PdfDocument{
    @Override
    public void PdfPrint() {
        System.out.println("PDF");
    }
}
