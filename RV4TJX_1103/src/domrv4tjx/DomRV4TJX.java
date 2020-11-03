package domrv4tjx;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class DomRV4TJX {
    public static void main(String argv[])
    {
        try
        {
//creating a constructor of file class and parsing an XML file
            File file = new File("C:/Users/xplee/IdeaProjects/RV4TJXxmlGyak/Rv4TJX_1103/szemelyek.xml");
//an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            Element rootElement = doc.getDocumentElement();
            System.out.println("Gyökér elem: " + rootElement.getNodeName());
            NodeList childNodes = rootElement.getChildNodes();
// nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < childNodes.getLength(); itr++)
            {
                Node node = childNodes.item(itr);
                //System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    String id = eElement.getAttribute("id");
                    System.out.println("id: " + id);

                    Node actualNode = eElement.getFirstChild();
                    while(actualNode != null) {
                        if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element actualElement = (Element)actualNode;
                            System.out.println("  " + actualElement.getNodeName() + ": " + actualElement.getTextContent());
                        }
                        actualNode = actualNode.getNextSibling();
                        }
                    System.out.println();
                    }
                    /*System.out.println("Név: "+ eElement.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("Kor: "+ eElement.getElementsByTagName("kor").item(0).getTextContent());
                    System.out.println("Város: "+ eElement.getElementsByTagName("varos").item(0).getTextContent());*/
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

