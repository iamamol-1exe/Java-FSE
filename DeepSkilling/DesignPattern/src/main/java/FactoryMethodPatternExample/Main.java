package FactoryMethodPatternExample;

public class Main {
    public static void main(String[] args) {
        ExeclDocumentFactory execlDocumentFactory = new ExeclDocumentFactory();
        ExeclDocument execlDocument = execlDocumentFactory.createDocument();
        execlDocument.ExeclPrint();


        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdf = pdfFactory.createDocument();
        pdf.PdfPrint();

        WordDocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument word = wordFactory.createDocument();
        word.WordPrint();


    }
}
