package com.jhonacode.terroristasplc.api.repository;

import android.content.Context;

import java.util.*;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;

import java.io.InputStream;

import java.net.HttpURLConnection;

public class ApiRepository {


    public static void convert6(HttpURLConnection connection, Context base) {
        MainClass mainClass = new MainClass(base);
        try {

            int status = connection.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {

                // Procesar el XML
                InputStream inputStream = connection.getInputStream();

                Document document = convertInputStreamToDocument(inputStream);
                NodeList entries = document.getElementsByTagName("sdnEntry");


                for (int i = 0; i < entries.getLength(); i++) {
                    Node entry = entries.item(i);
                    NodeList entryData = entry.getChildNodes();

                    Map<String, String> entryMap = new HashMap<>();

                    for (int j = 0; j < entryData.getLength(); j++) {
                        Node data = entryData.item(j);
                        String dataName = data.getNodeName();
                        String dataValue = data.getTextContent();

                        if (dataName.equals("uid") || dataName.equals("firstName") || dataName.equals("lastName") || dataName.equals("sdnType") || dataName.equals("programList")) {
                            entryMap.put(

                                    dataName
                                            .replace("       "," ")
                                            .replace("      "," ")
                                            .replace("     "," ")
                                            .replace("    "," ")
                                            .replace("   "," ")
                                            .replace("  "," ")
                                            .trim(),
                                    dataValue
                                            .replace("       "," ")
                                            .replace("      "," ")
                                            .replace("     "," ")
                                            .replace("    "," ")
                                            .replace("   "," ")
                                            .replace("  "," ")
                                            .trim()
                            );
                        }
                    }


                    mainClass.writeJSONToFile(entryMap, entries, i);
                }

            } else {
                System.out.println("Error al obtener el XML");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ejecuewgfuew8ify78eft32g7f832");
    }


    public static Document convertInputStreamToDocument(InputStream inputStream) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
