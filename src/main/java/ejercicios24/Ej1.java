package ejercicios24;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ej1 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo del documento XML");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final del documento XML");
    }
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Principio Elemento: " + qName);
    }
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Fin Elemento: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("[\t\n]", ""); // quitar saltos de línea
        if (!car.trim().isEmpty()){ //Para evitar que haya caracteres vacíos
            System.out.println("Caracteres : "+car);
        }
    }

}
