public class Card {
	private int cardId;
	private String name;
	private int value1;
	private int value2;
	private int turn;
	private String text;
	
	public Card(int cardId, String name, int turn, String text) {
		this.cardId = cardId;
		this.name = name;
		this.turn = turn;
		this.text = text;
	}
	
	public Card(int cardId, String name, int value1, int turn, String text) {
		this.cardId = cardId;
		this.name = name;
		this.value1 = value1;
		this.turn = turn;
		this.text = text;
	}
	
	public Card(int cardId, String name, Integer value1, int value2, int turn, String text) {
		this.cardId = cardId;
		this.name = name;
		this.value1=value1;
		this.value2 = value2;
		this.turn = turn;
		this.text = text;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", name=" + name + ", value1=" + value1 + ", value2=" + value2 + ", turn="
				+ turn + ", text=" + text + "]";
	}
	
	
}
