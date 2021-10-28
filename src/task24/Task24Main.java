package task24;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Task24Main {

    private static final String filePath = "src\\task24\\text.txt";

    public static void main(String[] args) {

        System.out.println("Программа по добавлению текста в файл!\n");

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    t - добавить запись
                    f - запись заново,
                    c - закрыть программу.""");
            String decision = sc.nextLine();
            boolean appendText;
            if (decision.equals("t")){
                appendText = true;
            }
            else if (decision.equals("f")){
                appendText = false;
            }
            else if (decision.equals("c")){
                break;
            }
            else{
                continue;
            }

            System.out.print("Введите строку: ");
            String text = sc.nextLine();
            try {
                FileWriter fileWriter = new FileWriter(filePath, appendText);
                fileWriter.write(text);
                fileWriter.append('\n');
                fileWriter.flush();

                System.out.println("Запись была произведена");
            } catch (IOException e) {
                System.out.println("Ошибка при открытии файла");
            }
        }

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            for (String line : lines){
                if (!line.equals("\n")){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
