package task12;

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
        StringBuilder builder = new StringBuilder();
        if (firstName != null){
            builder.append(firstName).append(" ");
        }
        if (lastName != null){
            builder.append(lastName).append(" ");
        }
        if (patronymic != null){
            builder.append(patronymic);
        }

        return builder.toString().trim();
    }
}
