package com.example.android.zhetai.androidlearning.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtil {
    private NetworkUtil() {
    }

    /**
     * Return the source file of the URL.
     *
     * @param URL
     * @return String
     */
    public static String loadURL(final String URL) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );
            StringBuffer urlContent = new StringBuffer();
            String curLine;
            while((curLine = reader.readLine())!=null){
                urlContent.append(curLine);
            }
            return urlContent.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
