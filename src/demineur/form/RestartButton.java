package demineur.form;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import util.ImageUtil;

/**
 * La classe RestartButton représente la bouton avec un
 * entre le timer et le compteur de mines  qui permet de recommencer la partie.
 * 
 *
 */
public class RestartButton extends JButton
{
	private ImageIcon iconStart = ImageUtil.getImageIcon(this, "reload.png");
	private ImageIcon iconWon = ImageUtil.getImageIcon(this, "win.png");
	private ImageIcon iconLost = ImageUtil.getImageIcon(this, "loser.png");

	
	public RestartButton()
	{
		super();
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(36, 36));
		this.setMaximumSize(this.getPreferredSize());
		this.reset();
	}
	
   public void indicateGameWon()
	{
		this.setIcon(this.iconWon);
	}
	
	public void indicateGameLost()
	{
		this.setIcon(this.iconLost);
	}
	
	
	public void indicateMouseReleased()
	{
		this.reset();
	}
	
	public void reset()
	{
		this.setIcon(this.iconStart);
	}
}
