package task12;

import java.util.Locale;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;

    public Person(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFCS(){
        StringBuilder builder = new StringBuilder(this.lastName);
        builder.append(" ");

        if (firstName != null){
            builder.append(firstName.toUpperCase().charAt(0)).append(".");
        }
        if (patronymic != null){
            builder.append(patronymic.toUpperCase().charAt(0)).append(".");
        }

        return builder.toString().trim();
    }
}
