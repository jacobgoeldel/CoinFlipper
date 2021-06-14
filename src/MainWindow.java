import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow {

	private JFrame frame;
	private Coin coin;
	private Dice dice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		coin = new Coin();
		dice = new Dice();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Coin Flipper");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnFlipCoin = new JButton("Flip Coin");
		btnFlipCoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coin.flip();
				JOptionPane.showMessageDialog(null, coin.getSide());
			}
		});
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dice.roll();
				JOptionPane.showMessageDialog(null, dice.getResult());
			}
		});
		
		JButton btnRollTwoDice = new JButton("Roll Two Dice");
		btnRollTwoDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String outputText = "Dice 1:\n";
				dice.roll();
				outputText += dice.getResult();
				
				outputText += "Dice 2:\n";
				dice.roll();
				outputText += dice.getResult();
				
				JOptionPane.showMessageDialog(null, outputText);
			}
		});
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String outputText = coin.getStatistics();
				outputText += "\n";
				outputText += dice.getStatistics();
				JOptionPane.showMessageDialog(null, outputText);
			}
		});
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowEvent closeEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
				java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeEvent);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStatistics, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(btnRollTwoDice, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(btnRollDice, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
								.addComponent(btnFlipCoin, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnFlipCoin)
					.addGap(18)
					.addComponent(btnRollDice)
					.addGap(18)
					.addComponent(btnRollTwoDice)
					.addGap(18)
					.addComponent(btnStatistics)
					.addGap(18)
					.addComponent(btnQuit)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
