/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creche;

import java.util.Vector;

/**
 *
 * @author ITU
 */
public class Control {
         public Control(){} 
         public String[] spliter(String phrase, String sep ){
		Vector tempo=new Vector();
		int debut=0, fin=phrase.indexOf(sep,debut);
		while(fin>debut){
			tempo.addElement(phrase.substring(debut,fin));
			debut=fin+1;
			fin=phrase.indexOf(sep,debut);
		}
		tempo.addElement(phrase.substring(debut));
		String[] valiny=new String[tempo.size()];
		int i=0, len=tempo.size();
		for(i=0;i<len;i++){
			valiny[i]=(String)tempo.elementAt(i);
		}
		return valiny;
    }
}
