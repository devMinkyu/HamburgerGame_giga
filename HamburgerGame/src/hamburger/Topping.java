package hamburger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import constants.Constants_buger.ERandomLocation;
import constants.Constants_buger.ETopping;
import data_managements.ConfirmQueue;
import data_managements.ConfirmStack;

public class Topping extends Material {
	private JLabel topping;
	private ImageIcon image;
	private ConfirmStack stack = new ConfirmStack();
	private ConfirmQueue queue = new ConfirmQueue();
	
	@Override
	public void initMaterial(int i, int n) {
		ETopping[] eTopping = ETopping.values();
		for (int j = 0; j <= i; j++) {
			image = new ImageIcon(eTopping[j].getImg());
			topping = new JLabel(image);
		}
		topping.setBounds(ERandomLocation.topping.getX(), ERandomLocation.topping.getY(), image.getIconWidth(),
				image.getIconHeight());
		switch (n) {
		case 0:stack.push(i);
			break;
		case 1:queue.enqueue(i);
			break;
		default:
			break;
		}
	}

	public JLabel getMaterial() {
		return topping;
	}

}
