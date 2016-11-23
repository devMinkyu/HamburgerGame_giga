package hamburger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import constants.Constants_buger.EBottomBread;
import constants.Constants_buger.EFiveRandomLocation;

public class BottomBread extends Material {
	private JLabel bottomBread;
	private ImageIcon image;

	@Override
	public void initMaterial(int i, int n) {
		image = new ImageIcon(EBottomBread.bottomBread.getImg());
		bottomBread = new JLabel(image);
		bottomBread.setBounds(EFiveRandomLocation.bottomBread.getX(), EFiveRandomLocation.bottomBread.getY(),
				image.getIconWidth(), image.getIconHeight());
	}

	@Override
	public JLabel getMaterial() { return bottomBread; }
}
