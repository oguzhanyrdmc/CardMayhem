import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class P2Screen extends JFrame {

	private JPanel contentPane;
	private JRadioButton[] radioButton;
	private JButton btnWeapon;
	private JLabel lblTurn;
	private JButton btnEndTurn;
	private JButton btnPlayCard;
	private JLabel lblDeck;
	private JLabel lblHealth;
	private JLabel lblNick;
	private JLabel lblEnemyHealth;
	private JLabel lblEnemyWeapon;
	private JLabel lblEnemyRemainingCards;
	private JLabel lblEnemyHand;
	private JLabel lblEnemyNick;

	public P2Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		setTitle("Player2");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		int m = 0;
		contentPane.setLayout(null);

		btnEndTurn = new JButton("End turn @ " + Login.battle.getPlayer2().getActionPoint());
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setBackground(new Color(65, 105, 225));
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.battle.endTour();
				setVisible(false);
				P1Screen sv1 = new P1Screen();
				sv1.setVisible(true);

			}
		});
		btnEndTurn.setBounds(634, 414, 120, 25);

		contentPane.add(btnEndTurn);
		radioButton = new JRadioButton[30];
		for (int i = 0; i < Login.battle.getPlayer2().getHand().getHand().size(); i++) { // create card button
			if (i % 5 == 0 && i != 0)
				m++;
			radioButton[i] = new JRadioButton(Login.battle.getPlayer2().getHand().pick(i) + " | "
					+ Login.battle.getPlayer2().getHand().getHand().get(i).getName());
			radioButton[i].setBounds(50 + ((i % 5) * 128), 210 + (26 * m), 120, 25);
			radioButton[i].setBackground(new Color(176, 196, 222));
			contentPane.add(radioButton[i]);
		}
		btnPlayCard = new JButton("Play Card");
		btnPlayCard.setBackground(new Color(255, 255, 102));
		btnPlayCard.setBounds(22, 414, 97, 25);
		btnPlayCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.battle.getPlayer2().getActionPoint() > 0) { // actionpoint control
					boolean flag = true;
					for (int i = 0; i < radioButton.length; i++) {
						if (radioButton[i].isSelected()
								&& Login.battle.getPlayer2().getName().equalsIgnoreCase("Axe")) {
							if (Login.battle.getPlayer2().getHand().getHand().get(i).getTurn() <= BattleGround.turn) {
								((Axe) (Login.battle.getPlayer2())).PlayCard(i);

							} else {
								flag = false;
								JOptionPane.showMessageDialog(contentPane, "This card cannot be played this turn.");
							}
							break;
						} else if (radioButton[i].isSelected()
								&& Login.battle.getPlayer2().getName().equalsIgnoreCase("Blood")) {
							if (Login.battle.getPlayer2().getHand().getHand().get(i).getTurn() <= BattleGround.turn) {
								((Blood) (Login.battle.getPlayer2())).PlayCard(i);

							} else {
								flag = false;
								JOptionPane.showMessageDialog(contentPane, "This card cannot be played this turn.");
							}
							break;
						} else if (radioButton[i].isSelected()
								&& (Login.battle.getPlayer2().getName().equalsIgnoreCase("Light"))) {
							if (Login.battle.getPlayer2().getHand().getHand().get(i).getTurn() <= BattleGround.turn) {
								((Light) (Login.battle.getPlayer2())).PlayCard(i);

							} else {
								flag = false;
								JOptionPane.showMessageDialog(contentPane, "This card cannot be played this turn.");
							}
							break;
						} else if (radioButton[i].isSelected()
								&& Login.battle.getPlayer2().getName().equalsIgnoreCase("Stone")) {
							if (Login.battle.getPlayer2().getHand().getHand().get(i).getTurn() <= BattleGround.turn) {
								((Stone) (Login.battle.getPlayer2())).PlayCard(i);

							} else {
								flag = false;
								JOptionPane.showMessageDialog(contentPane, "This card cannot be played this turn.");
							}
							break;
						}
					}
					if (flag) {
						setVisible(false);
						P2Screen sv2 = new P2Screen();
						sv2.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Action Points are all used this turn.");
				}

			}
		});
		contentPane.add(btnPlayCard);

		lblHealth = new JLabel("Health/Armor : " + Login.battle.getPlayer2().getHealth() + " / "
				+ Login.battle.getPlayer2().getArmor());
		lblHealth.setBounds(465, 391, 180, 25);
		lblHealth.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		contentPane.add(lblHealth);

		lblNick = new JLabel(Login.battle.getPlayer2().getNick() + " | " + Login.battle.getPlayer2().getName());
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNick.setBounds(271, 414, 182, 25);
		contentPane.add(lblNick);

		lblDeck = new JLabel("Remaining Cards : " + Login.battle.getPlayer2().getDeck().size());
		lblDeck.setBounds(465, 418, 169, 16);
		lblDeck.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		contentPane.add(lblDeck);

		btnWeapon = new JButton("Weapon : " + Login.battle.getPlayer2().getWeapon().getDamage() + " / "
				+ Login.battle.getPlayer2().getWeapon().getDurability());
		btnWeapon.setBackground(new Color(255, 51, 51));
		btnWeapon.setBounds(131, 414, 132, 25);
		btnWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.battle.getPlayer2().getWeapon().getDurability() > 0) { // durability control
					if (Login.battle.getPlayer2().getActionPoint() > 0) { // actionpoint control
						if (!Login.battle.getPlayer2().getWeapon().isHit()) { // ishit control

							if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Axe")) {
								((Axe) (Login.battle.getPlayer2())).hit(Login.battle.getPlayer1());
							} else if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Blood")) {
								((Blood) (Login.battle.getPlayer2())).hit(Login.battle.getPlayer1());
							} else if ((Login.battle.getPlayer2().getName().equalsIgnoreCase("Light"))) {
								((Light) (Login.battle.getPlayer2())).hit(Login.battle.getPlayer1());

							} else if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Stone")) {
								((Stone) (Login.battle.getPlayer2())).hit(Login.battle.getPlayer1());
							}
							setVisible(false);
							P2Screen sv2 = new P2Screen();
							sv2.setVisible(true);
						} else
							JOptionPane.showMessageDialog(contentPane, "Weapon is used this turn.");
					} else
						JOptionPane.showMessageDialog(contentPane, "Action Points are all used this turn.");
				} else
					JOptionPane.showMessageDialog(contentPane, "Unsufficient durability.");
			}
		});
		contentPane.add(btnWeapon);

		lblEnemyHealth = new JLabel("Health/Armor : " + Login.battle.getPlayer1().getHealth() + " / "
				+ Login.battle.getPlayer1().getArmor());
		lblEnemyHealth.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblEnemyHealth.setBounds(63, 13, 180, 16);
		contentPane.add(lblEnemyHealth);

		lblEnemyWeapon = new JLabel("Weapon : " + Login.battle.getPlayer1().getWeapon().getDamage() + " / "
				+ Login.battle.getPlayer1().getWeapon().getDurability());
		lblEnemyWeapon.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblEnemyWeapon.setBounds(197, 61, 132, 16);
		contentPane.add(lblEnemyWeapon);

		lblEnemyRemainingCards = new JLabel("Remaining Cards : " + Login.battle.getPlayer1().getDeck().size());
		lblEnemyRemainingCards.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblEnemyRemainingCards.setBounds(512, 13, 180, 16);
		contentPane.add(lblEnemyRemainingCards);

		lblEnemyHand = new JLabel("Cards in Hand : " + Login.battle.getPlayer1().getHand().getHand().size());
		lblEnemyHand.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblEnemyHand.setBounds(357, 61, 169, 16);
		contentPane.add(lblEnemyHand);

		lblEnemyNick = new JLabel(Login.battle.getPlayer1().getNick() + " | " + Login.battle.getPlayer1().getName());
		lblEnemyNick.setForeground(Color.RED);
		lblEnemyNick.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnemyNick.setBounds(271, 11, 212, 37);
		contentPane.add(lblEnemyNick);

		lblTurn = new JLabel("Turn:" + BattleGround.turn);
		lblTurn.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblTurn.setBounds(601, 86, 54, 14);
		contentPane.add(lblTurn);

	}
}
