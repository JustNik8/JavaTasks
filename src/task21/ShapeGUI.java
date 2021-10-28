package task21;

import task21.shapes.Circle;
import task21.shapes.Oval;
import task21.shapes.Rect;
import task21.shapes.Shape;
import task21.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ShapeGUI extends JFrame {

    private final Random random = new Random();

    public ShapeGUI(){
        super("ShapeGUI");
        this.setBounds(400, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Get main container
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new GridLayout(4, 5));

        JPanel[] panels = new JPanel[20];

        for (int i = 0; i < panels.length; i++) {

            panels[i] = new JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    int width = random.nextInt(60) + 20;
                    int height = random.nextInt(60) + 20;

                    int x = random.nextInt(this.getWidth() - width);
                    int y = random.nextInt(this.getHeight() - height);

                    int figureType = random.nextInt(3);
                    if (figureType == Shape.OVAL){
                        Oval oval = new Oval(x,y,height,width);
                        g.setColor(oval.getColor());
                        g.fillOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());
                    }
                    else if (figureType == Shape.CIRCLE) {
                        Circle circle = new Circle(x,y, width);
                        g.setColor(circle.getColor());
                        g.fillOval(circle.getX(), circle.getY(), circle.getHeight(), circle.getWidth());
                    }
                    else if (figureType == Shape.RECT) {
                        Rect rect = new Rect(x,y,height,width);
                        g.setColor(rect.getColor());
                        g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                    }




                }
            };

            this.add(panels[i]);

        }
    }

}
