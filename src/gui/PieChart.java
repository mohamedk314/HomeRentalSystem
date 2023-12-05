package gui;

import java.awt.*;
import javax.swing.*;
public class PieChart  extends JFrame{
public PieChart()
{
    getContentPane().add(new PieChart1());
}
}
class runChart extends JFrame{
    runChart(){
    PieChart frame = new PieChart ();
     frame.setSize(300,300);
     frame.setTitle("Pie chart");
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
class PieChart1 extends JPanel {
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;
        int radius = ( int )(Math.min(xCenter,yCenter)*0.8);
        int x = xCenter - radius;
        int y =yCenter - radius ;
        g.setColor(Color.red);
        g.fillArc(x, y, 2*radius, 2*radius, 0, (20*360)/100);
        g.setColor(Color.black);
        g.drawString("Waiting -- 20%" , (int) (xCenter+radius*Math.cos(2*Math.PI*0.1)),(int)(yCenter-radius*Math.sin(2*Math.PI*0.1)));
        g.setColor(Color.green);
        g.fillArc(x, y, 2*radius, 2*radius, (int)(20*360/100), (int)(10*360/100));
        g.setColor(Color.black);
        g.drawString("On Hold -- 10%", (int)(xCenter+radius*Math.cos(2*Math.PI*0.25)), (int) (yCenter-radius *Math.sin(2*Math.PI*0.25)));
        g.setColor(Color.cyan);
        g.fillArc(x, y, 2*radius, 2*radius, (int)(30*360/100), (int)(30*360/100));
        g.setColor(Color.black);
        g.drawString("Homes Booked -- 30%", (int)(xCenter+radius*Math.cos(2*Math.PI*0.45))-40, (int) (yCenter-radius *Math.sin(2*Math.PI*0.45)));
        g.setColor(Color.gray);
        g.fillArc(x, y, 2*radius, 2*radius, (int)(60*360/100), (int)(40*360/100));
        g.setColor(Color.black);
        g.drawString("Homes Not Booked -- 40%", (int)(xCenter+radius*Math.cos(2*Math.PI*0.8))-40, (int) (yCenter-radius *Math.sin(2*Math.PI*0.8)));
        
    }
}