import java.util.HashMap;
import java.util.Map;

public class OldPhoneCode {

    public static final Map<Integer, String> MOBILE_DIGITS = new HashMap<>();

    static{
        MOBILE_DIGITS.put(1," ");
        MOBILE_DIGITS.put(2,"ABC");
        MOBILE_DIGITS.put(3,"DEF");
        MOBILE_DIGITS.put(4,"GHI");
        MOBILE_DIGITS.put(5,"JKL");
        MOBILE_DIGITS.put(6,"MNOP");
        MOBILE_DIGITS.put(7,"QRS");
        MOBILE_DIGITS.put(8,"TUV");
        MOBILE_DIGITS.put(9,"WXYZ");
        MOBILE_DIGITS.put(0, "\n");
    }

    /*public static int findPosition(String character){
        int position = 0;
        for (Integer key : MOBILE_DIGITS.keySet()){
            String str = MOBILE_DIGITS.get(key);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                String cToString = String.valueOf(c);
                if (cToString.equals(character)){
                    position = i+1;
                }
            }
            for (int i = 0; i < position; i++){
                System.out.print(key);
            }
        }

        return position;

    }*/
}
