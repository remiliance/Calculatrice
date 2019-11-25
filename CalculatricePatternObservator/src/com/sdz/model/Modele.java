package com.sdz.model;

import java.util.ArrayList;
import java.util.*;
import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

import utils.*;

public abstract class  Modele implements Observable {
	
	public ArrayList<Observer> listObserver=new ArrayList<Observer>();
	public double chiffre1=-1;
	public double chiffre2=-1;
	public String ope="";
	public double result;
	
		public Modele()
	{
	}
	
	public void addObserver(Observer obs) {
	    this.listObserver.add(obs);
	  }
		  
	public void removeObserver() {
		  this.listObserver = new ArrayList<Observer>();
		  }  
	
	public abstract double calcul ();
	
	public abstract void reset();
	
	//Affichage forcé du résultat
	  public abstract void getResultat();
	  
	  public abstract void setOperateur(String Operat);
		
		public abstract void setChiffre1(double chiffre1);	
		
		public abstract void setChiffre2(double chiffre2);
		

		public abstract void notifyObserver(String str); 
		
		
		
	
}
