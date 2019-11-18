package Main;


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


	public class Calculatrice extends JPanel implements ActionListener{
		JComboBox<String> boitecombo;
		JLabel MaCalculette;
		JLabel Resultat;	
		String[]tab={"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
		JFrame fen=new JFrame( );
		Container contenu, contenu2; 
		String temp;
		
		
		public Calculatrice()
		{
			AffichageCalculatrice( );
		}
		
		private void AffichageCalculatrice( ) 
		{
			MaCalculette=new JLabel("Saisir Ville");
			Resultat = new JLabel();
			boitecombo=new JComboBox<String>(tab);
			boitecombo.addActionListener(this);
			boitecombo.setEditable(true);
			fen.setSize(400,200);
			fen.setTitle("Ma calculatrice");
			contenu=fen.getContentPane( );
			contenu.setLayout(new FlowLayout( ));
			Resultat.setFont(new Font(null,2,18));
			contenu.add(MaCalculette);
			contenu.add(boitecombo);
			contenu2=fen.getContentPane( );
			contenu2.setLayout(new FlowLayout( ));
			contenu2.add(Resultat);
			fen.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			Object valeur=boitecombo.getSelectedItem();
			temp=(String) valeur;
			if (temp=="Paris")Resultat.setText("75000");		
		}
		
	}
