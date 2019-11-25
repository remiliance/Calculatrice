package com.sdz.model;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

public class ModeleCalculette extends Modele{

	public ModeleCalculette()
	{
		super();
	}
	 public void setOperateur(String Operat)
		{
			this.ope=Operat;
			this.notifyObserver(Operat);
		}
		
		public void setChiffre1(double chiffre1)
		{
			this.chiffre1=chiffre1;
			this.notifyObserver(String.valueOf(chiffre1));
		}
		public void setChiffre2(double chiffre2)
		{
			this.chiffre2=chiffre2;
			this.notifyObserver(String.valueOf(chiffre2));
		}
	@Override
	public void notifyObserver(String str) {
		// TODO Auto-generated method stub
		 for(Observer obs : listObserver)
		      obs.update(str);
	}
	
	@Override
	public double calcul() {
		// TODO Auto-generated method stub
		double resultat=0;
		if (this.ope=="+")
			
		{result=chiffre1+chiffre2;
		//Resultat.setText(result);
		System.out.println(result);
		}
		if (this.ope=="-")
		{result=chiffre1-chiffre2;
		//Resultat.setText(result);
		System.out.println(result);
		}
		System.out.println("Resultat :"+result);
		this.notifyObserver(String.valueOf(result));
		return result;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		{
			chiffre1=-1;
			chiffre2=-1;		
			result=-1;
			System.out.println(chiffre1);
			System.out.println(chiffre2);
		}
		
	}

	@Override
	public void getResultat() {
		// TODO Auto-generated method stub
		
		//On lance aussi la mise à jour !
	// notifyObserver(String.valueOf(this.result));
	
		
		
	}

	
}
