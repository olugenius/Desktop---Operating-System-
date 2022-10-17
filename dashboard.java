import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.geom.*;
import java.io.*;


public class dashboard extends JDialog implements ComponentListener, WindowFocusListener,MouseListener, MouseMotionListener{

JPanel main,bg;
int w = 200;
int h = 260;
int x,y;
int dis = 0;
float trans = 1.0f;
private Image background;
public boolean refreshRequested = true;
private long lastupdate = 0;
JDialog frame;
JTextArea note;
JPanel clk;
JLabel hr,min,sec,dot;
JLabel s26;
JLabel nxt,lft,ad,rem,rep;
Vector library;
FileReader fr;
BufferedReader br;
int pointer = 0;
JLabel msg;

dashboard() {




x = Toolkit.getDefaultToolkit().getScreenSize().width;
y = Toolkit.getDefaultToolkit().getScreenSize().height;


try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e) {}


Container c = getContentPane();
c.setLayout(null);

 updateBackground( ); 


main = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,trans);
g2d.setComposite(cmp);
g2d.setPaint(Color.black);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);
	Point pos = this.getLocationOnScreen( );
	Point offset = new Point(-pos.x,-pos.y);
	g.drawImage(background,offset.x,offset.y,null);

super.paintComponent(g);
}

};
main.setBounds(0,0,w,h);
c.add(main);



note = new JTextArea();
note.setFont(new Font("Tahoma",Font.BOLD,11));
note.setBounds(20,20,161,125);
note.setOpaque(false);
main.add(note);




s26 = new JLabel(new ImageIcon("images/sticky_yellow.png"));
s26.setBounds(5,5,197,177);
main.add(s26);

lft = new JLabel(new ImageIcon("images/bPrev-hot.png"));
lft.setBounds(80,190,16,16);
lft.addMouseListener(this); 
main.add(lft);

nxt = new JLabel(new ImageIcon("images/bNext-hot.png"));
nxt.setBounds(100,190,16,16);
nxt.addMouseListener(this); 
main.add(nxt);



rem = new JLabel(new ImageIcon("images/glyphs_delete_rest.png"));
rem.setBounds(60,190,16,16);
rem.addMouseListener(this); 
main.add(rem);

ad = new JLabel(new ImageIcon("images/glyphs_plus_rest.png"));
ad.setBounds(120,190,16,16);
ad.addMouseListener(this); 
main.add(ad);


rep = new JLabel(new ImageIcon("images/spinner.gif"));
rep.setBounds(10,220,20,20);
rep.addMouseListener(this);
main.add(rep);

msg = new JLabel();
msg.setFont(new Font("Tahoma",Font.BOLD,11));
msg.setForeground(Color.red);
msg.setBounds(40,220,100,20);
main.add(msg);


//main.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
addComponentListener(this); 
addWindowFocusListener(this);
addMouseListener(this); 
addMouseMotionListener(this);




initLibrary();

setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
setLocation(x-(w+50),100);
setSize(w,h);
setUndecorated(true);
setVisible(true);


}






public void initLibrary() {

String info;
library = new Vector();

try {
File file = new File("info.db");

 fr = new FileReader(file);
 br = new BufferedReader(fr);

 while((info = br.readLine()) != null ) {

if( !info.equals("")) {
library.addElement(info);
}

}
}
catch(Exception e) { }

try {
fr.close();
br.close();
}
catch(Exception w) {}

if(!library.elementAt(0).toString().equals("")){
note.setText(library.elementAt(pointer)+"");
}
else {
note.setText("");
}

msg.setText("1 of "+library.size());
repaint();
}












public void saveNote(String nt) {

try {

File fd = new File("info.db");


InputStream in = new BufferedInputStream(new FileInputStream(fd));
byte[] b = new byte[(int)fd.length()];
in.read(b);
in.close();
String data = new String(b);

data = data+"\n"+nt;

OutputStream out = new BufferedOutputStream(new FileOutputStream(fd));
out.write(data.getBytes());
out.close();
}
catch(Exception e){}

initLibrary();

msg.setText("New note saved");
}




public void removeNote(String nt) {

try {

File fd = new File("info.db");


InputStream in = new BufferedInputStream(new FileInputStream(fd));
byte[] b = new byte[(int)fd.length()];
in.read(b);
in.close();
String data = new String(b);

data = data.replaceAll(nt,"");

OutputStream out = new BufferedOutputStream(new FileOutputStream(fd));
out.write(data.getBytes());
out.close();
}
catch(Exception e){}

initLibrary();
msg.setText("Note deleted");
}





public void componentShown(ComponentEvent evt) {repaint( );  }
	public void componentResized(ComponentEvent evt) {  repaint( ); }
	public void componentMoved(ComponentEvent evt) { repaint( );  }
	public void componentHidden(ComponentEvent evt) { }

	public void windowGainedFocus(WindowEvent evt) { }    
	public void windowLostFocus(WindowEvent evt) {}


public void updateBackground( ) {
	try {
		Robot rbt = new Robot( );
		Toolkit tk = Toolkit.getDefaultToolkit( );
		Dimension dim = tk.getScreenSize( );
		background = rbt.createScreenCapture(
		new Rectangle(0,0,(int)dim.getWidth( ),
                          (int)dim.getHeight( )));
	} catch (Exception ex) {
		
	}
}





Point getScreenLocation(MouseEvent e) {
             Point cursor = e.getPoint( );
             Point target_location = main.getLocationOnScreen( );
             return new Point(

                 (int)(target_location.getX( )+cursor.getX( )),
                 (int)(target_location.getY( )+cursor.getY( )));
         }








Point start_drag;
       Point start_loc;



public void mouseClicked(MouseEvent e) {

if(e.getSource() == rep) {

if(e.getClickCount() == 2) {
System.exit(0);
}
else {
setVisible(false);
updateBackground();
msg.setText("Skin updated");
repaint();
setVisible(true);
}

}
else if(e.getSource() == lft) {

if(pointer > 0) {
pointer--;
}
note.setText(library.elementAt(pointer)+"");
msg.setText((pointer+1)+" of "+library.size());
}
else if(e.getSource() == nxt) {

if(pointer < library.size()-1) {
pointer++;
}
note.setText(library.elementAt(pointer)+"");
msg.setText((pointer+1)+" of "+library.size());
}

else if(e.getSource() == ad) {

if(!note.getText().equals("")) {

saveNote(note.getText());

}

}

else if(e.getSource() == rem) {

if(!note.getText().equals("")) {

removeNote(note.getText());

}


}


}





   public void mouseEntered(MouseEvent e) {

if(e.getSource() == lft) {
lft.setIcon(new ImageIcon("images/bPrev-down.png"));
repaint();
}

if(e.getSource() == nxt) {
nxt.setIcon(new ImageIcon("images/bNext-down.png"));
repaint();
}

if(e.getSource() == ad) {
ad.setIcon(new ImageIcon("images/GreenPlus.gif"));
repaint();
}

if(e.getSource() == rem) {
rem.setIcon(new ImageIcon("images/glyphs_delete_hover.png"));
repaint();
}


}
                public void mouseExited(MouseEvent e) {
 
 if(e.getSource() == lft) {
lft.setIcon(new ImageIcon("images/bPrev-hot.png"));
repaint();
}

if(e.getSource() == nxt) {
nxt.setIcon(new ImageIcon("images/bNext-hot.png"));
repaint();
}

if(e.getSource() == ad) {
ad.setIcon(new ImageIcon("images/glyphs_plus_rest.png"));
repaint();
}

if(e.getSource() == rem) {
rem.setIcon(new ImageIcon("images/glyphs_delete_rest.png"));
repaint();
}

}
                public void mousePressed(MouseEvent e) {


 this.start_drag = this.getScreenLocation(e);
           this.start_loc = getLocation( );

}


                public void mouseReleased(MouseEvent e) {}
                public void mouseMoved(MouseEvent e) {}
                public void mouseDragged(MouseEvent e) {


                    Point current = this.getScreenLocation(e);
              Point offset = new Point(
                  (int)current.getX( )-(int)start_drag.getX( ),
                  (int)current.getY( )-(int)start_drag.getY( ));
              JDialog frame = this;
    Point new_location = new Point(
                  (int)(this.start_loc.getX( )+offset.getX( )),
                  (int)(this.start_loc.getY( )+offset.getY( )));

              frame.setLocation(new_location);

                }





public static void main(String[] args) {

dashboard db = new dashboard();

}

}
