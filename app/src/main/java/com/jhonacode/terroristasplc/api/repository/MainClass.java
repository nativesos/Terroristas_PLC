package com.jhonacode.terroristasplc.api.repository;

import android.content.Context;
import android.content.ContextWrapper;

import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MainClass extends ContextWrapper {
    public MainClass(Context base) {
        super(base);
    }

    public void writeJSONToFile( Map<String, String> entryMap, NodeList entries, int i) {
        File file = new File(getFilesDir(), "file.json");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            fileWriter.write("[\n");

            String entryJson = "\t{\n";
            for (Map.Entry<String, String> data : entryMap.entrySet()) {
                entryJson += "\t\"" + data.getKey() + "\": \"" + data.getValue().replace("\n", "") + "\",\n";
            }
            entryJson = entryJson.substring(0, entryJson.length() - 2) + "\n\t}\n";


            fileWriter.write(entryJson);

            if (i < entries.getLength() - 1) {
                fileWriter.write(",");
            }

            fileWriter.write("]");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}