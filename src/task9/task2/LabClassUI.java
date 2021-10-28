package task9.task2;

import task6.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LabClassUI extends JFrame {

    private List<Student> students;
    private JLabel studentLabel;

    public LabClassUI(){
        super("Lab Class");
        this.setBounds(400, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initStudents();

        Container container  = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));


        JLabel label = new JLabel("Find student by name");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setFont(defaultFont());

        JTextField textField = new JTextField();
        textField.setMaximumSize(new Dimension(200, textField.getPreferredSize().height));
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findStudent(textField.getText());
                } catch (EmptyStringException emptyStringException) {
                    studentLabel.setText("Enter name");
                } catch (StudentNotFoundException studentNotFoundException){
                    studentLabel.setText("Student not found");
                }
            }
        });

        JButton findStudentButton = new JButton("Find Student");
        findStudentButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        findStudentButton.setFont(defaultFont());
        findStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findStudent(textField.getText());
                } catch (EmptyStringException emptyStringException) {
                    studentLabel.setText("Enter name");
                } catch (StudentNotFoundException studentNotFoundException){
                    studentLabel.setText("Student not found");
                }

            }
        });

        studentLabel = new JLabel();
        studentLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        studentLabel.setFont(defaultFont());


        container.add(label);
        container.add(textField);
        container.add(findStudentButton);
        container.add(studentLabel);
    }

    private Font defaultFont(){
        return new Font("Sans Serif", Font.PLAIN, 20);
    }

    private void initStudents(){
        this.students = LabClassDriver.generateListOfStudents(10);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void findStudent(String name) throws EmptyStringException {

        if (name.isEmpty()){
            throw new EmptyStringException(name + " is empty");
        }

        boolean studentsWasFound = false;

        StringBuilder builder = new StringBuilder();
        for (Student s : students){
            if (s.getName().equals(name)){
                builder.append(s.toString());
                builder.append("\n");
                studentsWasFound = true;
            }
        }

        if (!studentsWasFound){
            throw new StudentNotFoundException("Student not found");
        }

        studentLabel.setText(builder.toString());
    }

}
