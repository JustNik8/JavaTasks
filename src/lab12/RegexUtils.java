package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    /**
    This method finds matches by pattern and returns list of matched items
     **/
    public static List<String> getListByPattern(String string, Pattern pattern){
        Matcher mather = pattern.matcher(string);

        List<String> prices = new ArrayList<>();
        while (mather.find()){
            prices.add(mather.group());
        }

        return prices;
    }

    /**
     This method returns boolean
     */
    public static boolean checkConditionByPattern(String string, Pattern pattern){
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    /*
    public static boolean checkStringMatching(String string, Pattern pattern){
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }*/

    public static boolean isPasswordSave(String pass){

        if (validatePassword(pass)) {
            Pattern passPattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_]).{8,}");
            Matcher passMatcher = passPattern.matcher(pass);
            return passMatcher.matches();
        }
        return false;
    }

    private static boolean validatePassword(String pass){
        for (char ch : pass.toCharArray()){
            if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z') || ch == '_')){
                return false;
            }
        }
        return true;
    }
}
