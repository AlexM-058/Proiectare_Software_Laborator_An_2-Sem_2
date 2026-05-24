package labs.lab_4;

import java.io.IOException;
import java.util.*;

public class AppLab4 {

    static void main(String args[]) throws IOException {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        for(String key : varste.keySet()){
            System.out.println(key + " " + varste.get(key));
        }
        HashMap<String,Tanar> tineri = new HashMap<>();
         for(String key : varste.keySet()){
             if(adrese.containsKey(key)){
                 Tanar t = new Tanar(key,varste.get(key),adrese.get(key));
                 tineri.put(key,t);
             }
         }
         System.out.println("\nTineri");
         for(String key : tineri.keySet()){
             Tanar t = tineri.get(key);
             System.out.println(t);
         }


    }
}
