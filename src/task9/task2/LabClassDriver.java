package task9.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LabClassDriver {

    private static Random random = new Random();

    public static List<Student> generateListOfStudents(int amount){
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < amount; i++){
            int id = random.nextInt(100);

            int rangeMin = 1, rangeMax = 5;
            double gpa = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            gpa = (double) ((int) (gpa * 10)) / 10;
            students.add(new Student(id, "Student" + i, gpa));
        }

        return students;
    }
}
