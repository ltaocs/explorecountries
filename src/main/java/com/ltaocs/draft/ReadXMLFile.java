package com.ltaocs.draft;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 7:50 AM
 */

public class ReadXMLFile {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        URL url = new URL("http://api.worldbank.org/v2/country");
        URLConnection conn = url.openConnection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(conn.getInputStream());

        TransformerFactory transformerFactory= TransformerFactory.newInstance();
        Transformer xform = transformerFactory.newTransformer();

// that’s the default xform; use a stylesheet to get a real one
        xform.setOutputProperty(OutputKeys.INDENT, "yes");

//initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        xform.transform(source, result);

        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);

    }

}