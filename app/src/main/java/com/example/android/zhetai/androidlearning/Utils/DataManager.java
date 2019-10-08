package com.example.android.zhetai.androidlearning.Utils;

import android.content.Context;
import com.example.android.zhetai.androidlearning.Structure.ItemData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;

import java.io.*;
import java.util.ArrayList;

public class DataManager {
    private Context context;
    private String fileName;
    private Gson gson;

    public DataManager(Context context, String fileName, Gson gson) {
        this.context = context;
        this.fileName = fileName;
        this.gson = gson;
    }

    public void saveListToFile(ArrayList<ItemData> items) throws JSONException, IOException {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(gson.toJson(items));
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public ArrayList<ItemData> loadFromFile() throws IOException, JSONException {
        ArrayList<ItemData> items = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(fileName);
            StringBuilder builder = new StringBuilder();
            String line;
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            ArrayList<ItemData> retrivedData = gson.fromJson(builder.toString(),
                    new TypeToken<ArrayList<ItemData>>() {
                    }.getType());

            items.addAll(retrivedData);
        } catch (FileNotFoundException ignored) {

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }

        }
        return items;
    }
}
