package com.example.android.zhetai.androidlearning.Utils;

import android.content.Context;
import com.example.android.zhetai.androidlearning.Structure.ItemData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

public class DataManager {
    private Context context;
    private String fileName;

    public DataManager(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public static JSONArray toJSONArray(ArrayList<ItemData> items) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (ItemData item : items) {
            JSONObject jsonObject = item.toJSON();
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public void saveToFile(ArrayList<ItemData> items) throws JSONException, IOException {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(toJSONArray(items).toString());
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

            JSONArray jsonArray = (JSONArray) new JSONTokener(builder.toString()).nextValue();
            for (int i = 0; i < jsonArray.length(); i++) {
                ItemData item = ItemData.Companion.generateItemDataFromJSON(jsonArray.getJSONObject(i));
                items.add(item);
            }


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
