package agh.dp.builder;

import agh.dp.builder.Nodes.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String getJsonContent(String filename) throws IOException {
        return Files.readString(Paths.get(filename));
    }

    public static boolean isValid(String json){
        // TODO:
        return true;
    }

    public static void main(String[] args) throws IOException {
        // insert path
        String jsonRaw = getJsonContent("src/main/resources/probe1.json");
        if (!isValid(jsonRaw)) {
            System.out.println("Provided json file is invalid");
            return;
        }

        Manager manager = new Manager(jsonRaw);
        JSONObject object = manager.createObjectBuilder().build();
        System.out.println(object.toString());
    }
}
