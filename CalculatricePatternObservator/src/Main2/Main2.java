package Main2;

import com.sdz.model.*;
import com.sdz.vue.*;


public class Main2 {

  public static void main(String[] args) {
    //Instanciation de notre modèle
    Modele calc = new ModeleCalculette();
    //Création du contrôleur
    CalculetteControler controler = new CalculetteControler(calc);
    //Création de notre fenêtre avec le contrôleur en paramètre
   VueCalc cc= new VueCalc(controler);
    //Ajout de la fenêtre comme observer de notre modèle
    calc.addObserver(cc);
  }
}
