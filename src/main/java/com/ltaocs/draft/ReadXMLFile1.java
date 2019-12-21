package com.ltaocs.draft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 8:11 AM
 */
public class ReadXMLFile1 {
    public static void main(String[] args) throws IOException, DocumentException {

            URL url = new URL("http://api.worldbank.org/v2/country");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream stream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    stream));
            StringBuffer document = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                document.append(line);
            }
            //System.out.println(document);

        SAXReader sr = new SAXReader();
            Document doc = sr.read(reader);
        Element els = doc.getRootElement();
        for (Iterator it = els.elementIterator(); it.hasNext();) {
            Element ele = (Element) it.next();
            String idx = ele.attribute("id").getValue();
            for (Iterator it2 = ele.elementIterator(); it2.hasNext();) {
                Element elel = (Element) it2.next();
                if (idx.equals("ABW") ){
                    //map.put(elel.getName(),elel.getText());
                    System.out.println(elel.getName());
                }
            }
        }


    }
}
