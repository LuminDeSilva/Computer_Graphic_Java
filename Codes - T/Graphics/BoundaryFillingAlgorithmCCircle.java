import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BoundaryFillingAlgorithmCCircle extends JFrame implements MouseListener{
	Graphics g;
	int x1,y1,x2,y2,r;
	Color [][]pixels=new Color[600][600];
	
	BoundaryFillingAlgorithmCCircle(){
		setTitle("BoundaryFilling Algorithm");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setBackground(Color.black);
		addMouseListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		g=getGraphics();
	}
	
	public Color getPixel(int x,int y){
		return pixels[x][y];
	}
	public void setPixel(int x,int y,Color c){
		g.setColor(c);
		pixels[x][y]=g.getColor();
		g.drawOval(x,y,1,1);
		
	}
		
	public void midpointCircle(int Xc,int Yc,int r,Color c){
		int x=0, y=r,p=1-r;
		while(x<=y){
			plotCircle(Xc,Yc,x,y,c);
			if(p<0)
				p=p+2*x+3;
			else{
				p=p+2*(x-y)+5;
				y--;
			}
			x++;
		}
	}
	
	public void plotCircle(int h,int k,int x,int y,Color c){
		setPixel(h+x,k+y,c);
		setPixel(h+y,k+x,c);
		setPixel(h-y,k+x,c);
		setPixel(h-x,k+y,c);	
		
		setPixel(h-x,k-y,c);
		setPixel(h-y,k-x,c);
		setPixel(h+y,k-x,c);
		setPixel(h+x,k-y,c);		
	}
	public void mouseClicked(MouseEvent m){}
		
	public void boundaryFill(int x,int y,Color NC,Color BC){
		Color OC=getPixel(x,y);
		if(OC!=NC && OC!=BC){
			setPixel(x,y,NC);
			boundaryFill(x,y-1,NC,BC);
			boundaryFill(x-1,y,NC,BC);
			boundaryFill(x,y+1,NC,BC);
			boundaryFill(x+1,y,NC,BC);
		}
	}
		
	
	public void mousePressed(MouseEvent m){
		x1=m.getX();
		y1=m.getY();
		
	}
	public void mouseReleased(MouseEvent m){
		x2=m.getX();
		y2=m.getY();
		r=(int)Math.sqrt(Math.abs((x1-x2)*(x1-x2)+(y2-y1)*(y2-y1)));
		midpointCircle(x1,y1,r,Color.blue);
		boundaryFill(x1+1,y1+1,Color.red,Color.blue);
	}
	public void mouseEntered(MouseEvent m){}
	public void mouseExited(MouseEvent m){}
	
	public static void main(String... a){
		new BoundaryFillingAlgorithmCCircle();
	}
	
}
