package factory.task3.ui;

import factory.task3.createdocument.CreateImageDocument;
import factory.task3.createdocument.CreateMusicDocument;
import factory.task3.createdocument.CreateTextDocument;
import factory.task3.createdocument.ICreateDocument;
import factory.task3.documents.IDocument;
import factory.task3.documents.TextDocument;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppUI extends JFrame {

    private ICreateDocument factory;

    public AppUI(){
        super("Documents");
        this.setBounds(400, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());

        this.setJMenuBar(menuBar);
    }

    private JMenu createFileMenu(){
        JMenu file = new JMenu("File");

        JMenu createFile = new JMenu("New");

        JMenuItem textDocument= new JMenuItem("Text document");
        textDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory = new CreateTextDocument();
                IDocument doc = factory.createNew();
                printDocInfo(doc);
            }
        });

        JMenuItem imageDocument = new JMenuItem("Image Document");
        imageDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory = new CreateImageDocument();
                IDocument doc = factory.createNew();
                printDocInfo(doc);
            }
        });

        JMenuItem musicDocument = new JMenuItem("Music Document");
        musicDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory = new CreateMusicDocument();
                IDocument doc = factory.createNew();
                printDocInfo(doc);
            }
        });

        createFile.add(textDocument);
        createFile.addSeparator();
        createFile.add(imageDocument);
        createFile.addSeparator();
        createFile.add(musicDocument);

        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        file.add(createFile);
        file.addSeparator();
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(exit);

        return file;
    }

    private void printDocInfo(IDocument doc){
        System.out.println(doc.getName() + ", " + doc.getExtension() + ", " + doc.getSize());
    }

}
