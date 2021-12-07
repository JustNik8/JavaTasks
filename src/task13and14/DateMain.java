package task13and14;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateMain {

    private static final int BILLION = 10000000;
    private static final int MILLION = 1000000;

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task1(){
        System.out.println("--------Task1----------");
        Developer dev = new Developer("Sanya");
        dev.takeTask();
        System.out.println("Developer took task at " + dev.getLastReceivingTime());

    }

    private static void task2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------Task2----------");
        System.out.print("Введите дату в формате dd/mm/yyyy: ");
        //String[] dateArr = sc.nextLine().split("/");
        String[] dateArr = "24/11/2021".split("/"); //test
        if (dateArr.length != 3){
            System.out.println("Вы ввели неправильно");
        }
        else{
            try{
                int day = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]);
                int year = Integer.parseInt(dateArr[2]);

                Calendar userCal = Calendar.getInstance();
                userCal.set(Calendar.DAY_OF_MONTH, day);
                userCal.set(Calendar.MONTH, month-1);
                userCal.set(Calendar.YEAR, year);

                Calendar currentCal = Calendar.getInstance();

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                System.out.println("Текущая дата: " + sdf.format(currentCal.getTime()));
                System.out.println("Введеная дата: " + sdf.format(userCal.getTime()));

                if(currentCal.compareTo(userCal) == 0){
                    System.out.println("Даты равны");
                }
                else if (currentCal.compareTo(userCal) > 0){
                    System.out.println("Текущая дата больше введеной");
                }
                else{
                    System.out.println("Введеная дата больше текущей!");
                }
            }catch (NumberFormatException e){
                System.out.println("Неправильно ввели числа!");
            }
        }
    }

    private static void task3(){
        System.out.println("--------Task3----------");
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(Calendar.DAY_OF_MONTH, 4);
        birthCal.set(Calendar.MONTH, 6);
        birthCal.set(Calendar.YEAR, 2002);

        Student student = new Student(4, "Sanya", 4.5, birthCal.getTime());
        System.out.println("Краткий формат: " + student.getBirthDay(Student.DATE_BRIEF));
        System.out.println("Средний формат: " + student.getBirthDay(Student.DATE_MEDIUM));
        System.out.println("Полный формат: " + student.getBirthDay(Student.DATE_FULL));
    }

    private static void task4(){
        Scanner sc = new Scanner(System.in);

        System.out.println("--------Task4----------");
        System.out.println("Введите дату и время в формате <Год> <Месяц> <Число> <Час1> <Минуты>"); //test
        //String[] dateTimeArr = sc.nextLine().split(" "); //Ввод с консоли
        String[] dateTimeArr = "2021 11 20 14 27".split(" "); //Значение по умолчанию
        if (dateTimeArr.length != 5){
            System.out.println("Вы ввели неправильно");
        }
        else{
            int year = Integer.parseInt(dateTimeArr[0]);
            int month = Integer.parseInt(dateTimeArr[1]);
            int day = Integer.parseInt(dateTimeArr[2]);
            int hours = Integer.parseInt(dateTimeArr[3]);
            int minutes = Integer.parseInt(dateTimeArr[4]);

            String pattern = "'year: 'yyyy', month: 'MM', day: 'dd', hours: 'H', minutes: 'mm";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Calendar cal = createCalendar(year, month, day, hours, minutes);
            Date date = createDate(year, month, day, hours, minutes);

            System.out.println("Calendar: " + sdf.format(cal.getTime()));
            System.out.println("Date: " + sdf.format(date));
        }
    }

    private static Calendar createCalendar(int year, int month, int day, int hours, int minutes){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);

        return cal;
    }


    private static Date createDate(int year, int month, int day, int hours, int minutes){
        return new Date(year, month-1, day, hours, minutes);
    }

    private static void task5(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();


        System.out.println("--------Task5----------");
        fillListsAndMeasure(arrayList, linkedList, BILLION);
        measureInsertTime(arrayList, linkedList, BILLION);
        measureSearchTime(arrayList, linkedList, BILLION);
        measureDeleteTime(arrayList, linkedList, BILLION);
    }

    private static void fillListsAndMeasure(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, int count){
        System.out.println("========Добавление========");
        System.out.println("---Добавление " + count + " элементов---");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++){
            arrayList.add(i);
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");

        startTime =  System.currentTimeMillis();
        for (int i = 0; i < count; i++){
            linkedList.add(i);
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");
    }

    private static void measureInsertTime(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, int count){
        System.out.println("========Вставка========");
        System.out.println("---Операция вставки в начало---");
        long startTime = System.currentTimeMillis();
        arrayList.add(0, 1);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.add(0,1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция вставки в середину---");
        startTime = System.currentTimeMillis();
        arrayList.add(count/2, 1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.add(count/2,1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция вставки в конец---");
        startTime = System.currentTimeMillis();
        arrayList.add(count-1, 1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.add(count-1,1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");
    }

    private static void measureSearchTime(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, int count) {
        System.out.println("========Нахождение========");
        System.out.println("---Операция нахождения первого элемента");
        long startTime = System.currentTimeMillis();
        arrayList.contains(0);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.contains(0);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция нахождения элемента в середине");
        startTime = System.currentTimeMillis();
        arrayList.contains(count/2);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.contains(count/2);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция нахождения последнего элемента");
        startTime = System.currentTimeMillis();
        arrayList.contains(count-1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.contains(count-1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");
    }


    private static void measureDeleteTime(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, int count){
        System.out.println("========Удаление========");
        System.out.println("---Операция удаления первого элемента");
        long startTime = System.currentTimeMillis();
        arrayList.remove(0);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.remove(0);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция удаления элемента в середине");
        startTime = System.currentTimeMillis();
        arrayList.remove(count/2);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.remove(count/2);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");

        System.out.println("---Операция удаления последнего элемента");
        startTime = System.currentTimeMillis();
        arrayList.remove(count-1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList: " + estimatedTime + "ms");
        startTime = System.currentTimeMillis();
        linkedList.remove(count-1);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList: " + estimatedTime + "ms");
    }
}
