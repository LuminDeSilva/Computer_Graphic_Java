import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class testScaling extends JFrame implements MouseListener{
    Graphics g;
    int x1,y1,x2,y2;

    double []sx={200,300,100};
    double []sy={100,200,200};

    public testScaling(){
        setSize(600,600);
        setTitle("Test Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        g=getGraphics();
        addMouseListener(this);
    }


     public void mouseEntered(MouseEvent m){}
     public void mouseClicked(MouseEvent m){
        g.drawLine((int)(sx[0]),(int)(sy[0]),(int)(sx[1]),(int)(sy[1]));
        g.drawLine((int)(sx[1]),(int)(sy[1]),(int)(sx[2]),(int)(sy[2]));
        g.drawLine((int)(sx[2]),(int)(sy[2]),(int)(sx[0]),(int)(sy[0]));

        Scaling(0.5,0.5);
        g.setColor(Color.RED);
        g.drawLine((int)(sx[0]),(int)(sy[0]),(int)(sx[1]),(int)(sy[1]));
        g.drawLine((int)(sx[1]),(int)(sy[1]),(int)(sx[2]),(int)(sy[2]));
        g.drawLine((int)(sx[2]),(int)(sy[2]),(int)(sx[0]),(int)(sy[0]));

     }
     public void mousePressed(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
    }
     
     public void mouseReleased(MouseEvent m){
        x2=m.getX();
        y2=m.getY();

        
     }
     public void mouseExited(MouseEvent m){}

     public void Translate(int tx, int ty){
        x1=x1+tx;
        y1=y1+ty;

        x2=x2+tx;
        y2=y2+ty;
     }

     public void Scaling(double s, double y){
        for(int i=0; i<3; i++){
            sx[i]=(int)(sx[i]*s);
            sy[i]=(int)(sy[i]*y);
        }
        
     }

    public static void main(String[] args){
        testScaling ob=new testScaling();

        System.out.println("Hi, Students...");
    }
}