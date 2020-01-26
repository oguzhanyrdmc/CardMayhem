import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Table extends JFrame {

	private JPanel contentPane;
	private JLabel lblId;
	private JButton btnSearch;

	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JTableHeader header;
	private JTextField txtID;
	private JLabel lblSearch;

	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 100, 899, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		setTitle("CardPool");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblId = new JLabel("ID:");
		lblId.setBounds(26, 54, 24, 14);
		contentPane.add(lblId);

		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(240, 248, 255));
		btnSearch.setBackground(new Color(72, 61, 139));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int j = 0; j < model.getRowCount(); j++) {
					if (model.getValueAt(j, 0).equals(txtID.getText())) {

						lblSearch.setText("Id:"+model.getValueAt(j, 0).toString() 
								+ "    :" + model.getValueAt(j, 1).toString()
								+ "    :" + model.getValueAt(j, 2).toString() 
								+ "    :" + model.getValueAt(j, 3).toString()
								+ "    :" + model.getValueAt(j, 4).toString());

					}
				}
				
			}
		});
		btnSearch.setBounds(350, 37, 95, 48);
		contentPane.add(btnSearch);

		panel = new JPanel();
		panel.setBounds(26, 171, 830, 408);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 831, 395);
		panel.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollPane.setViewportView(table);

		header = table.getTableHeader();
		header.setBackground(Color.yellow);
		panel.setLayout(null);

		getContentPane().add(panel);

		String col[] = { "Id", "Name", "Type", "Turn", "Text" };

		model = new DefaultTableModel(col, 0);

		if (Login.battle.getPlayer1().getName().equalsIgnoreCase("Axe")) {
			for (int i = 0; i < ((Axe) (Login.battle.getPlayer1())).getAxedeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Axe) (Login.battle.getPlayer1())).getAxedeck().getCardList().get(i).getCardId())),
						((Axe) (Login.battle.getPlayer1())).getAxedeck().getCardList().get(i).getName(), "Axe",
						(Integer.toString(
								((Axe) (Login.battle.getPlayer1())).getAxedeck().getCardList().get(i).getTurn())),
						((Axe) (Login.battle.getPlayer1())).getAxedeck().getCardList().get(i).getText() };
				model.addRow(row);
			}
		} else if (Login.battle.getPlayer1().getName().equalsIgnoreCase("Stone")) {
			for (int i = 0; i < ((Stone) (Login.battle.getPlayer1())).getStoneDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Stone) (Login.battle.getPlayer1())).getStoneDeck().getCardList().get(i).getCardId())),
						((Stone) (Login.battle.getPlayer1())).getStoneDeck().getCardList().get(i).getName(), "Stone",
						(Integer.toString(
								((Stone) (Login.battle.getPlayer1())).getStoneDeck().getCardList().get(i).getTurn())),
						((Stone) (Login.battle.getPlayer1())).getStoneDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		} else if (Login.battle.getPlayer1().getName().equalsIgnoreCase("Blood")) {
			for (int i = 0; i < ((Blood) (Login.battle.getPlayer1())).getBloodDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Blood) (Login.battle.getPlayer1())).getBloodDeck().getCardList().get(i).getCardId())),
						((Blood) (Login.battle.getPlayer1())).getBloodDeck().getCardList().get(i).getName(), "Blood",
						(Integer.toString(
								((Blood) (Login.battle.getPlayer1())).getBloodDeck().getCardList().get(i).getTurn())),
						((Blood) (Login.battle.getPlayer1())).getBloodDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		} else if (Login.battle.getPlayer1().getName().equalsIgnoreCase("Light")) {
			for (int i = 0; i < ((Light) (Login.battle.getPlayer1())).getLightDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Light) (Login.battle.getPlayer1())).getLightDeck().getCardList().get(i).getCardId())),
						((Light) (Login.battle.getPlayer1())).getLightDeck().getCardList().get(i).getName(), "Light",
						(Integer.toString(
								((Light) (Login.battle.getPlayer1())).getLightDeck().getCardList().get(i).getTurn())),
						((Light) (Login.battle.getPlayer1())).getLightDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		}

		if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Axe")) {
			for (int i = 0; i < ((Axe) (Login.battle.getPlayer2())).getAxedeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Axe) (Login.battle.getPlayer2())).getAxedeck().getCardList().get(i).getCardId())),
						((Axe) (Login.battle.getPlayer2())).getAxedeck().getCardList().get(i).getName(), "Axe",
						(Integer.toString(
								((Axe) (Login.battle.getPlayer2())).getAxedeck().getCardList().get(i).getTurn())),
						((Axe) (Login.battle.getPlayer2())).getAxedeck().getCardList().get(i).getText() };
				model.addRow(row);
			}
		} else if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Stone")) {
			for (int i = 0; i < ((Stone) (Login.battle.getPlayer2())).getStoneDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Stone) (Login.battle.getPlayer2())).getStoneDeck().getCardList().get(i).getCardId())),
						((Stone) (Login.battle.getPlayer2())).getStoneDeck().getCardList().get(i).getName(), "Stone",
						(Integer.toString(
								((Stone) (Login.battle.getPlayer2())).getStoneDeck().getCardList().get(i).getTurn())),
						((Stone) (Login.battle.getPlayer2())).getStoneDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		} else if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Blood")) {
			for (int i = 0; i < ((Blood) (Login.battle.getPlayer2())).getBloodDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Blood) (Login.battle.getPlayer2())).getBloodDeck().getCardList().get(i).getCardId())),
						((Blood) (Login.battle.getPlayer2())).getBloodDeck().getCardList().get(i).getName(), "Blood",
						(Integer.toString(
								((Blood) (Login.battle.getPlayer2())).getBloodDeck().getCardList().get(i).getTurn())),
						((Blood) (Login.battle.getPlayer2())).getBloodDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		} else if (Login.battle.getPlayer2().getName().equalsIgnoreCase("Light")) {
			for (int i = 0; i < ((Light) (Login.battle.getPlayer2())).getLightDeck().getCardList().size(); i++) {
				String[] row = {
						(Integer.toString(
								((Light) (Login.battle.getPlayer2())).getLightDeck().getCardList().get(i).getCardId())),
						((Light) (Login.battle.getPlayer2())).getLightDeck().getCardList().get(i).getName(), "Light",
						(Integer.toString(
								((Light) (Login.battle.getPlayer2())).getLightDeck().getCardList().get(i).getTurn())),
						((Light) (Login.battle.getPlayer2())).getLightDeck().getCardList().get(i).getText() };
				model.addRow(row);
			}

		}

		table.setModel(model);

		txtID = new JTextField();
		txtID.setBounds(74, 50, 173, 22);
		contentPane.add(txtID);

		lblSearch = new JLabel("Non Search!");
		lblSearch.setForeground(new Color(255, 255, 0));
		lblSearch.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 13));
		lblSearch.setBounds(26, 120, 830, 22);
		contentPane.add(lblSearch);

	}
}