package com.sdz.vue;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.model.*;
import com.sdz.vue.*;



import com.sdz.observer.*;

public class VueCalc extends JFrame implements Observer{
		public JComboBox<String> boitecombo;
		public JLabel MaCalculette;
		public JLabel Resultat;	
		public String[] tab_string={"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
		public JFrame fen =new JFrame( );
		public Container contenu, contenu2, contenu3; 
		public String temp;
		public JPanel container = new JPanel();
		public String Operateur;
		double result=0;
		CalculetteControler calc;
		
		public VueCalc(CalculetteControler calc)
		{
			this.calc=calc;
			this.fen.setSize(540,560);
			this.fen.setTitle("Ma calculatrice!");
			this.fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.fen.setLocationRelativeTo(null);
			this. fen.setResizable(false);
			Resultat = new JLabel("0");
			//On définit la police d'écriture à utiliser et résultat à 0 par défaut
		    Font police = new Font("Arial", Font.BOLD, 20);
		    Resultat.setFont(police);
		    //On aligne les informations à droite dans le JLabel
		    Resultat.setHorizontalAlignment(JLabel.RIGHT);
		    JPanel panEcran = new JPanel();
		    panEcran.setPreferredSize(new Dimension(200, 30));
		    panEcran.add(Resultat);
		    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
		   		   
		    contenu = fen.getContentPane( ) ; 
		    contenu.add(panEcran); 
		    contenu.add(Resultat); 
    
		    JButton[] tab_button = new JButton[tab_string.length];
		    
		    for(int i = 0; i < tab_string.length; i++){
		        tab_button[i] = new JButton(tab_string[i]);
		        switch(i){
		        //Pour chaque élément situé à la fin du tableau
		        //et qui n'est pas un chiffre
		        //on définit le comportement à avoir grâce à un listener
		        case 11 :
		          tab_button[i].addActionListener(new Egal());
		          contenu.add(tab_button[i]);
		          break;
		        case 12 :
		         tab_button[i].addActionListener(new Reset());
		          contenu.add(tab_button[i]);
		          break;
		        case 13 :
		         tab_button[i].addActionListener(new Plus());
		          contenu.add(tab_button[i]);
		          break;
		        case 14 :
		         // tab_button[i].addActionListener(new MoinsListener());		          
		          contenu.add(tab_button[i]);
		          break;	
		        case 15 :	
		          //tab_button[i].addActionListener(new MultiListener());
		          contenu.add(tab_button[i]);
		          break;
		        case 16 :
		          //tab_button[i].addActionListener(new DivListener());
		          contenu.add(tab_button[i]);
		          break;
		        default :
		        	contenu.add(tab_button[i]);
		        	tab_button[i].addActionListener(new Chiffre());
		          break;
		      } 
		    }
	  
			contenu.setLayout(new FlowLayout( ));
			 fen.setVisible(true);
		}

		public class Chiffre implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{    
			    Object valeur=((JButton)e.getSource()).getText();
				String temp=(String) valeur;
				calc.setChiffre(temp);
				//Resultat.setText(temp);
			}
		}
		
		public class Reset implements ActionListener{
			public void actionPerformed(ActionEvent arg0)
			{
				calc.reset();
			}
		}
		
		public class Plus implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				Object valeur=((JButton)e.getSource()).getText();
				Operateur=(String) valeur;
				calc.setOperateur("+");
				//Resultat.setText(Operateur);	
			}
			}
		
		public class Egal implements ActionListener{
			public void actionPerformed(ActionEvent arg0)
			{
				calc.calcul();
				}
			}
		
		public void update(String str1)
		{
			Resultat.setText(str1);
		}
		
	}