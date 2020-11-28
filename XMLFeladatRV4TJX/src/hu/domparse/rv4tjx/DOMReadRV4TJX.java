package hu.domparse.rv4tjx;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMReadRV4TJX {
    public static void main(String argv[])
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("XMLFeladatRV4TJX/XMLRV4TJX.xml")); //Hivatkozás a beolvasott file-ra
            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement(); //Gyökér elem kiválasztása
            System.out.println("Gyökér elem: " + rootElement.getNodeName());
            NodeList childNodes = rootElement.getChildNodes(); //Gyökér elem gyerekeinek eltárolása

            for(int i=0; i<childNodes.getLength(); i++) {//Gyerek elemek végigjárása
                Node node = childNodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(node.getNodeName() + ": ");
                    Element element = (Element)node;
                    Node actualNode = element.getFirstChild();
                    while(actualNode != null) {
                        if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element actualElement = (Element)actualNode;
                            System.out.println(" " + actualElement.getNodeName() + ": " + actualElement.getTextContent());//Kiírjuk az aktuális elem adatait
                        }
                        actualNode=actualNode.getNextSibling();
                    }
                }
            }
        }
        catch(ParserConfigurationException e){ //Futás esetében létrejöhető kivételek kezelése
            e.printStackTrace();
        }catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
