package agh.dp.builder;

import java.util.ArrayList;

public class Manager {
    private final String json;
    private int index;

    public Manager(String json) {
        this.json = json.replaceAll("\\s", "");
    }

    public Builder createObjectBuilder() {
        Builder builder = new Builder();
        System.out.println(this.json);

        index = 1;
        while ( index < json.length()){
            if (json.charAt(index) == '"'){
                System.out.println(extractWord());
            }
            index ++;
        }
        
        return builder;
//        return null;
    }

    private String extractWord(){
        int startIndex = index;
        index ++;
        while (json.charAt(index) != '"'){
            index ++;
        }
        return json.substring(startIndex, index + 1);
    }

    private ArrayList<String> extractMapElement(){
        extractWord();
        return null;
    }
}
