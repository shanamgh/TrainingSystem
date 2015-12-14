package Default;
import javax.swing.*;
import com.mahan.present.com.mahan.present.controller.MainFrame;

public class AppStart {

	public static void main(String[] args) {
		

		SwingUtilities.invokeLater(new Runnable() {
			MainFrame frame;
			public void run() {
				frame = new MainFrame();
			}
		});

	}

}
