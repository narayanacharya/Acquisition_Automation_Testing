package bdd.helper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class FileProcess {

    public String readJsonFile(String filePath) {
        String result = null;
        try {
            DataInputStream reader = new DataInputStream(new FileInputStream(filePath));
            int nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                result = new String(bytes);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public JsonObject getDataFromFile(String filePath) {
        String jsonData = readJsonFile(filePath);
        Gson gson = new Gson();
        JsonObject body;
        body = gson.fromJson(jsonData, JsonObject.class);
        return body;

    }


}
