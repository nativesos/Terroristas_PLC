package com.jhonacode.terroristasplc.api.repository;

import android.content.Context;
import android.content.ContextWrapper;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRepository extends ContextWrapper {
    public ApiRepository(Context base) {
        super(base);
    }

    final String FILE_NAME = "terroristas.json";
    final String URI = "https://www.treasury.gov/ofac/downloads/consolidated/consolidated.xml";

    public File file(){

        return new File(getFilesDir(), FILE_NAME);

    }

    public HttpURLConnection httpConnection(){
        HttpURLConnection connection;
        try {
            URL url = new URL(URI);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
