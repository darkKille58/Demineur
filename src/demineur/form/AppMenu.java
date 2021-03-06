package demineur.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import minesweeper.form.dialogs.AboutDialog;
import minesweeper.form.dialogs.BestTimesDialog;
import minesweeper.form.dialogs.CheatDialog;
import minesweeper.form.dialogs.CustomGridDialog;
import minesweeper.model.CustomGridObject;
import minesweeper.model.DifficultyLevel;
import minesweeper.model.event.ValidationEvent;
import minesweeper.model.event.ValidationListener;


/**
 * La classe AppMenu représente la barre de menus
 * de l'application.
 *
 */
public class AppMenu extends JMenuBar implements ActionListener, ValidationListener
{
	private static final String GAME_MENU_TITLE = "Partie";
	private static final char GAME_MNEMONIC = 'P';
	private static final String NEW_GAME_ACTION_COMMAND = "Nouveau";
	private static final char NEW_GAME_MNEMONIC = 'N';
	private static final String BEGINNER_ACTION_COMMAND = "Débutant";
	private static final char BEGINNER_MNEMONIC = 'D';
	private static final String MEDIUM_ACTION_COMMAND = "Intermédiaire";
	private static final char MEDIUM_MNEMONIC = 'I';
	private static final String EXPERT_ACTION_COMMAND = "Expert";
	private static final char EXPERT_MNEMONIC = 'E';
	private static final String CUSTOM_ACTION_COMMAND = "Personnalisé...";
	private static final char CUSTOM_MNEMONIC = 'P';
	private static final String CHEAT_ACTION_COMMAND = "Tricher...";
	private static final char CHEAT_MNEMONIC = 'T';
	private static final String BEST_SCORES_ACTION_COMMAND = "Meilleurs temps...";
	private static final char BEST_SCORES_MNEMONIC = 'M';
	private static final String EXIT_ACTION_COMMAND = "Quitter";
	private static final char EXIT_MNEMONIC = 'Q';
	private static final String HELP_MENU_TITLE = "?";
	private static final char HELP_MENU_MNEMONIC = '?';
	private static final String HELP_ACTION_COMMAND = "Aide...";
	private static final char HELP_MNEMONIC = 'A';
	private static final String HELP_TITLE = "Aide du démineur";
	private static final String HELP_TEXT = "Le but du jeu est de découvrir toutes les cases libres sans faire exploser les mines. \r\n" + 
			"\r\n" + 
			" Pour libérer une case, faire un clic gauche (clic normal)\r\n" + 
			"\r\n" + 
			" Pour marquer une mine, faire un clic droit, qui fera apparaître un drapeau.\r\n" + 
			"\r\n" + 
			"Le compteur  en haut ŕ gauche indique le nombre de mines qu'il reste ŕ trouver.";
	
	private boolean levelBeginnerChosen = true;
	private boolean levelMediumChosen = false;
	private boolean levelExpertChosen = false;
	
	/**
	 * Constructeur.
	 * 
	 */
	public AppMenu()
	{
		super();
		this.initializeComponent();
	}
	
	/*
	 * Crée et dispose les composants.
	 * 
	 */
	private void initializeComponent()
	{
        // Menu Partie.
		JMenu mnuGame = new JMenu(AppMenu.GAME_MENU_TITLE);
		mnuGame.setMnemonic(AppMenu.GAME_MNEMONIC);
		this.add(mnuGame);
		
		// Item de menu Partie/Nouveau.
		JMenuItem mniNewGame = new JMenuItem(AppMenu.NEW_GAME_ACTION_COMMAND, AppMenu.NEW_GAME_MNEMONIC);
		mniNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mniNewGame.addActionListener(this);
		mnuGame.add(mniNewGame);
		mnuGame.addSeparator();
		
		ButtonGroup btgLevels = new ButtonGroup();
		// Item de menu Partie/Débutant.
		JRadioButtonMenuItem mrbBeginner = new JRadioButtonMenuItem(AppMenu.BEGINNER_ACTION_COMMAND);
		mrbBeginner.setMnemonic(AppMenu.BEGINNER_MNEMONIC);
		mrbBeginner.setSelected(true);
		mrbBeginner.addActionListener(this);
		mrbBeginner.setActionCommand(AppMenu.BEGINNER_ACTION_COMMAND);
		
		// Item de menu Partie/Nouveau/Intermédiaire.
		JRadioButtonMenuItem mrbMedium = new JRadioButtonMenuItem(AppMenu.MEDIUM_ACTION_COMMAND);
		mrbMedium.setMnemonic(AppMenu.MEDIUM_MNEMONIC);
		mrbMedium.addActionListener(this);
		mrbMedium.setActionCommand(AppMenu.MEDIUM_ACTION_COMMAND);
		
		
		// Item de menu Partie/Nouveau/Expert.
		JRadioButtonMenuItem mrbExpert = new JRadioButtonMenuItem(AppMenu.EXPERT_ACTION_COMMAND);
		mrbExpert.setMnemonic(AppMenu.EXPERT_MNEMONIC);
		mrbExpert.addActionListener(this);
		mrbExpert.setActionCommand(AppMenu.EXPERT_ACTION_COMMAND);
		
		// Item de menu Partie/Personnalisé.
		JRadioButtonMenuItem mrbCustom = new JRadioButtonMenuItem(AppMenu.CUSTOM_ACTION_COMMAND);
		mrbCustom.setMnemonic(AppMenu.CUSTOM_MNEMONIC);
		mrbCustom.setActionCommand(AppMenu.CUSTOM_ACTION_COMMAND);
		mrbCustom.addActionListener(this);
		
		btgLevels.add(mrbBeginner);
		btgLevels.add(mrbMedium);
		btgLevels.add(mrbExpert);
		btgLevels.add(mrbCustom);
		
		mnuGame.add(mrbBeginner);
		mnuGame.add(mrbMedium);
		mnuGame.add(mrbExpert);
		mnuGame.add(mrbCustom);
		
		mnuGame.addSeparator();
		
		// Item de menu Partie/Tricher.
		JMenuItem mniCheat = new JMenuItem(AppMenu.CHEAT_ACTION_COMMAND, AppMenu.CHEAT_MNEMONIC);
		mniCheat.addActionListener(this);
		mniCheat.setActionCommand(AppMenu.CHEAT_ACTION_COMMAND);
		mnuGame.add(mniCheat);
		mnuGame.addSeparator();
		
		// Item de menu Partie/Meilleurs Temps.
		JMenuItem mniBestScores = new JMenuItem(AppMenu.BEST_SCORES_ACTION_COMMAND, AppMenu.BEST_SCORES_MNEMONIC);
		mniBestScores.addActionListener(this);
		mniBestScores.setActionCommand(AppMenu.BEST_SCORES_ACTION_COMMAND);
		mnuGame.add(mniBestScores);
		mnuGame.addSeparator();
		
		// Item de menu Partie/Quitter.
		JMenuItem mniClose = new JMenuItem(AppMenu.EXIT_ACTION_COMMAND, AppMenu.EXIT_MNEMONIC);
		mniClose.addActionListener(this);
		mniClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mniClose.setActionCommand(AppMenu.EXIT_ACTION_COMMAND);
		mnuGame.add(mniClose);
		
		// Menu "?".
		JMenu mnuHelp = new JMenu(AppMenu.HELP_MENU_TITLE);
		mnuHelp.setMnemonic(AppMenu.HELP_MENU_MNEMONIC);
		this.add(mnuHelp);
		
		// Item de menu Aide.
		JMenuItem mniHelp = new JMenuItem(AppMenu.HELP_ACTION_COMMAND, AppMenu.HELP_MNEMONIC);
		mniHelp.setActionCommand(AppMenu.HELP_ACTION_COMMAND);
		mniHelp.addActionListener(this);
		mnuHelp.add(mniHelp);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals(AppMenu.EXIT_ACTION_COMMAND))
		{ this.exit_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.NEW_GAME_ACTION_COMMAND))
		{ this.newGame_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.BEGINNER_ACTION_COMMAND))
		{ this.beginner_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.MEDIUM_ACTION_COMMAND))
		{ this.medium_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.EXPERT_ACTION_COMMAND))
		{ this.expert_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.CUSTOM_ACTION_COMMAND))
		{ this.custom_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.CHEAT_ACTION_COMMAND))
		{ this.cheat_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.BEST_SCORES_ACTION_COMMAND))
		{ this.bestTimes_Clicked(); }
		else if (e.getActionCommand().equals(AppMenu.HELP_ACTION_COMMAND))
		{ this.help_Clicked(); }
	}
	
	public DifficultyLevel getSelectedGameLevel()
	{
		DifficultyLevel level;
		if (this.levelBeginnerChosen)
		{
			level = DifficultyLevel.BEGINNER;
		}
		else if (this.levelMediumChosen)
		{
			level = DifficultyLevel.MEDIUM;
		}
		else if (this.levelExpertChosen)
		{
			level = DifficultyLevel.EXPERT;
		}
		else
		{
			level = DifficultyLevel.CUSTOM;
		}
		return level;
	}
	
	private void help_Clicked()
	{
		JOptionPane.showMessageDialog(null, AppMenu.HELP_TEXT, AppMenu.HELP_TITLE, JOptionPane.PLAIN_MESSAGE);
	}
	
	private void bestTimes_Clicked()
	{
		BestTimesDialog.showDialog();
	}
	
	/*
	 * Gčre la fermeture du jeu.
	 * 
	 */
	private void exit_Clicked()
	{
		AppFrame.getInstance().askExitQuestion();
	}
	
	/*
	 * Affiche le dialogue "Ŕ Propos"
	 * 
	 */
	private void about_Clicked()
	{
		AboutDialog.showDialog();
	}
	
	/*
	 * Affiche le dialogue permettant de saisir le mot de
	 * passe de triche.
	 * 
	 */
	private void cheat_Clicked()
	{
		CheatDialog.showDialog(GameBoard.getPassword(), this);
	}
	
	/*
	 * Gčre le clic sur "Nouvelle Partie".
	 * 
	 */
	private void newGame_Clicked()
	{
		// Demande ŕ la fenętre de jeu de commencer une nouvelle partie.
		AppFrame.getInstance().startGame();
	}
	
	private void beginner_Clicked()
	{
		this.levelBeginnerChosen = true;
		this.levelMediumChosen = false;
		this.levelExpertChosen = false;
		this.newGame_Clicked();
	}
	
	private void medium_Clicked()
	{
		this.levelBeginnerChosen = false;
		this.levelMediumChosen = true;
		this.levelExpertChosen = false;
		this.newGame_Clicked();
	}
	
	private void expert_Clicked()
	{
		this.levelBeginnerChosen = false;
		this.levelMediumChosen = false;
		this.levelExpertChosen = true;
		this.newGame_Clicked();
	}
	
	private void custom_Clicked()
	{
		this.levelBeginnerChosen = false;
		this.levelMediumChosen = false;
		this.levelExpertChosen = false;
		CustomGridDialog.showDialog(this);
	}

	public void validated(ValidationEvent e)
	{
		if (e.getValidatedClass() == CheatDialog.class)
		{
			//System.out.println("Triche activée !");
			AppFrame.getInstance().getGameBoard().cheat();
		}
		else if (e.getValidatedClass() == CustomGridDialog.class)
		{
			if (e.getData() != null && e.getData() instanceof CustomGridObject)
			{
				CustomGridObject cgo = (CustomGridObject)e.getData();
				AppFrame.getInstance().startGame(
					DifficultyLevel.CUSTOM, cgo.getMinesPerRow(),
					cgo.getMinesPerColumn(), cgo.getNbMines());
			}
		}
	}
}
