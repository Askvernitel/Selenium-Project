package org.project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class FileUtils {



/*
    public Object[][] getJsonData(String filePath){
        ObjectMapper mapper = new ObjectMapper();

        InputStream is = getFile("");
        if (is == null) {
            throw new RuntimeException("File not found: users.json");
        }

        List<User> users = mapper.readValue(is, new TypeReference<List<User>>() {});

        // Convert List<User> to Object[][] for TestNG
        Object[][] data = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }

        return data;
    }*/

    private InputStream getFile(String filePath){
        return getClass().getResourceAsStream(filePath);
    }
}
