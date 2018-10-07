package ro.sda.hypermarket.commons.util;


import org.apache.commons.lang3.StringUtils;

public class Validator {

    public static boolean validateCode(String code){
        if (!code.equals(null) || code.length() == 4 && code.chars().allMatch(Character::isLetter)){
            return true;
        }
        return false;
    }

    public static boolean validateCnp(String cnp){
        if(!cnp.equals(null) || cnp.length() == 13 && cnp.chars().allMatch(Character::isDigit)){
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String email){
        if(email.equals(null) || email.contains("@") && (StringUtils.countMatches(email, "@") == 1)){
            return true;
        }
        return false;
    }

    public static boolean validatePhoneNo(String phoneNo){
        if(!phoneNo.equals(null) || phoneNo.length() == 10 && phoneNo.chars().allMatch(Character::isDigit)){
            return true;
        }
        return false;
    }

    public static boolean hasText(String string){
        if(!string.equals(null) || !string.trim().isEmpty()){
            return true;
        }
        return false;
    }

}
