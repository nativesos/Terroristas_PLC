package com.jhonacode.terroristasplc.api.service;

import android.content.Context;
import android.content.ContextWrapper;

import com.jhonacode.terroristasplc.api.repository.ApiRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;

import java.io.InputStream;

import java.net.HttpURLConnection;

public class ApiService extends ContextWrapper {


    public ApiService(Context base) {
        super(base);
    }

    ApiRepository apiRepository = new ApiRepository( getBaseContext() );
    File file = apiRepository.file();
    public boolean importData(HttpURLConnection connection) {

        boolean isDataImported = true;

        try {

            int status = connection.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {

                // Procesar el XML
                InputStream inputStream = connection.getInputStream();
                Document document = convertInputStreamToDocument(inputStream);
                NodeList entries = document.getElementsByTagName("sdnEntry");

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("[\n");

                formatDataStream(entries, fileWriter);

                fileWriter.write("]");
                fileWriter.close();

            } else {

                isDataImported = false;
                System.out.println("Error al obtener el XML");

            }

        } catch (Exception e) {

            isDataImported = false;

            e.printStackTrace();

        }

        return isDataImported;
    }

    private Document convertInputStreamToDocument(InputStream inputStream) {
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

    private void formatDataStream(NodeList entries, FileWriter fileWriter) {

        for (int i = 0; i < entries.getLength(); i++) {
            try {

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
                                        .replace("       ", " ")
                                        .replace("      ", " ")
                                        .replace("     ", " ")
                                        .replace("    ", " ")
                                        .replace("   ", " ")
                                        .replace("  ", " ")
                                        .trim(),
                                dataValue
                                        .replace("       ", " ")
                                        .replace("      ", " ")
                                        .replace("     ", " ")
                                        .replace("    ", " ")
                                        .replace("   ", " ")
                                        .replace("  ", " ")
                                        .trim()
                        );
                    }
                }

                String entryJson = "\t{\n";
                for (Map.Entry<String, String> data : entryMap.entrySet()) {
                    entryJson += "\t\"" + data.getKey() + "\": \"" + data.getValue().replace("\n", "") + "\",\n";
                }
                entryJson = entryJson.substring(0, entryJson.length() - 2) + "\n\t}\n";


                fileWriter.write(entryJson);


                if (i < entries.getLength() - 1) {
                    fileWriter.write(",");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean isDataPresent(){
        return file.exists();
    }

}
