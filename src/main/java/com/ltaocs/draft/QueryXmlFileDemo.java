package com.ltaocs.draft;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 8:06 AM
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

import java.io.File;

public class QueryXmlFileDemo {

    public static void main(String argv[]) {

        try {
            File inputFile = new File("worldbankXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("wb:country");
            System.out.println("----------------------------");
            System.out.println(nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :");
                ///System.out.print(nNode.getNodeName());
                org.w3c.dom.Node node = nList.item(temp);
                NamedNodeMap namedNodeMap = node.getAttributes();
                String id = namedNodeMap.getNamedItem("id").getTextContent();
                if (id.equals("BHS")) {
                    String capitalC = namedNodeMap.getNamedItem("BHS").getChildNodes().item(6).toString();
                    //String capitalC = namedNodeMap.getNamedItem("BHS").getAttributes().item(6).toString();
                    System.out.println(capitalC);

                }

                //nNode.getAttributes().
                //System.out.println(nNode.getNodeName());
                if (nNode.getAttributes().equals("AFG")) {
                    System.out.println("true");
                    //System.out.println(nNode.getAttributes().equals("wb:capitalCity"));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}