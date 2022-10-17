import java.io.*;
import java.util.*;
import java.net.*;



public class encryptor {
 	 
    	

String[] lc_ltr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

String[] hc_ltr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

String[] num = {"[99 ", "[93 ", "[87 ", "[81 ", "[57 ", "[70 ", "[63 ", "[82 ", "[94 ", "[78 ", "[69 ", "[77 ", "[80 ", "[54 ", "[67 ", "[76 ", "[98 ", "[88 ", "[59 ", "[71 ", "[56 ", "[66 ", "[50", "[84", " [90", "[96" };

String[] num2 = {"[49 ", "[29 ", "[11 ", "[36 ", "[19 ", "[32 ", "[42 ", "[34 ", "[41 ", "[15 ", "[22 ", "[23 ", "[39 ", "[44 ", "[13 ", "[17 ", "[25 ", "[33 ", "[27 ", "[47 ", "[20 ", "[40 ", "[30", "[45", " [10", "[48" };

encryptor() {




}




public String doEncryption(String str) {

String enc =str;

for(int i=0;i<num.length;i++) {

		 enc = enc.replace(lc_ltr[i],num[i]);

}


for(int i=0;i<num2.length;i++) {

		 enc = enc.replace(hc_ltr[i],num2[i]);

}



return enc;
}



public String doDecryption(String str) {

String enc =str;

for(int i=0;i<num.length;i++) {

		 enc = enc.replace(num[i],lc_ltr[i]);

}


for(int i=0;i<num2.length;i++) {

		 enc = enc.replace(num2[i],hc_ltr[i]);

}


return enc;


}	

	






public static void main(String[] args) {

encryptor c = new encryptor();

}




	
} 