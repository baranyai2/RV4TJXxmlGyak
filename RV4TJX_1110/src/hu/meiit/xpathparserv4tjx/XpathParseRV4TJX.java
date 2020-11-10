package hu.meiit.xpathparserv4tjx;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathParseRV4TJX {

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory =
                DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("RV4TJX_1110/studentRV4TJX.xml");
        XPath xpath = XPathFactory.newInstance().newXPath();
        // XPath Query for showing all nodes value
        XPathExpression expr = xpath.compile("//student/*/text()");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getParentNode().getNodeName() + ": " + nodes.item(i).getNodeValue());
        }
    }
}
