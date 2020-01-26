import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNickP1;
	private JLabel lblPlayer1;
	private JRadioButton rdbtnAxeP1;
	private JRadioButton rdbtnStoneP1;
	private JRadioButton rdbtnBloodP1;
	private JRadioButton rdbtnLightP1;
	private JCheckBox chckbxReadyP1;
	private JRadioButton rdbtnAxeP2;
	private JLabel lblPlayerP2;
	private JRadioButton rdbtnBloodP2;
	private JRadioButton rdbtnLightP2;
	private JRadioButton rdbtnStoneP2;
	private JCheckBox chckbxReadyP2;
	private JTextField txtNickP2;
	private ButtonGroup btnGP1;
	private ButtonGroup btnGP2;
	private Axe axe1;
	private Light light1;
	private Stone stone1;
	private Blood blood1;
	private Axe axe2;
	private Light light2;
	private Stone stone2;
	private Blood blood2;
	private JButton btnStartGame;
	public static BattleGround battle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		//2015510122 FATMA KAHRAMAN
		//2015510066 OÐUZHAN YARDIMCI
		//2016510028 AHMET TALAT GEDÝKLÝ
		//2016510106 GAYE EROL
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 334);
		setTitle("Login");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPlayer1 = new JLabel("Player1:");
		lblPlayer1.setBounds(12, 108, 56, 16);
		contentPane.add(lblPlayer1);

		rdbtnAxeP1 = new JRadioButton("Axe");
		rdbtnAxeP1.setBackground(new Color(102, 205, 170));
		rdbtnAxeP1.setBounds(12, 148, 81, 25);
		contentPane.add(rdbtnAxeP1);

		rdbtnStoneP1 = new JRadioButton("Stone");
		rdbtnStoneP1.setBackground(new Color(128, 128, 128));
		rdbtnStoneP1.setBounds(12, 178, 81, 25);
		contentPane.add(rdbtnStoneP1);

		rdbtnBloodP1 = new JRadioButton("Blood");
		rdbtnBloodP1.setBackground(new Color(255, 69, 0));
		rdbtnBloodP1.setBounds(97, 148, 86, 25);
		contentPane.add(rdbtnBloodP1);

		rdbtnLightP1 = new JRadioButton("Light");
		rdbtnLightP1.setBackground(new Color(245, 255, 250));
		rdbtnLightP1.setBounds(97, 178, 86, 25);
		contentPane.add(rdbtnLightP1);

		txtNickP1 = new JTextField();
		txtNickP1.setBounds(67, 105, 116, 22);
		contentPane.add(txtNickP1);
		txtNickP1.setColumns(10);

		chckbxReadyP1 = new JCheckBox("Ready!");
		chckbxReadyP1.setBackground(new Color(238, 130, 238));
		chckbxReadyP1.setBounds(56, 207, 80, 25);
		contentPane.add(chckbxReadyP1);

		lblPlayerP2 = new JLabel("Player 2");
		lblPlayerP2.setBounds(222, 109, 46, 14);
		contentPane.add(lblPlayerP2);

		rdbtnAxeP2 = new JRadioButton("Axe");
		rdbtnAxeP2.setBounds(222, 149, 81, 23);
		rdbtnAxeP2.setBackground(new Color(102, 205, 170));
		contentPane.add(rdbtnAxeP2);

		rdbtnBloodP2 = new JRadioButton("Blood");
		rdbtnBloodP2.setBounds(307, 149, 89, 23);
		rdbtnBloodP2.setBackground(new Color(255, 69, 0));
		contentPane.add(rdbtnBloodP2);

		rdbtnLightP2 = new JRadioButton("Light");
		rdbtnLightP2.setBounds(307, 179, 89, 23);
		rdbtnLightP2.setBackground(new Color(245, 255, 250));
		contentPane.add(rdbtnLightP2);

		rdbtnStoneP2 = new JRadioButton("Stone");
		rdbtnStoneP2.setBounds(222, 179, 81, 23);
		rdbtnStoneP2.setBackground(new Color(128, 128, 128));
		contentPane.add(rdbtnStoneP2);

		chckbxReadyP2 = new JCheckBox("Ready!");
		chckbxReadyP2.setBackground(new Color(238, 130, 238));
		chckbxReadyP2.setBounds(265, 208, 80, 23);
		contentPane.add(chckbxReadyP2);

		txtNickP2 = new JTextField();
		txtNickP2.setColumns(10);
		txtNickP2.setBounds(280, 105, 116, 22);
		contentPane.add(txtNickP2);

		btnGP1 = new ButtonGroup();
		btnGP1.add(rdbtnAxeP1);
		btnGP1.add(rdbtnBloodP1);
		btnGP1.add(rdbtnLightP1);
		btnGP1.add(rdbtnStoneP1);

		btnGP2 = new ButtonGroup();
		btnGP2.add(rdbtnAxeP2);
		btnGP2.add(rdbtnBloodP2);
		btnGP2.add(rdbtnLightP2);
		btnGP2.add(rdbtnStoneP2);

		btnStartGame = new JButton("START GAME");
		btnStartGame.setBackground(new Color(51, 255, 153));
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxReadyP1.isSelected() || !chckbxReadyP2.isSelected()) {
					JOptionPane.showMessageDialog(contentPane, "Please check the Ready Box!");
				} else if (txtNickP1.getText().equals("") || txtNickP2.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please enter the nick name!");
				} else if (rdbtnAxeP1.isSelected() && rdbtnAxeP2.isSelected()) {
					axe1 = new Axe(txtNickP1.getText());
					axe2 = new Axe(txtNickP2.getText());
					axe1.getAxedeck().setPlayer(axe1);
					axe1.getAxedeck().setEnemy(axe2);
					axe2.getAxedeck().setPlayer(axe2);
					axe2.getAxedeck().setEnemy(blood2);
					battle = new BattleGround(axe1, axe2);
				} 
				else if (rdbtnAxeP1.isSelected() && rdbtnBloodP2.isSelected()) {
					axe1 = new Axe(txtNickP1.getText());
					blood2 = new Blood(txtNickP2.getText());
					axe1.getAxedeck().setPlayer(axe1);
					axe1.getAxedeck().setEnemy(blood2);
					blood2.getBloodDeck().setPlayer(blood2);
					blood2.getBloodDeck().setEnemy(axe1);
					battle = new BattleGround(axe1, blood2);
				} 
				else if (rdbtnAxeP1.isSelected() && rdbtnLightP2.isSelected()) {
					axe1 = new Axe(txtNickP1.getText());
					light2 = new Light(txtNickP2.getText());
					axe1.getAxedeck().setPlayer(axe1);
					axe1.getAxedeck().setEnemy(light2);
					light2.getLightDeck().setPlayer(light2);
					light2.getLightDeck().setEnemy(axe1);
					battle = new BattleGround(axe1, light2);
				} 
				else if (rdbtnAxeP1.isSelected() && rdbtnStoneP2.isSelected()) {
					axe1 = new Axe(txtNickP1.getText());
					stone2 = new Stone(txtNickP2.getText());
					axe1.getAxedeck().setPlayer(axe1);
					axe1.getAxedeck().setEnemy(stone2);
					stone2.getStoneDeck().setPlayer(stone2);
					stone2.getStoneDeck().setEnemy(axe1);
					battle = new BattleGround(axe1, stone2);
				} 
				else if (rdbtnBloodP1.isSelected() && rdbtnAxeP2.isSelected()) {
					blood1 = new Blood(txtNickP1.getText());
					axe2 = new Axe(txtNickP2.getText());
					blood1.getBloodDeck().setPlayer(blood1);
					blood1.getBloodDeck().setEnemy(axe2);
					axe2.getAxedeck().setPlayer(axe2);
					axe2.getAxedeck().setEnemy(blood1);
					battle = new BattleGround(blood1, axe2);
				} 
				else if (rdbtnBloodP1.isSelected() && rdbtnBloodP2.isSelected()) {
					blood1 = new Blood(txtNickP1.getText());
					blood2 = new Blood(txtNickP2.getText());
					blood1.getBloodDeck().setPlayer(blood1);
					blood1.getBloodDeck().setEnemy(blood2);
					blood2.getBloodDeck().setPlayer(blood2);
					blood2.getBloodDeck().setEnemy(blood1);
					battle = new BattleGround(blood1, blood2);
				} 
				else if (rdbtnBloodP1.isSelected() && rdbtnLightP2.isSelected()) {
					blood1 = new Blood(txtNickP1.getText());
					light2 = new Light(txtNickP2.getText());
					blood1.getBloodDeck().setPlayer(blood1);
					blood1.getBloodDeck().setEnemy(light2);
					light2.getLightDeck().setPlayer(light2);
					light2.getLightDeck().setEnemy(blood1);
					battle = new BattleGround(blood1, light2);
				} 
				else if (rdbtnBloodP1.isSelected() && rdbtnStoneP2.isSelected()) {
					blood1 = new Blood(txtNickP1.getText());
					stone2 = new Stone(txtNickP2.getText());
					blood1.getBloodDeck().setPlayer(blood1);
					blood1.getBloodDeck().setEnemy(stone2);
					stone2.getStoneDeck().setPlayer(stone2);
					stone2.getStoneDeck().setEnemy(blood1);
					battle = new BattleGround(blood1, stone2);
				} 
				else if (rdbtnLightP1.isSelected() && rdbtnAxeP2.isSelected()) {
					light1 = new Light(txtNickP1.getText());
					axe2 = new Axe(txtNickP2.getText());
					light1.getLightDeck().setPlayer(light1);
					light1.getLightDeck().setEnemy(axe2);
					axe2.getAxedeck().setPlayer(axe2);
					axe2.getAxedeck().setEnemy(light1);
					battle = new BattleGround(light1, axe2);
				} 
				else if (rdbtnLightP1.isSelected() && rdbtnLightP2.isSelected()) {
					light1 = new Light(txtNickP1.getText());
					light2 = new Light(txtNickP2.getText());
					light1.getLightDeck().setPlayer(light1);
					light1.getLightDeck().setEnemy(light2);
					light2.getLightDeck().setPlayer(light2);
					light2.getLightDeck().setEnemy(light1);
					battle = new BattleGround(light1, light2);
				} 
				else if (rdbtnLightP1.isSelected() && rdbtnStoneP2.isSelected()) {
					light1 = new Light(txtNickP1.getText());
					stone2 = new Stone(txtNickP2.getText());
					light1.getLightDeck().setPlayer(light1);
					light1.getLightDeck().setEnemy(stone2);
					stone2.getStoneDeck().setPlayer(stone2);
					stone2.getStoneDeck().setEnemy(light1);
					battle = new BattleGround(light1, stone2);
				} 
				else if (rdbtnLightP1.isSelected() && rdbtnBloodP2.isSelected()) {
					light1 = new Light(txtNickP1.getText());
					blood2 = new Blood(txtNickP2.getText());
					light1.getLightDeck().setPlayer(light1);
					light1.getLightDeck().setEnemy(blood2);
					blood2.getBloodDeck().setPlayer(blood2);
					blood2.getBloodDeck().setEnemy(light1);
					battle = new BattleGround(light1, blood2);
				} 
				else if (rdbtnStoneP1.isSelected() && rdbtnAxeP2.isSelected()) {
					stone1 = new Stone(txtNickP1.getText());
					axe2 = new Axe(txtNickP2.getText());
					stone1.getStoneDeck().setPlayer(stone1);
					stone1.getStoneDeck().setEnemy(axe2);
					axe2.getAxedeck().setPlayer(axe2);
					axe2.getAxedeck().setEnemy(stone1);
					battle = new BattleGround(stone1, axe2);
				} 
				else if (rdbtnStoneP1.isSelected() && rdbtnBloodP2.isSelected()) {
					stone1 = new Stone(txtNickP1.getText());
					blood2 = new Blood(txtNickP2.getText());
					stone1.getStoneDeck().setPlayer(stone1);
					stone1.getStoneDeck().setEnemy(blood2);
					blood2.getBloodDeck().setPlayer(blood2);
					blood2.getBloodDeck().setEnemy(stone1);
					battle = new BattleGround(stone1, blood2);
				} 
				else if (rdbtnStoneP1.isSelected() && rdbtnLightP2.isSelected()) {
					stone1 = new Stone(txtNickP1.getText());
					light2 = new Light(txtNickP2.getText());
					stone1.getStoneDeck().setPlayer(stone1);
					stone1.getStoneDeck().setEnemy(light2);
					light2.getLightDeck().setPlayer(light2);
					light2.getLightDeck().setEnemy(stone1);
					battle = new BattleGround(stone1, light2);
				} 
				else {
					stone1 = new Stone(txtNickP1.getText());
					stone2 = new Stone(txtNickP2.getText());
					stone1.getStoneDeck().setPlayer(stone1);
					stone1.getStoneDeck().setEnemy(stone2);
					stone2.getStoneDeck().setPlayer(stone2);
					stone2.getStoneDeck().setEnemy(stone1);
					battle = new BattleGround(stone1, stone2);
				}
				
				if(chckbxReadyP1.isSelected() && chckbxReadyP2.isSelected() && !txtNickP1.getText().equals("") && !txtNickP2.getText().equals("")) {
					setVisible(false);
					if (battle.isPlayerTurn()) {
						P1Screen sv1 = new P1Screen();
						sv1.setVisible(true);
					} else {
						P2Screen sv2 = new P2Screen();
						sv2.setVisible(true);
					}

					Table window = new Table();
					window.setVisible(true);
				}
				

			}
		});
		// btnStartGame.setBackground(Color.RED);
		// btnStartGame.setForeground(Color.BLUE);
		btnStartGame.setBounds(153, 249, 142, 25);
		contentPane.add(btnStartGame);

		JLabel lblWelcomeToCardmayhem = new JLabel("      --  CardMayhem!  --");
		lblWelcomeToCardmayhem.setFont(new Font("Ink Free", Font.BOLD, 28));
		lblWelcomeToCardmayhem.setForeground(new Color(220, 20, 60));
		lblWelcomeToCardmayhem.setBounds(30, 4, 366, 91);
		contentPane.add(lblWelcomeToCardmayhem);
	}
}
