package task6;

import java.util.*;

public class Task6Main {
    public static void main(String[] args) {

        //Task1
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++){
            int id = random.nextInt(100);

            int rangeMin = 1, rangeMax = 5;
            double gpa = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            gpa = (double) ((int) (gpa * 10)) / 10;
            students.add(new Student(id, "Student" + i, gpa));
        }

        System.out.println("------------------Task1-------------------");
        System.out.println("Shuffled list:");
        printList(students);
        Sorting.insertionSort(students);
        System.out.println("Sorted list:");
        printList(students);

        //Task2
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        };

        Collections.shuffle(students);
        System.out.println();
        System.out.println("------------------Task2-------------------");
        System.out.println("Shuffled list:");
        printList(students);
        Sorting.quickSort(students, 0, students.size() - 1, comparator);
        System.out.println("Sorted list:");
        printList(students);

        //Task3
        List<Student> students2 = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            int id = random.nextInt(100);

            int rangeMin = 1, rangeMax = 5;
            double gpa = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            gpa = (double) ((int) (gpa * 10)) / 10;
            students2.add(new Student(id, "Student" + i, gpa));
        }

        System.out.println("------------------Task3-------------------");
        System.out.println("Shuffled first list:");
        printList(students);
        System.out.println("Shuffled second list:");
        printList(students2);
        students.addAll(students2);
        System.out.println("Merged list:");
        List<Student> res = Sorting.mergeSort(students);
        printList(res);
    }

    private static <T> void printList(List<T> list){
        for (T data : list){
            System.out.println(data);
        }
    }

}
