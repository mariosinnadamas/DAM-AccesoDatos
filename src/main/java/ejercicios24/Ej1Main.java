package ejercicios24;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Ej1Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //Creamos una instacia del manejador que hemos hecho
            Ej1 handler = new Ej1();
            // Le decimos al parser que procese un archivo determinado con dicho manejador
            saxParser.parse(new File("Recursos/carrera.xml"), handler);
        } catch (ParserConfigurationException | SAXException |
                 IOException e) {
            e.printStackTrace();
        }
    }
}
