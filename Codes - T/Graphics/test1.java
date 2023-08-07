import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class test1 extends JFrame implements MouseListener{
    Graphics g;
    int x1,x2,y1,y2;
    int x[] = {300,400,200};
    int y[] = {300,500,500};

    test1(){
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);
        addMouseListener(this);
        g=getGraphics();
        getContentPane().setBackground(Color.WHITE);
    }
    public void mouseEntered(MouseEvent m){

    }
    public void mouseExited(MouseEvent m){

    }
    public void mousePressed(MouseEvent m){

    }
    public void mouseReleased(MouseEvent m){

    }
    public void mouseClicked(MouseEvent m){
        x1=m.getX();
        y1=m.getY();
        // translateTriangle(20,0);
        //drawTri(x1,y1);
        //scaleTriangle(0.5,0.5);
        // rotateTri(30.0);
        drawTri(x1,y1);
        translateTriangle(-x1,-y1);
        scaleTriangle(0.5, 5);
        translateTriangle(x1,y1);
        drawTri();
    }
    public void drawTri(){
        g.drawLine(x[0],y[0],x[1],y[1]);
        g.drawLine(x[1],y[1],x[2],y[2]);
        g.drawLine(x[2],y[2],x[0],y[0]);
    }
    public void drawTri(int x1,int y1){
        x[0]=x1;
        x[1]=x1-40;
        x[2]=x1+40;
        y[0]=y1;
        y[1]=y1+60;
        y[2]=y1+60;
        DDAlgo(x[0],y[0],x[1],y[1]);
        DDAlgo(x[1],y[1],x[2],y[2]);
        DDAlgo(x[2],y[2],x[0],y[0]);
    }
    public void translateTriangle(int xt,int yt){
        for(int i=0;i<3;i++){
            x[i]=x[i]+xt;
            y[i]=y[i]+yt;
        }
    }
    public void scaleTriangle(double xs,double ys){
        for(int i=0;i<3;i++){
            x[i]=(int)(x[i]*xs);
            y[i]=(int)(y[i]*ys);
        }
    }
    public void rotateTri(double angle){
        double teta=Math.toRadians(angle);
        int xtemp, ytemp;
        for(int i=0;i<3;i++){
            xtemp=x[i];
            ytemp=y[i];
            x[i]=(int)(xtemp*Math.cos(teta)-ytemp*Math.sin(teta));
            y[i]=(int)(xtemp*Math.sin(teta)+ytemp*Math.cos(teta));
        }
    }
    public void DDAlgo(int x1,int y1,int x2,int y2){
        double dx,dy,x,y,step,yinc,xinc;
        dx=x2-x1;
        dy=y2-y1;
        if(Math.abs(dx)<Math.abs(dy)){
            step=Math.abs(dx);
        }
        else{
            step=Math.abs(dy);
        }
        xinc=dx/step;
        yinc=dy/step;
        x=x1;
        y=y1;
        for(int i=0;i<=step;i++){
            g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
            x+=xinc;
            y+=yinc;
        }
    }
    public static void main(String[] args){
        new test1();
    }
}