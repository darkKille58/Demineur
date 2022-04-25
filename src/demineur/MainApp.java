package demineur;

import demineur.form.AppFrame;

/**
 * Classe principale qui d�clenche l'ex�cution du
 * programme.
 * 
 * 
 */

public class MainApp
{
	public MainApp()
	{
		AppFrame frame = AppFrame.getInstance();
		frame.setVisible(true);
	}
	
	/**
	 * Point d'entr�e du programme.
	 * 
	 * @param args	Arguments de ligne de commande.
	 */
	public static void main(String[] args)
	{
		new MainApp();
	}
}
