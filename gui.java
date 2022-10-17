import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class gui extends JFrame{

JList itm;
Vector img_url;
float factor = 1.0f;
JPanel menu;

gui() {


try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e) {}

Container c = getContentPane();


img_url = new Vector();



itm = new JList();

DefaultListModel mod = new DefaultListModel();
itm.setModel(mod);

mod.addElement("Kayode Ilori - kay2care@gmail.com");
img_url.addElement("SDC15599.jpg");
mod.addElement("Asheleigh Domino - asheleighd@aol.com");
img_url.addElement("SDC15237.jpg");
mod.addElement("Yaya Ayokunle - ayokunlex@yahoo.com");
img_url.addElement("SDC14930.jpg");
mod.addElement("Gbenga Adeoye - xstuff@gmail.com");
img_url.addElement("SDC14932.jpg");
mod.addElement("Ilori Lekan - ilori204@gmail.com");
img_url.addElement("SDC14961.jpg");
mod.addElement("Bello Bukky - cuteyspy@gmail.com");
img_url.addElement("SDC15188.jpg");





DefaultListCellRenderer renderer = new DefaultListCellRenderer() {


public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {

if(isSelected) {
setText((value == null) ? "" : value.toString());
setForeground(Color.white);
setFont(new Font("tahoma",Font.BOLD,12));
setBackground(Color.DARK_GRAY);
setVerticalAlignment(JLabel.TOP);

}
else {

setText((value == null) ? "" : value.toString());
setForeground(Color.DARK_GRAY);
setFont(new Font("tahoma",Font.BOLD,11));
setBackground(Color.white);
setVerticalAlignment(JLabel.TOP);

}
setIcon(scaleImage((String)img_url.elementAt(index),50f));
return this;

}


};




itm.setCellRenderer(renderer);




c.add(new JScrollPane(itm),BorderLayout.CENTER);




setSize(700,500);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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





public static void main(String in[]){

gui g = new gui();

}

}




