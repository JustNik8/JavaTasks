package task13and14;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student{

    public static final int DATE_BRIEF = 0;
    public static final int DATE_MEDIUM = 1;
    public static final int DATE_FULL = 2;

    private int id;
    private String name;
    private double gpa;
    private Date birthDate;

    public Student(int id, String name, double gpa, Date birthDate) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.birthDate = birthDate;
    }

    public String getBirthDay(int type){

        String pattern = switch (type){
            case DATE_BRIEF -> "dd.MM.yyyy";
            case DATE_MEDIUM -> "dd MMMM, yyyy 'г.'";
            case DATE_FULL -> "EEEE', 'dd MMMM yyyy 'г.'";
            default -> null;
        };


        if (pattern == null) {return null;}

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(birthDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setsName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}