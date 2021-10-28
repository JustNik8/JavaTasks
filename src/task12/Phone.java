package task12;

public class Phone {
    public static String getFormattedNumber(String number){

        if (number.startsWith("8") && number.length() != 11){
            throw new RuntimeException(number + " is invalid");
        }
        if (number.startsWith("+") && number.length() < 12){
            throw new RuntimeException(number + " is invalid");
        }

        StringBuilder builder = new StringBuilder();

        int len = number.length();
        String thirdPart = number.substring(len - 4, len);
        String secondPart = number.substring(len - 7, len - 4);
        String firstPart = number.substring(len-10, len-7);

        String code = number.substring(0, len-10);
        if (code.startsWith("8")){
            builder.append("+7 ");
        }
        else{
            builder.append(code).append(" ");
        }

        builder.append(firstPart).append(" ").append(secondPart).append(" ").append(thirdPart);

        return builder.toString();

    }
}
