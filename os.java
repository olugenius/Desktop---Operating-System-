import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*; 
import java.net.*;


public class os extends JFrame implements ComponentListener, WindowFocusListener, Runnable,MouseListener, MouseMotionListener,ActionListener{

URL surl = null;
JPanel main,bg;
int w = 1000;
int h = 700;
int x,y;
JLabel amor,amor2;
int class_on = 0;
JButton nxt,pvw;
String cur_tree_itm;
Object[][] data;
String in;
JLabel view,view2,view3,view4,view5,view6;
String lg_id = "";
int mv_y =20;
Vector library;
JScrollPane scl;
String cht = "";
JComboBox txt_clr,txt_sz,ico;
FileReader fr;
int genius_in = 0;
File fd;
BufferedReader br;
String info;
int pointer;
JPanel app,txtbk,sbar,gtg,album,pcast,monk,gcast;
JTree friendlist;
JTextField msg;
JList itm;
Vector img_url;
float factor = 1.0f;
JButton go;
int clear;
Color[] clr;
int clr_id = 0;
int dis = 0;
int shut = 0;
Thread mv;
JLabel hmx;
Thread lng,sd;
String click_itm ="";
int next = 0;
URL url;
JTextArea pub_chat_msg;
JLabel title;
JPanel lnk,bookie,frm2,geniusu,load,share,adbook,reco,store;
int x1,x2,y1,y2;
JEditorPane crm;
int fw = 900;
int fh = 600;
Thread t1;
float trans = 0.3f;
int frm_clk = 0;
JTextField user;
JPasswordField pwd;
JLabel roll;
String addr;
JButton login,ldlg;
int resizing = 0;
int px = 100;
int py = 90;
JLabel hm1,hm2,hm3,hm4,hm5,hm6,hm7,hm8,hm9,lbpass;
JLabel icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,lgo;
JTable tbl;
JPanel frm,inm,setngs;
JPanel infrm;
JPanel menu;
String[] column = {"Title","Language","Chapters","Description"};
private Image background;
public boolean refreshRequested = true;
private long lastupdate = 0;
JFrame frame;
int sun = 0;
JTextArea note;
JPasswordField lgpass;
JPanel start,genius_chat;
JLabel hr,min,sec,dot,close2,rept;
JLabel s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26;
JLabel nv1,nv2,nv3,nv4,nv5,nv6,nv7,nv8,nv9,nv10,nv11,nv12,nv13,nv14,nv15,nv16,nv17,nv18,nv19,nv20,nv21,nv22,nv23,nv24,nv25,nv26,nv27,nv28,nv29,nv30;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
JLabel close,disable,rez,srt,lgo2,lgo3,lgo4,lgo5,lgo6,rollbl;
JTree tree;
DefaultMutableTreeNode top,category,book,online,friend,frd;
Container c;


String language[] = {"Programming","Web Development","Database","CLAIT","Graphics","Engineering/Networking"};
String sub_prog[] = {"Java","C","C++","C#","Visual Basic 6.0","Visual Basic .NET","XML"};
String sub_web[] = {"HTML","DHTML","JavaScript","CSS","PHP","Joomla","Adobe Flex","SQL","Adobe Dreamweaver MX","Adobe Flash","Perl","CGI","Ajax","ASP.NET","ActionScript","Servlet","RMI","JSP","JSF","EJB","Coldfusion","Apache","Web 2.0","Jakarta Strut","Silverlight"};
String sub_db[] = {"Oracle 10g","SQL","PL/SQL","MySQL","Microsoft Access","Microsoft SQL Server","XML Database",};
String sub_clait[] = {"Using Internet","Windows XP","Windows Vista","Using Linux","Using Mac","Computer Fundamentals","Microsoft Word","Microsoft Excel","Microsoft Access","Microsoft Powerpoint"};
String sub_gfx[] = {"CorelDraw","Adobe Photoshop","Corel Paint","Toon Boon Studio","3D Studio Max","AutoCAD","Adobe Firework"};
String sub_engnet[] = {"MSCE","MCSP","MCSA","MCSD","CCNA","CCNP","CEH","RCHE"};

os() {


clr = new Color[26];



clr[0] = Color.black;
clr[1] = Color.orange;
clr[2] = new Color(116,150,26);
clr[3] = new Color(11,160,16);
clr[4] = new Color(67,40,121);
clr[5] = new Color(188,85,99);
clr[6] = new Color(118,145,199);
clr[7] = new Color(10,113,212);
clr[8] = new Color(12,88,149);
clr[9] = new Color(240,225,5);
clr[10] = new Color(240,10,10);
clr[11] = new Color(121,100,156);
clr[12] = new Color(45,12,234);
clr[13] = new Color(22,218,3);
clr[14] = new Color(34,89,123);
clr[15] = new Color(10,19,12);
clr[16] = new Color(34,189,123);
clr[17] = new Color(34,89,223);
clr[18] = new Color(200,0,0);
clr[19] = new Color(0,200,0);
clr[20] = new Color(3,90,0);
clr[21] = new Color(66,66,66);
clr[22] = new Color(100,100,100);
clr[23] = new Color(89,123,11);
clr[24] = new Color(210,210,210);
clr[25] = new Color(134,189,123);





category = null;
book = null;



changeGUI();
initScreenSize();
getSetting(); 
updateBackground(); 


initializeLibrary("bookie.lib","null");



c = getContentPane();
c.setLayout(null);
c.setBackground(Color.black);






initMainPanel();





amor = new JLabel(new ImageIcon("images/01.png"));
amor.setBounds(-20,80,2710,683);
//main.add(amor);



rez = new JLabel(new ImageIcon("images/glyphs_plus_rest.png"));
rez.setToolTipText("Resize skin.");
rez.setBounds(w-16,h-16,16,16);
rez.addMouseListener(this);
rez.addMouseMotionListener(this);
main.add(rez);












initFrmPanel();










initInfrmPanel();






String cdr = getDir();
addr = "<html>";
addr += "<body background='file:/" + cdr + "/images/bg.png' topmargin='0' leftmargin='0'>";
addr += "<br><br>";
addr += "<center><img src='file:/" + cdr +"/images/ss.png'></center>";
addr += "</body>";
addr += "</html>";





loadBrowser(addr);











initBookiePanel();




initClassButton();






initTree();





initGeniusU();






initGeniusChat();



initAppPanel();


initToGoPanel();


initSidebarPanel();


initTXTBookPanel();


initAlbumPanel();


initPodcastPanel();


initMonkPanel();


initGcastPanel();


initFriendsList();


setPublicChat();





title = new JLabel("");
title.setForeground(Color.white);
title.setFont(new Font("verdana",Font.BOLD,10));
title.setBounds(4,-8,400,40);
frm.add(title);





















initMenu();










initInm();







nv2 = new JLabel("Library");
nv2.setForeground(Color.LIGHT_GRAY);
nv2.setFont(new Font("tahoma",Font.BOLD,11));
nv2.addMouseListener(this);
nv2.setBounds(130,50,80,20);

nv4 = new JLabel("Marketplace");
nv4.setForeground(Color.LIGHT_GRAY);
nv4.setFont(new Font("tahoma",Font.BOLD,11));
nv4.addMouseListener(this);
nv4.setBounds(200,50,120,20);

nv6 = new JLabel("Media");
nv6.setForeground(Color.LIGHT_GRAY);
nv6.setFont(new Font("tahoma",Font.BOLD,11));
nv6.addMouseListener(this);
nv6.setBounds(300,50,70,20);


nv8 = new JLabel("Gadgets");
nv8.setForeground(Color.LIGHT_GRAY);
nv8.setFont(new Font("tahoma",Font.BOLD,11));
nv8.addMouseListener(this);
nv8.setBounds(360,50,100,20);

nv10 = new JLabel("Settings");
nv10.setForeground(Color.LIGHT_GRAY);
nv10.setFont(new Font("tahoma",Font.BOLD,11));
nv10.addMouseListener(this);
nv10.setBounds(430,50,90,20);













lnk = new JPanel(null);
lnk.setBounds(18,60,170,250);
lnk.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
lnk.setBackground(Color.white);










s1 = new JLabel(new ImageIcon("images/undocked_moon-first-quarter.png"));
s1.setBounds(-10,-10,264,194);
main.add(s1);

s2 = new JLabel(new ImageIcon("images/rssBackBlue_docked.png"));
s2.setBounds(w-140,50,130,173);

s3 = new JLabel(new ImageIcon("images/sticky_yellow_docked.png"));
s3.setBounds(w-140,230,130,121);

s4 = new JLabel(new ImageIcon("images/calendar_single_orange.png"));
s4.setBounds(w-140,353,130,141);

s5 = new JLabel(new ImageIcon("images/flashingstar.gif"));
s5.setBounds(0,0,25,25);
s5.setOpaque(false);
main.add(s5);

disable = new JLabel(new ImageIcon("images/stocks_docked_row_background_down.png"));
disable .setBounds(720,1,123,33);
disable.addMouseListener(this);
main.add(disable);

close = new JLabel(new ImageIcon("images/glyphs_delete_rest.png"));
close.setBounds(w-20,4,16,16);
close.addMouseListener(this);
main.add(close);


close2 = new JLabel(new ImageIcon("images/glyphs_delete_rest.png"));
close2.setBounds(fw-20,7,16,16);
close2.addMouseListener(this);
frm.add(close2);

s21 = new JLabel(new ImageIcon("images/docked_partly-cloudy.png"));
s21.setBounds(200,0,130,67);

s22 = new JLabel(new ImageIcon("images/docked_cloudy.png"));
s22.setBounds(300,5,130,67);

s23 = new JLabel(new ImageIcon("images/docked_partly-cloudy.png"));
s23.setBounds(460,-10,130,67);

s24 = new JLabel(new ImageIcon("images/docked_partly-cloudy.png"));
s24.setBounds(580,12,130,67);

s26 = new JLabel(new ImageIcon("images/docked_partly-cloudy.png"));
s26.setBounds(470,6,130,67);

s25 = new JLabel(new ImageIcon("images/docked_cloudy.png"));
s25.setBounds(100,10,130,67);

main.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
addComponentListener(this); 
addWindowFocusListener(this);
addMouseListener(this); 
addMouseMotionListener(this);














initLoad();











rollbl = new JLabel("Loading...");
rollbl.setForeground(Color.LIGHT_GRAY);
rollbl.setFont(new Font("tahoma",Font.BOLD,11));
rollbl.setBounds((w/2)-20,(h/2)+7,100,20);















setngs = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(100,180,80));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
setngs.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
setngs.setBackground(Color.black);














adbook = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(130,200,40));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
adbook.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
adbook.setBackground(Color.black);




















share = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(200,80,140));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
share.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
share.setBackground(Color.black);












reco = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(100,110,111));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
reco.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
reco.setBackground(Color.black);












store = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(150,40,171));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
store.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
store.setBackground(Color.black);

















setTableReady();











logToGenius();




addWindowListener(ws);











new Thread(this).start( );
this.frame = this;

setLocation((x/2)-(w/2),(y/2)-(h/2));
setSize(w,h);
setTitle("Genius");
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
setUndecorated(true);
setVisible(true);

}














WindowListener ws = new WindowAdapter() {

public void windowClosing(WindowEvent e) {

shutDown();
}

};











 class LibrarySelection implements TreeSelectionListener {
public void valueChanged(TreeSelectionEvent e) {
      TreePath path = e.getPath();
      Object[] nodes = path.getPath();
      for (int k=0; k<nodes.length; k++) {
        DefaultMutableTreeNode node =  (DefaultMutableTreeNode)nodes[k];
       String itm = (String) node.getUserObject();

if(itm.indexOf("Programming") < 0 && itm.indexOf("Library") < 0 && itm.indexOf("Web Development") < 0 && itm.indexOf("Database") < 0 && itm.indexOf("CLAIT") < 0 && itm.indexOf("Graphics") < 0 && itm.indexOf("Engineering/Networking") < 0 ) {

cur_tree_itm = itm;
initializeLibrary("bookie.lib",cur_tree_itm);
repaint();
}
else if(itm.indexOf("Library") != -1) {
initializeLibraryAll("bookie.lib");
repaint();
}

      }

    }
}















public void actionPerformed(ActionEvent e) {

if(e.getSource() == go) {

pub_chat_msg.append(lg_id+": "+msg.getText()+"\n");
msg.setText("");

}
else if(e.getSource() == login) {

if(user.getText().equals("kay2care") && pwd.getText().equals("genie") ) {
lg_id= user.getText();
title.setText("Welcome "+user.getText());
genius_in = 1;
genius_chat.add(lgo);
genius_chat.add(lgo2);
openFrame(w/2-375,(h/2)-280,750,560,genius_chat,"Genius U - Welcome.");
repaint();
}
else {
title.setText("Invalid login. Try again");
}


}
else if(e.getSource() == ldlg) {

if(lgpass.getText().equals("kay2care")) {

initApplication();

}
else {
title.setForeground(Color.red);
title.setText("Invalid Login");
lgpass.setText("");
//JOptionPane.showMessageDialog(this,"Invalid password. Try again.","Genius Logon.",JOptionPane.INFORMATION_MESSAGE);
}
}


}










public void initApplication() {

title.setForeground(Color.white);
title.setText("Welcome");
roll.setBounds((w/2)-8,(h/2)-8,16,16);
rollbl.setBounds((w/2)-20,(h/2)+7,100,20);
main.add(roll);
main.add(rollbl);
handleSettings();
repaint();


}







public void logToGenius() {

openFrame((w/2)-125,(h/2)-120,250,150,load,"Genius Logon.");

}








public void startThread() {



t1 = new Thread() {
public void run() {

while(true) {
try {
sleep(5000);
sun++;
if(sun % 2 == 0) {
s1.setIcon(new ImageIcon("images/undocked_moon-first-quarter.png"));
showEffect();
}
else {
s1.setIcon(new ImageIcon("images/undocked_sun.png"));
hideEffect();
}
}
catch(Exception e) {}
}
}


};
t1.start();

}



















public void handleSettings() {



lng = new Thread() {
public void run() {

while(true) {
try {
sleep(1000);
next++;

if(next == 2) {

closeFrame();
repaint();

}
else if(next == 4) {

addLinks();
repaint();

}
else if(next == 6) {

showCloud();
repaint();

}
else if(next == 8) {

showSideBar();
repaint();

}
else if(next == 10) {

main.add(menu);
trans = .6f;
repaint();
startThread();

}
else if(next == 12) {

roll.hide();
rollbl.hide();
repaint();
stop();
lng = null;

}

}
catch(Exception e) {}
}
}


};
lng.start();

}

















public void shutDown() {


sd = new Thread() {
public void run() {

while(true) {
try {
sleep(1000);
shut++;

if(shut == 1) {

closeFrame();
repaint();

}
else if(shut == 4) {

main.removeAll();
trans = .3f;
repaint();

}
else if(shut == 6) {

main.add(roll);
main.add(rollbl);
roll.setBounds((w/2)-8,(h/2)-8,16,16);
rollbl.setBounds((w/2)-36,(h/2)+7,100,20);
rollbl.setText("Shuttng down.");
roll.show();
rollbl.show();
repaint();

}
else if(shut == 13) {

rollbl.setText("Saving settings.");
saveSettings();
repaint();
}
else if(shut == 20) {

System.exit(0);

}

}
catch(Exception e) {}
}
}


};
sd.start();

}






public void componentShown(ComponentEvent evt) {repaint( );  }
	public void componentResized(ComponentEvent evt) {  repaint( ); }
	public void componentMoved(ComponentEvent evt) { repaint( );  }
	public void componentHidden(ComponentEvent evt) { }

	public void windowGainedFocus(WindowEvent evt) { refresh( ); }    
	public void windowLostFocus(WindowEvent evt) { }


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









public void refresh( ) {


	if(frame.isVisible( )) {
		repaint( );
		refreshRequested = true;
		lastupdate = new Date( ).getTime( );
	}
	

}
public void run( ) {


	try {
		while(true) {
			Thread.sleep(1);
			long now = new Date( ).getTime( );
			if(refreshRequested &&
				((now - lastupdate) > 10000)) {
				if(frame.isVisible( )) {
                    Point location = frame.getLocation( );
                   frame.hide( );
                    updateBackground( );
                    frame.show( );
				frame.setLocation(location);
                    refresh( );
				}
				lastupdate = now;
				refreshRequested = false;
				}
			}
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


if(e.getSource() == nv2) {
openFrame((w/2)-350,(h/2)-250,700,500,gtg,"Genius To Go - Learn more about what Genius have for you.");
}

else if(e.getSource() == nv4) {
openLibrary((w/2)-450,(h/2)-300,900,600,bookie,tbl,"Genius Library.");
}

else if(e.getSource() == nv6) {
if(genius_in == 0) {
openFrame(w/2-125,(h/2)-280,250,560,geniusu,"Genius U - Connecting You.");
}
else {
openFrame(w/2-375,(h/2)-280,750,560,genius_chat,"Genius U - Welcome.");
}
}

else if(e.getSource() == nv8) {
openFrame(100,60,w-200,h-120,store,"Connecting to Genius Store.");
}

else if(e.getSource() == nv10) {
openFrame((w/2)-300,(h/2)-200,600,400,monk,"Monk - Your Digital Video Makers.");

}

/*
else if(click_itm.indexOf("Application") != -1) {
openFrame((w/2)-300,(h/2)-250,600,500,app,"Genius Applications - Application for Genius users.");

}

else if(click_itm.indexOf("TXTBook") != -1) {
openFrame((w/2)-350,(h/2)-250,700,500,txtbk,"TXTBook - Your Text vault.");

}

else if(click_itm.indexOf("Sidebar") != -1) {
openFrame((w/2)-300,(h/2)-250,600,500,sbar,"Sidebar - Configure your Sidebar.");

}
else if(click_itm.indexOf("To Go") != -1) {
openFrame((w/2)-(fw/2),(h/2)-(fh/2),fw,fh,infrm,"Now Learning...");
}

else if(click_itm.indexOf("Album") != -1) {
openFrame((w/2)-350,(h/2)-250,800,500,album,"Album - Your Digital Gallery.");

}

else if(click_itm.indexOf("Podcast") != -1) {
openFrame((w/2)-350,(h/2)-200,700,300,pcast,"Podcast - Connecting you to the world of interactive and educative podcasts.");

}
else if(click_itm.indexOf("GeniusCast") != -1) {
openFrame((w/2)-380,(h/2)-240,760,480,gcast,"GeniusCast - We help you to connect and share with people in your life.");

}

else if(click_itm.indexOf("Settings") != -1) {
openFrame(w/2-275,(h/2)-250,550,500,setngs,"Settings.");
}

else if(click_itm.indexOf("Share") != -1) {
openFrame(w/2-370,(h/2)-180,740,360,share,"Share Man - The more you share, the more you discover.");
}

else if(click_itm.indexOf("Contact") != -1) {
openFrame(w/2-350,(h/2)-280,700,560,adbook,"Contacts - Backup your contacts.");
}

else if(click_itm.indexOf("Recom") != -1) {
openFrame((w/2)-150,(h/2)-290,300,580,reco,"Recommended - Bookie you might need.");
}
*/

else if(e.getSource() == close2) {

closeFrame();

}


else  if(e.getSource() == disable) {

if(dis == 0) {
trans = 0.7f;
dis = 1;
disable.setIcon(new ImageIcon("images/stocks_docked_row_background_up.png"));
repaint();
}
else if(dis == 1) {

if(clr_id == clr.length-1) {
clr_id = 0;
}
else {
clr_id++;
}

trans = .3f;
dis = 0;
disable.setIcon(new ImageIcon("images/stocks_docked_row_background_down.png"));
repaint();
}

}
else if(e.getSource() == close) {

shutDown();


}
}












   public void mouseEntered(MouseEvent e) {

 if(e.getSource() == close) {

close.setIcon(new ImageIcon("images/glyphs_delete_hover.png"));
repaint();

}
else if(e.getSource() == close2) {

close2.setIcon(new ImageIcon("images/glyphs_delete_hover.png"));
repaint();

}

}












                public void mouseExited(MouseEvent e) {
 if(e.getSource() == close ) {

close.setIcon(new ImageIcon("images/glyphs_delete_rest.png"));
repaint();

}
else if(e.getSource() == close2) {

close2.setIcon(new ImageIcon("images/glyphs_delete_rest.png"));
repaint();

}

}












                public void mousePressed(MouseEvent e) {

 if(e.getSource() == rez) {

resizing = 1;
Point sz = this.getScreenLocation(e);
x1 =  (int)sz.getX( );
y1 =  (int)sz.getY( );

}


 this.start_drag = this.getScreenLocation(e);
           this.start_loc = getLocation( );

}












                public void mouseReleased(MouseEvent e) {
 

if(e.getSource() == rez) {

resizing = 0;
}

}








                public void mouseMoved(MouseEvent e) {


	s5.setBounds(e.getX()-12,e.getY()-11,25,25);
	repaint();

}
                public void mouseDragged(MouseEvent e) {
	


		if(resizing == 1) {
		Point sz2 = this.getScreenLocation(e);
		x2 =  (int)sz2.getX( );
		y2 =  (int)sz2.getY( );
		int  nx = x2 - x1;
		int ny = y2 - y1;
		w += nx;
		h += ny;
		s4.setBounds(w-155,344,155,155);
		s3.setBounds(w-140,230,130,121);
		s2.setBounds(w-140,50,130,173);
		rez.setBounds(w-16,h-16,16,16);
		close.setBounds(w-20,7,16,16);
		amor.setBounds(0,80,2710,683);
		main.setBounds(0,0,w,h);
		setSize(w,h);
		repaint();
		}

		if(e.getSource() == main) {
                    Point current = this.getScreenLocation(e);
              Point offset = new Point(
                  (int)current.getX( )-(int)start_drag.getX( ),
                  (int)current.getY( )-(int)start_drag.getY( ));
              JFrame frame = this;
    Point new_location = new Point(
                  (int)(this.start_loc.getX( )+offset.getX( )),
                  (int)(this.start_loc.getY( )+offset.getY( )));

              frame.setLocation(new_location);
				}
                }















/***************************************
*SHOW SIDEBAR
****************************************/

public void showCloud() {

main.add(s21);
main.add(s22);
main.add(s23);
main.add(s24);
main.add(s25);
main.add(s26);
repaint();

}





public void showSideBar() {

main.add(s2);
main.add(s3);
main.add(s4);
repaint();

}











public void changeGUI() {

try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e) {}

}





/***************************************
*GET SCREEN SIZE
****************************************/

public void initScreenSize() {

x = Toolkit.getDefaultToolkit().getScreenSize().width;
y = Toolkit.getDefaultToolkit().getScreenSize().height;

}
















public void openLibrary(int x,int y,int w,int h,JPanel chld,JTable tbl,String tit) {


frm.hide();
frm.removeAll();

JScrollPane scl = new JScrollPane(tbl);

scl.setBounds(210,20,w-215,h-50);
frm.add(scl);
frm.add(close2);

frm.add(title);
title.setText(tit);
frm.setBounds(x,y,w,h);
close2.setBounds(w-20,4,16,16);
chld.setBounds(5,20,200,h-50);
frm.add(chld);
repaint();
frm.show();
repaint();

}


















public void openFrame(int x,int y,int w,int h,JPanel chld,String tit) {


frm.hide();
frm.removeAll();
frm.add(title);
title.setText(tit);
frm.setBounds(x,y,w,h);
close2.setBounds(w-20,4,16,16);
chld.setBounds(5,20,w-10,h-50);

if(tit.indexOf("Now Learning")!=-1) {
nxt.setBounds(480,h-23,80,20);
pvw.setBounds(395,h-23,80,20);
}

frm.add(chld);
frm.add(close2);
frm.add(nxt);
frm.add(pvw);
frm.show();
repaint();

}










public void closeFrame() {

frm.hide();
repaint();

}










public void showEffect() {

s21.setVisible(true);
s22.setVisible(true);
s23.setVisible(true);
s24.setVisible(true);
s25.setVisible(true);
s26.setVisible(true);
repaint();

}









public void hideEffect() {

s21.setVisible(false);
s22.setVisible(false);
s23.setVisible(false);
s24.setVisible(false);
s25.setVisible(false);
s26.setVisible(false);
repaint();

}


















public String decryptBookie(String html) {

encryptor en = new encryptor();

return en.doDecryption(html);


}



public void initializeLibrary(String ua,String find) {

library = new Vector();

try {
File file = new File(ua);

fr = new FileReader(file);
br = new BufferedReader(fr);

while((info = br.readLine()) != null ) {

if( !info.equals("")) {
//info = decryptBookie(info);

if(info.indexOf("[lang]"+find+"[") != -1) {
library.addElement(info);
}

}

}
}
catch(Exception e) { }

try {
fr.close();
br.close();
}
catch(Exception w) {}

clear = 1;

data = new Object[library.size()+60][5];


for(int k=0;k<data.length;k++) {


if(k < library.size()) {

in = (String)library.elementAt(k);

data[k][0] = in.substring( in.indexOf("[title]")+7,in.indexOf("[desc]") );
data[k][1] =in.substring(in.indexOf("[lang]")+6,in.indexOf("[chap]") ) ;
data[k][2] =in.substring( in.indexOf("[chap]")+6,in.indexOf("[enable]") ) ;
data[k][3] =in.substring( in.indexOf("[desc]")+6,in.indexOf("[lang]") );
data[k][4] =in.substring( in.indexOf("[url]")+5,in.indexOf("[end]") );
}
else {

data[k][0] ="";
data[k][1] ="";
data[k][2] ="";
data[k][3] ="";
data[k][4] = "";
}

}

repaint();
}














public void initializeLibraryAll(String ua) {

library = new Vector();

try {
File file = new File(ua);

fr = new FileReader(file);
br = new BufferedReader(fr);

while((info = br.readLine()) != null ) {

if( !info.equals("")) {
//info = decryptBookie(info);

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

clear = 1;

data = new Object[library.size()+60][5];


for(int k=0;k<data.length;k++) {


if(k < library.size()) {

in = (String)library.elementAt(k);

data[k][0] = in.substring( in.indexOf("[title]")+7,in.indexOf("[desc]") );
data[k][1] =in.substring(in.indexOf("[lang]")+6,in.indexOf("[chap]") ) ;
data[k][2] =in.substring( in.indexOf("[chap]")+6,in.indexOf("[enable]") ) ;
data[k][3] =in.substring( in.indexOf("[desc]")+6,in.indexOf("[lang]") );
data[k][4] =in.substring( in.indexOf("[url]")+5,in.indexOf("[end]") );
}
else {

data[k][0] ="";
data[k][1] ="";
data[k][2] ="";
data[k][3] ="";
data[k][4] = "";
}

}

repaint();
}










public String getDir() {

String dr = "";

File dir = new File(".");
String path = dir.getAbsolutePath();

try{
URL url = new URL("file:/"+path);
String url2 = url.toString();
dr = url2.substring(6,url2.length()-2);
}
catch(Exception n) {}

return dr;
}











public void loadBrowser(String adr) {


try {
crm = new JEditorPane("text/html",adr);
crm.setEditable(false);
JScrollPane scrm = new JScrollPane(crm);
crm.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
scrm.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
infrm.add(scrm,BorderLayout.CENTER);
}
catch(Exception s) {
}


}


















public void setTableReady() {




TableModel model = new AbstractTableModel() {


public int getColumnCount() {
return column.length;
}

public int getRowCount() {
return data.length;
}

public Object getValueAt(int row, int col) {
return data[row][col];
}

public String getColumnName(int columnx) {
return column[columnx];
}

  public Class getColumnClass(int c) {
return getValueAt(0, c).getClass();
}

 public boolean isCellEditable(int row, int col) {
return false;
}

  public void setValueAt(Object aValue, int row, int columnx) {
                data[row][columnx] = aValue;
fireTableCellUpdated(row,columnx);
            }
};





tbl = new JTable(model){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.2f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(34,189,211));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

	Point pos = tbl.getLocationOnScreen( );
	Point offset = new Point(-pos.x,-pos.y);
	g.drawImage(background,offset.x,offset.y,null);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
tbl.setGridColor(Color.white);
tbl.setShowVerticalLines(false); 
tbl.setShowHorizontalLines(false); 
tbl.setColumnSelectionAllowed(false); 
tbl.setRowSelectionAllowed(true);
tbl.setRowHeight(17);
tbl.setTableHeader(null);
tbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
tbl.setIntercellSpacing(new Dimension(0,0));
tbl.addMouseListener(this);



DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
 public void setValue(Object value) {
	        int cellValue = (value instanceof Number) ? ((Number)value).intValue() : 0;
	        setForeground(Color.black);
		setFont(new Font("verdana",Font.BOLD,11));
		setToolTipText("Genius Library");
	        setText((value == null) ? "" : value.toString());
setOpaque(false);
setVerticalAlignment(JLabel.TOP);
setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	    }

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {


if(isSelected) {

setText((value == null) ? "" : value.toString());
setForeground(Color.white);
setFont(new Font("Tahoma",Font.BOLD,11));
setOpaque(true);
setBackground(Color.DARK_GRAY);
pointer = row;
}
else {

setText((value == null) ? "" : value.toString());
setOpaque(false);
setFont(new Font("tahoma",Font.PLAIN,11));
setForeground(Color.DARK_GRAY);

}

return this;

}




};
        

TableColumn  pid = tbl.getColumn("Title");

pid.setCellRenderer(renderer);
        pid.setPreferredWidth(400);

TableColumn  pn = tbl.getColumn("Language");
pn.setCellRenderer(renderer);
        pn.setPreferredWidth(150);

TableColumn  prc = tbl.getColumn("Chapters");
prc.setCellRenderer(renderer);
        prc.setPreferredWidth(150);

TableColumn  qty = tbl.getColumn("Description");
qty.setCellRenderer(renderer);
        qty.setPreferredWidth(480);

}











public void addLinks() {


main.add(nv2);
main.add(nv4);
main.add(nv6);
main.add(nv8);
main.add(nv10);
//main.add(nv12);
//main.add(nv14);
//main.add(nv16);



}


















public void initMainPanel() {

main = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,trans);
g2d.setComposite(cmp);
g2d.setPaint(clr[clr_id]);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);
Point pos = this.getLocationOnScreen( );
Point offset = new Point(-pos.x,-pos.y);
	g.drawImage(background,offset.x,offset.y,null);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
super.paintComponent(g);
}

};
main.setBounds(0,0,w,h);
main.addMouseListener(this);
main.addMouseMotionListener(this);
c.add(main);

}


















public void initFrmPanel() {


frm = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(Color.DARK_GRAY);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

	Point pos = frm.getLocationOnScreen( );
	Point offset = new Point(-pos.x,-pos.y);
	g.drawImage(background,offset.x,offset.y,null);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
frm.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
frm.addMouseListener(this);
frm.addMouseMotionListener(this);
main.add(frm);
frm.hide();

}









public void initAppPanel() {


app = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(126,199,10));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
app.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}








public void initSidebarPanel() {


sbar = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(10,200,10));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
sbar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}



public void initToGoPanel() {


gtg = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(6,100,100));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
gtg.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}








public void initTXTBookPanel() {


txtbk = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(200,100,10));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
txtbk.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}










public void initAlbumPanel() {


album = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(70,90,190));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.9f));

super.paintComponent(g);
}

};
album.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}










public void initPodcastPanel() {


pcast = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(111,199,80));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);
g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
pcast.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}








public void initMonkPanel() {


monk = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(200,20,200));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
monk.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}










public void initGcastPanel() {


gcast = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(160,188,90));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
gcast.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}











public void initInfrmPanel() {


infrm = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f);
g2d.setComposite(cmp);
g2d.setPaint(Color.black);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
infrm.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
infrm.setBackground(Color.black);



}











public void initBookiePanel() {




bookie = new JPanel(new BorderLayout()){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(200,200,130));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
bookie.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}







public void initTree() {




 top = new DefaultMutableTreeNode("Library");

for(int i=0;i<language.length;i++){

category = new DefaultMutableTreeNode(language[i]);
top.add(category);

if(language[i].equals("Programming")) {

for(int j=0;j<sub_prog.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_prog[j]));
}

}
else if(language[i].equals("Web Development")) {

for(int j=0;j<sub_web.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_web[j]));
}

}
else if(language[i].equals("Database")) {

for(int j=0;j<sub_db.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_db[j]));
}

}
else if(language[i].equals("CLAIT")) {

for(int j=0;j<sub_clait.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_clait[j]));
}

}
else if(language[i].equals("Graphics")) {

for(int j=0;j<sub_gfx.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_gfx[j]));
}

}
else if(language[i].equals("Engineering/Networking")) {

for(int j=0;j<sub_engnet.length;j++) {
category.add(book = new DefaultMutableTreeNode(sub_engnet[j]));
}

}
}












tree = new JTree(top){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(200,50,230));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

	Point pos = tree.getLocationOnScreen( );
	Point offset = new Point(-pos.x,-pos.y);
	g.drawImage(background,offset.x,offset.y,null);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
tree.setDragEnabled(true);
tree.setToggleClickCount(0);
tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
bookie.add(new JScrollPane(tree),BorderLayout.CENTER);
tree.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
tree.addTreeSelectionListener(new LibrarySelection());

DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    renderer.setOpenIcon(new ImageIcon("images/ico_alpha_Replace_16x16.png"));
    renderer.setClosedIcon(new ImageIcon("images/ico_alpha_Refresh_16x16.png"));
    renderer.setLeafIcon(new ImageIcon("images/ico_alpha_home_16x16.png"));
   renderer.setFont(new Font("tahoma",Font.BOLD,11));
   renderer.setForeground(Color.DARK_GRAY);
   renderer.setBackground(new Color(200,50,230));
   renderer.setOpaque(false);
   tree.setCellRenderer(renderer);


}


















public void initGeniusU() {




geniusu = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.6f);
g2d.setComposite(cmp);
g2d.setPaint(Color.orange);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
geniusu.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
geniusu.setBackground(Color.orange);



lgo = new JLabel("Genius U");
lgo.setForeground(Color.DARK_GRAY);
lgo.setFont(new Font("Georgia",Font.PLAIN,27));
lgo.setBounds(15,15,400,40);
geniusu.add(lgo);


lgo2 = new JLabel("Connecting you.");
lgo2.setForeground(Color.DARK_GRAY);
lgo2.setFont(new Font("tahoma",Font.PLAIN,12));
lgo2.setBounds(53,34,400,40);
geniusu.add(lgo2);


lgo3 = new JLabel("Username:");
lgo3.setForeground(Color.DARK_GRAY);
lgo3.setFont(new Font("tahoma",Font.PLAIN,11));
lgo3.setBounds(40,134,200,30);
geniusu.add(lgo3);

user = new JTextField();
user.setForeground(Color.DARK_GRAY);
user.setFont(new Font("tahoma",Font.PLAIN,11));
user.setBounds(40,156,160,20);
geniusu.add(user);

lgo4 = new JLabel("Password:");
lgo4.setForeground(Color.DARK_GRAY);
lgo4.setFont(new Font("tahoma",Font.PLAIN,11));
lgo4.setBounds(40,174,200,30);
geniusu.add(lgo4);


pwd = new JPasswordField();
pwd.setForeground(Color.DARK_GRAY);
pwd.setFont(new Font("tahoma",Font.PLAIN,11));
pwd.setBounds(40,196,160,20);
geniusu.add(pwd);

login = new JButton("Connect");
login.setForeground(Color.DARK_GRAY);
login.setFont(new Font("tahoma",Font.PLAIN,11));
login.setBounds(70,221,100,20);
login.addActionListener(this);
geniusu.add(login);

s10 = new JLabel(new ImageIcon("images/25.png"));
s10.setBounds(180,470,43,34);
geniusu.add(s10);


}

















public void initGeniusChat() {




genius_chat = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.6f);
g2d.setComposite(cmp);
g2d.setPaint(Color.orange);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
genius_chat.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
genius_chat.setBackground(new Color(123,180,56));


}








public void initMenu() {



menu = new JPanel(null) {
Image image = new ImageIcon("images/stocks_undocked_1_1_5.png").getImage();

{setOpaque(false);}

public void paintComponent(Graphics g) {

int w=0,h=0;

g.drawImage(image,w,h,this);

super.paintComponent(g);
}

};
menu.setBounds(-6,h-379,323,369);
menu.addMouseListener(this);
menu.setVisible(false);



}





















public void initInm() {



img_url = new Vector();



itm = new JList();

DefaultListModel mod = new DefaultListModel();
itm.setModel(mod);

mod.addElement("Digital Library");
img_url.addElement("images/help.png");
mod.addElement("Bookie");
img_url.addElement("images/ico_alpha_MissingTypeLib_32x32.png");
mod.addElement("TXTBook");
img_url.addElement("images/ico_alpha_Folder_32x32.png");
mod.addElement("Contacts");
img_url.addElement("images/ico_alpha_Help_32x32.png");
mod.addElement("Application");
img_url.addElement("images/ico_alpha_Software_32x32.png");
mod.addElement("Genius Sidebar");
img_url.addElement("images/ico_alpha_QOS_32x32.png");
mod.addElement("ShareMan");
img_url.addElement("images/ico_alpha_Undo_32x32.png");
mod.addElement("Recommeded");
img_url.addElement("images/ico_alpha_CompSpeak_32x32.png");
mod.addElement("Monk");
img_url.addElement("images/ico_alpha_Input_32x32.png");
mod.addElement("Genius To Go");
img_url.addElement("images/ico_alpha_Shutdown_32x32.png");
mod.addElement("Album");
img_url.addElement("images/datafiles32.png");
mod.addElement("Podcast");
img_url.addElement("images/ico_alpha_TCPIP_32x32.png");
mod.addElement("Genius Store");
img_url.addElement("images/internet.png");
mod.addElement("GeniusCast");
img_url.addElement("images/Notify.png");
mod.addElement("Genius U");
img_url.addElement("images/ico_alpha_Users_32x32.png");
mod.addElement("Settings ");
img_url.addElement("images/settings.png");



DefaultListCellRenderer renderer = new DefaultListCellRenderer() {


public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {

if(isSelected) {
setText((value == null) ? "" : value.toString());
setForeground(Color.white);
setFont(new Font("tahoma",Font.BOLD,11));
setBackground(Color.DARK_GRAY);
setVerticalAlignment(JLabel.TOP);
click_itm = (String)value;
}
else {

setText((value == null) ? "" : value.toString());
setForeground(Color.DARK_GRAY);
setFont(new Font("tahoma",Font.PLAIN,11));
setBackground(Color.white);
setVerticalAlignment(JLabel.TOP);

}
setIcon(new ImageIcon((String)img_url.elementAt(index)));
return this;

}


};


itm.setCellRenderer(renderer);

itm.addMouseListener(this);

scl = new JScrollPane(itm);
scl.setBounds(20,45,170,288);
scl.addMouseListener(this);
//menu.add(scl);



}















public void initLoad() {





load = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.4f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(190,211,165));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
load.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
load.setBackground(Color.orange);




lbpass = new JLabel("Password:");
lbpass.setForeground(Color.DARK_GRAY);
lbpass.setFont(new Font("tahoma",Font.PLAIN,11));
lbpass.setBounds(40,24,200,30);
load.add(lbpass);


lgpass = new JPasswordField();
lgpass.setForeground(Color.DARK_GRAY);
lgpass.setFont(new Font("tahoma",Font.PLAIN,11));
lgpass.setBounds(40,46,170,20);
load.add(lgpass);

ldlg = new JButton("Enter Genius");
ldlg.setForeground(Color.DARK_GRAY);
ldlg.setFont(new Font("tahoma",Font.PLAIN,11));
ldlg.setBounds(65,68,120,20);
ldlg.addActionListener(this);
load.add(ldlg);

roll = new JLabel(new ImageIcon("images/16-on-black.gif"));
roll.setBounds((w/2)-8,(h/2)-8,16,16);


}












public void saveSettings() {

try {

fd = new File("settings.db");

OutputStream out = new BufferedOutputStream(new FileOutputStream(fd));
String sze = "W-"+ w +"^H-"+ h +"^";
out.write(sze.getBytes());
out.close();
}
catch(Exception e){}

}







public void getSetting() {

try {
fd = new File("settings.db");

InputStream in = new BufferedInputStream(new FileInputStream(fd));
byte[] gs = new byte[(int)fd.length()];
in.read(gs);
in.close();
String dat = new String(gs);

String wth = dat.substring(dat.indexOf("W-")+2,dat.indexOf("^"));
String hgt =dat.substring(dat.indexOf("H-")+2,dat.lastIndexOf("^") );

w = Integer.parseInt(wth);
h = Integer.parseInt(hgt);

setSize(w,h);
hmx.setBounds((w/2)-137,10,174,94);
repaint();

}
catch(Exception e){}


}















public void initFriendsList() {



friend = new DefaultMutableTreeNode("Genius U");

online = new DefaultMutableTreeNode("Friends");
online.add(frd = new DefaultMutableTreeNode("Ayo"));
online.add(frd = new DefaultMutableTreeNode("Faith"));
online.add(frd = new DefaultMutableTreeNode("Tunrayo"));
online.add(frd = new DefaultMutableTreeNode("Tunde GNT"));
online.add(frd = new DefaultMutableTreeNode("Mutador"));
online.add(frd = new DefaultMutableTreeNode("Bunmi"));
online.add(frd = new DefaultMutableTreeNode("Aanu"));
online.add(frd = new DefaultMutableTreeNode("Abass"));
online.add(frd = new DefaultMutableTreeNode("Yinka"));
online.add(frd = new DefaultMutableTreeNode("Wole"));
online.add(frd = new DefaultMutableTreeNode("Williams"));
online.add(frd = new DefaultMutableTreeNode("Wale BASIC"));
online.add(frd = new DefaultMutableTreeNode("Tosin"));
online.add(frd = new DefaultMutableTreeNode("Tola"));
online.add(frd = new DefaultMutableTreeNode("Seyoo"));

friend.add(online);


online = new DefaultMutableTreeNode("Available");
online.add(frd = new DefaultMutableTreeNode("Faith"));
online.add(frd = new DefaultMutableTreeNode("Mutador"));
online.add(frd = new DefaultMutableTreeNode("Tosin"));
online.add(frd = new DefaultMutableTreeNode("Tola"));
online.add(frd = new DefaultMutableTreeNode("Seyoo"));

friend.add(online);



friendlist = new JTree(friend){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

//Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.3f);
//g2d.setComposite(cmp);
g2d.setPaint(Color.white);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);

//g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};
friendlist.setDragEnabled(true);
friendlist.setToggleClickCount(0);
friendlist.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
JScrollPane fnd = new JScrollPane(friendlist);
fnd.setBorder(BorderFactory.createLineBorder(Color.orange,1));
fnd.setBounds(20,95,170,330);
genius_chat.add(fnd);
friendlist.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
//friendlist.addTreeSelectionListener(new LibrarySelection());

DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    renderer.setOpenIcon(new ImageIcon("images/GreenPlus.gif"));
    renderer.setClosedIcon(new ImageIcon("images/glyphs_plus_rest.png"));
    renderer.setLeafIcon(new ImageIcon("images/ico_alpha_User_16x16.png"));
   renderer.setFont(new Font("tahoma",Font.PLAIN,11));
   renderer.setForeground(Color.DARK_GRAY);
   renderer.setOpaque(false);
   friendlist.setCellRenderer(renderer);



}












public void setPublicChat() {

pub_chat_msg = new JTextArea(){
Image image = new ImageIcon("images/boy.png").getImage();

{setOpaque(false);}

public void paintComponent(Graphics g) {

Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.4f);
g2d.setComposite(cmp);
g2d.setPaint(Color.white);
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


int w=0,h=0;
while(h<getSize().height){
w=0;
while(w<getSize().width){
g.drawImage(image,w,h,this);
w+=image.getWidth(null);
}
h+=image.getHeight(null);}

g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));

super.paintComponent(g);
}

};

pub_chat_msg.setEditable(false);
pub_chat_msg.setFont(new Font("tahoma",Font.PLAIN,13));
pub_chat_msg.setForeground(Color.DARK_GRAY);
pub_chat_msg.setBackground(Color.white);
JScrollPane msg_sc = new JScrollPane(pub_chat_msg);
msg_sc.setBorder(BorderFactory.createLineBorder(Color.orange,1));
msg_sc.setBounds(200,95,470,280);
genius_chat.add(msg_sc);


msg = new JTextField();
msg.setBounds(200,383,350,20);
msg.setForeground(Color.DARK_GRAY);
msg.setFont(new Font("tahoma",Font.PLAIN,12));
genius_chat.add(msg);

go = new JButton("Send");
go.setBounds(560,383,80,20);
go.setFont(new Font("tahoma",Font.PLAIN,11));
go.addActionListener(this);
genius_chat.add(go);





}













public ImageIcon scaleImage(String icn, float sz) {

ImageIcon icon = new ImageIcon(icn);
Image img = icon.getImage();

       if (img.getWidth(null) > img.getHeight(null)){
           factor = Math.min (sz / img.getWidth(null), 1.0f);
}
 else {
          factor = Math.min (sz / img.getHeight(null), 1.0f);
}
       Image scaledImage =  img.getScaledInstance ((int) (img.getWidth(null) * factor),  (int) (img.getHeight(null) * factor),  Image.SCALE_FAST);
icon.setImage(scaledImage);
return icon;

}










public void openMessageBox() {


album = new JPanel(null){

{setOpaque(false);}

public void paintComponent(Graphics g) {


Graphics2D g2d = (Graphics2D)g;

Composite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f);
g2d.setComposite(cmp);
g2d.setPaint(new Color(70,90,190));
Rectangle2D rec = new Rectangle2D.Double(0, 0,w,h);
g2d.fill(rec);


g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.9f));

super.paintComponent(g);
}

};
album.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));


}








public void initClassButton() {

nxt = new JButton("Next");
nxt.setForeground(Color.DARK_GRAY);
nxt.setFont(new Font("tahoma",Font.PLAIN,11));

pvw = new JButton("Previous");
pvw.setForeground(Color.DARK_GRAY);
pvw.setFont(new Font("tahoma",Font.PLAIN,11));


}



public static void main(String[] args) {

os db = new os();

}

}
