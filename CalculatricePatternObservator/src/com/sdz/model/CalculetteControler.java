package com.sdz.model;

import java.util.ArrayList;

//puisque notre contrôleur doit interagir avec le modèle, il faudra qu'il possède une instance de notre modèle.

public class CalculetteControler {
	 protected Modele calc;
	 protected ArrayList<String> listOperateur = new ArrayList<String>();
	 //public double chiffre1=-1;
	 //public double chiffre2=-1;
	 //public String ope="";
	 public double result=0;
	
	public CalculetteControler(Modele calc)
	{
		this.calc = calc;
	    //On définit la liste des opérateurs
	    //Afin de s'assurer qu'ils sont corrects
	    this.listOperateur.add("+");
	    this.listOperateur.add("-");
	    this.listOperateur.add("*");
	    this.listOperateur.add("/");
	    this.listOperateur.add("=");
	}
	
	 //Définit le nombre
	  public void setChiffre(String Chiff1){
		  if (calc.chiffre1==-1)
				this.calc.setChiffre1(Double.parseDouble(Chiff1));
			else
				this.calc.setChiffre2(Double.parseDouble(Chiff1));
		  System.out.println("je controle Chiffre 1 :"+calc.chiffre1);
		  System.out.println("je controle Chiffre 2 :"+calc.chiffre2);
	  }
	  
	  public void setOperateur(String opel)
	  {
	  	this.calc.setOperateur(opel);
	  	System.out.println("je controle l'operateur :"+opel);
	  }
	  
	  public void reset()
	  {
		  this.calc.reset();
	  }
	  
	  public void calcul()
	  {
		  this.calc.calcul();
	  }
	  
	  
	  
	  }
	  

