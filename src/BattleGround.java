import java.util.ArrayList;
import java.util.List;

public class BattleGround {

	public static List<Card> graveyard;
	private boolean playerTurn; // true player1, false player2
	public static int turn;
	private int tempTurn;
	private Player player1;
	private Player player2;

	public BattleGround(Player player1, Player player2) {
		graveyard = new ArrayList<Card>();
		this.player1 = player1;
		this.player2 = player2;
		whoStarts();
		turn = 1;
		selectEnemy();

		for (int i = 0; i < 5; i++) {
			player1.getHand().getHand().add(player1.getDeck().pop());
			player2.getHand().getHand().add(player2.getDeck().pop());
		}
	}

	public void whoStarts() {
		int rnd = (int) (Math.random() * 2);
		if (rnd == 0) {
			playerTurn = true;
		}
	}

	public void endTour() {
		tempTurn++;
		if (playerTurn) {
			if (turn <= 6) {
				player1.setActionPoint(2);
			} else {
				player1.setActionPoint(3);
			}
			player1.getWeapon().setHit(false);
			if (!player1.getHand().getHand().isEmpty())
				player1.getHand().getHand().add(player1.getDeck().pop());
			playerTurn = false;
		} else {
			if (turn <= 6) {
				player2.setActionPoint(2);
			} else {
				player2.setActionPoint(3);
			}
			player2.getWeapon().setHit(false);
			if (!player2.getHand().getHand().isEmpty())
				player2.getHand().getHand().add(player2.getDeck().pop());
			playerTurn = true;
		}

		if (tempTurn % 2 == 0)
			turn++;

	}

	public void selectEnemy() {
		player1.setThisplayer(player1);
		player1.setEnemy(player2);
		player2.setThisplayer(player2);
		player2.setEnemy(player1);
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public boolean isPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

}
