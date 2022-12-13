package agh.dp.builder;

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
        String jsonRaw = getJsonContent("probe1.json");
        if (!isValid(jsonRaw)) {
            System.out.println("Provided json file is invalid");
            return;
        }

        Manager manager = new Manager(jsonRaw);
        JSONObject object = manager.createObjectBuilder().build();

        System.out.println(object.toString());
    }
}
