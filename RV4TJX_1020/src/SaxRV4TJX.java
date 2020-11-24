package sax;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaxRV4TJX {
    Connection kap;
    public SaxRV4TJX() {
    }
    public static void main(String[] args) {
        SaxRV4TJX prog = new SaxRV4TJX();
        prog.feldolgoz();
    }

    public void feldolgoz() {
        XMLReader xmlr = new SAXParser();
        Elemzo sch = new Elemzo();
        xmlr.setContentHandler(sch);

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            kap = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","u1","u1");

            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            xmlr.parse("C:\\Users\\xplee\\IdeaProjects\\RV4TJXxmlGyak\\RV4TJX_1020\\szemelyek.xml");
        } catch (IOException e) {
            System.out.println("IO hiba: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX hiba");
        }
    }

    class Elemzo implements ContentHandler {
        int te,se,le;
        String tv,sv,lv;

        public void startElement(String uri, String localName, String qName,
                                 Attributes atts) {
            if (localName.compareTo("nev")==0) {
                te = 1;
            }
            if (localName.compareTo("kor")==0) {
                se = 1;
            }
            if (localName.compareTo("varos")==0) {
                le = 1;
            }
        }
        public void endElement(String uri, String localName, String qName) {
            if (localName.compareTo("tipus")==0) {
                te = 0;
            }
            if (localName.compareTo("szint")==0) {
                se = 0;
            }
            if (localName.compareTo("leiras")==0) {
                le = 0;
                if (Integer.parseInt(sv) > 2) {
                    if (tv.compareTo("hiba")==0) {
                        String sql = "INSERT INTO HIBAUZENETEK VALUES(" + sv + ",SYSDATE,'"
                                + lv + "')";
                        System.out.println(sql);
                        try {
                            Statement pp = kap.createStatement();
                            pp.executeUpdate(sql);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }
            }
        }
        public void characters(char[] ch, int start, int length) {
            //System.out.println(String.valueOf(start)+":"+String.valueOf(length));
            String t = new String(ch);
            String sz = t.substring(start,start + length);
            if (te == 1) {tv = sz;}
            if (se == 1) {sv = sz;}
            if (le == 1) {lv = sz;}

        }
    }
}