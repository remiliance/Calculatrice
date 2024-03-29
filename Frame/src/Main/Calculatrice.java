package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener; 
	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;


public class Calculatrice extends JPanel {
		JComboBox<String> boitecombo;
		JLabel MaCalculette;
		JLabel Resultat;	
		 String[] tab_string={"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
		JFrame fen=new JFrame( );
		Container contenu, contenu2, contenu3; 
		String temp;
		JPanel container = new JPanel();
		double chiffre1=0,chiffre2=0;
		String Operateur;
		double result=0;
		
		public Calculatrice()
		{
			Resultat = new JLabel("0");
			AffichageCalculatrice();
		}
		
		private void AffichageCalculatrice( ) 
		{
			fen.setSize(540, 560);
			fen.setTitle("Ma calculatrice!");
			fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fen.setLocationRelativeTo(null);
		    fen.setResizable(false);
		   
			//On d�finit la police d'�criture � utiliser et r�sultat � 0 par d�faut
		    Font police = new Font("Arial", Font.BOLD, 20);
		   
		    Resultat.setFont(police);
		    //On aligne les informations � droite dans le JLabel
		    Resultat.setHorizontalAlignment(JLabel.RIGHT);
		    Resultat.setPreferredSize(new Dimension(200, 20));
		    
		    //Cadre noir   
		    // JPanel chiffre = new JPanel();
		    //chiffre.setPreferredSize(new Dimension(15, 25));
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
		        //Pour chaque �l�ment situ� � la fin du tableau
		        //et qui n'est pas un chiffre
		        //on d�finit le comportement � avoir gr�ce � un listener
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
				if (chiffre1==-1)
					chiffre1=Double.parseDouble(temp);
				else
					chiffre2=Double.parseDouble(temp);
				Resultat.setText(temp);	
				System.out.println("chiffre1");
				System.out.println(chiffre1);
				System.out.println("chiffre2");
				System.out.println(chiffre2);
			}
		}
		
		public class Reset implements ActionListener{
			public void actionPerformed(ActionEvent arg0)
			{
				chiffre1=-1;
				chiffre2=-1;		
				result=-1;
				System.out.println(chiffre1);
				System.out.println(chiffre2);
			}
		}
		
		public class Plus implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				Object valeur=((JButton)e.getSource()).getText();
				Operateur=(String) valeur;
				Resultat.setText(Operateur);	
			}
			}
		
		public class Egal implements ActionListener{
			public void actionPerformed(ActionEvent arg0)
			{
				if (Operateur=="+")
				{result=chiffre1+chiffre2;
				//Resultat.setText(result);
				System.out.println(result);
				System.out.println("oui");
				}
				
				//result=-1;
				//chiffre1=-1;
				//chiffre2=-1;
			}
			
			}
		
	}
