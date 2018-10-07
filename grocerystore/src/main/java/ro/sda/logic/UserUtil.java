package ro.sda.logic;

import java.util.HashMap;
import java.util.Map;

public class UserUtil {

    public static boolean checkUser(String user, String password){
        Map<String, String> usersList = new HashMap<String, String>();
        usersList.put("admin", "admin");
        usersList.put("victor","victor");
        usersList.put("user","parola");
        usersList.put("user1","parola1");
        usersList.put("user2","parola2");
        usersList.put("user3","parola3");

        //complexitate On
        for(Map.Entry<String, String> entry: usersList.entrySet()){
            if(entry.getKey().equals(user) && entry.getValue().equals(password)){
                return true;
            }
        }
        return false;
        /*
        nu mai itereaza prin tot map-ul -  complexitate O1
        if(usersList.get(user) != null){
            if(password != null){
                return password.equals(usersList.get(user));
            }
        }
        return false;
    */
    }

}
