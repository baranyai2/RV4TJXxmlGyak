package hu.domparse.rv4tjx;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyRV4TJX {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("XMLFeladatRV4TJX/XMLRV4TJX.xml")); //XML dokumentum betöltése

            //Futárok neveinek és fizetéseinek megváltoztatása
            Node futarok = doc.getElementsByTagName("futarok").item(0);
            NodeList flist = futarok.getChildNodes();
            System.out.println("Módosított elemek: ");
            for (int i = 0; i < flist.getLength(); i++) {
                Node node = flist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    if(eElement.getElementsByTagName("nev").item(0).getTextContent().equals("Schmidt Henrik")) {
                        eElement.getElementsByTagName("nev").item(0).setTextContent("Kiss Csaba");
                        System.out.println("Módosított név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    }
                    if(eElement.getElementsByTagName("nev").item(0).getTextContent().equals("German Jakab")) {
                        eElement.getElementsByTagName("nev").item(0).setTextContent("Nagy Béla");
                        System.out.println("Módosított név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    }
                    if(eElement.getElementsByTagName("fizetes").item(0).getTextContent().equals("20000")) {
                        eElement.getElementsByTagName("fizetes").item(0).setTextContent("25000");
                        System.out.println("Módosított fizetés : " + eElement.getElementsByTagName("fizetes").item(0).getTextContent()+", nála: "+eElement.getElementsByTagName("nev").item(0).getTextContent());
                    }
                }
            }
            //Rendelők adatainak módosítása
            Node rendelok = doc.getElementsByTagName("rendelok").item(0);
            NodeList rlist = rendelok.getChildNodes();

            for (int i = 0; i < rlist.getLength(); i++) {
                Node node = rlist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    if(eElement.getElementsByTagName("nev").item(0).getTextContent().equals("Kiss Péter")) {
                        eElement.getElementsByTagName("nev").item(0).setTextContent("Példa János");
                        System.out.println("Módosított név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    }
                    if(eElement.getElementsByTagName("email").item(0).getTextContent().equals("sanyesz@gmail.com")) {
                        eElement.getElementsByTagName("email").item(0).setTextContent("sanyeszka@gmail.com");
                        System.out.println("Módosított email : " + eElement.getElementsByTagName("email").item(0).getTextContent());
                    }
                }
            }
            //Ételek adatainak módosítása
            Node etelek = doc.getElementsByTagName("etelek").item(0);
            NodeList elist = etelek.getChildNodes();

            for (int i = 0; i < elist.getLength(); i++) {
                Node node = elist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    if(eElement.getElementsByTagName("nev").item(0).getTextContent().equals("Sonkás pizza")) {
                        eElement.getElementsByTagName("nev").item(0).setTextContent("Hawaii pizza");
                        System.out.println("Módosított név : " + eElement.getElementsByTagName("nev").item(0).getTextContent());
                    }
                    if(eElement.getElementsByTagName("feltetek").item(0).getTextContent().equals("Sonka")) {
                        eElement.getElementsByTagName("feltetek").item(0).setTextContent("Ananász");
                        System.out.println("Módosított feltet : " + eElement.getElementsByTagName("feltetek").item(0).getTextContent());
                    }
                }
            }

            //Read Osztály alapján való kiíratás
            Element rootElement = doc.getDocumentElement();
            System.out.println("Gyökér elem: " + rootElement.getNodeName());
            NodeList childNodes = rootElement.getChildNodes();
            for(int i=0; i<childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)node;
                    Node actualNode = element.getFirstChild();
                    while(actualNode != null) {
                        if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element actualElement = (Element)actualNode;
                            System.out.println(" " + actualElement.getNodeName() + ": " + actualElement.getTextContent());
                        }
                        actualNode=actualNode.getNextSibling();
                    }
                    System.out.println();
                }
                //Kiíratott értékek átírása egy új XML fájlba
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("XMLFeladatRV4TJX/XMLRV4TJXnew.xml"));
                transformer.transform(source, result);
            }

        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
