package Main2;

import com.sdz.model.*;
import com.sdz.vue.*;


public class Main2 {

  public static void main(String[] args) {
    //Instanciation de notre mod�le
    Modele calc = new ModeleCalculette();
    //Cr�ation du contr�leur
    CalculetteControler controler = new CalculetteControler(calc);
    //Cr�ation de notre fen�tre avec le contr�leur en param�tre
   VueCalc cc= new VueCalc(controler);
    //Ajout de la fen�tre comme observer de notre mod�le
    calc.addObserver(cc);
  }
}
