package FactoryMethodPatternExample.factoryclass;

import FactoryMethodPatternExample.documents.PdfDocument;
import FactoryMethodPatternExample.concrete.ConcretePdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public PdfDocument createDocument() {
        return new ConcretePdfDocument();
    }
}
