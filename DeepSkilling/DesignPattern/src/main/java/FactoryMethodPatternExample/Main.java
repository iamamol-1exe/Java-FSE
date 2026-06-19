package FactoryMethodPatternExample;

import FactoryMethodPatternExample.documents.Document;
import FactoryMethodPatternExample.factoryclass.DocumentFactory;
import FactoryMethodPatternExample.factoryclass.PdfDocumentFactory;
import FactoryMethodPatternExample.factoryclass.WordDocumentFactory;
import FactoryMethodPatternExample.factoryclass.ExeclDocumentFactory;
public class Main {
    public static void main(String[] args) {

        DocumentFactory excelFactory = new ExeclDocumentFactory();
        Document excel = excelFactory.createDocument("sttdd.xlsx", 54);
        excel.printDeatails();



        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument("doc.pdf", 54);
        pdf.printDeatails();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument("otdt.docx", 54);
        word.printDeatails();
    }
}
