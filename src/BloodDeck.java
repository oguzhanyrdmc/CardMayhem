
public class BloodDeck extends Deck {

	public BloodDeck(Player player,Player enemy) {
		super(player, enemy);

		generateLightsCure();
		generateAxesHealingSalve();
		generateStonesFaith();
		generateBloodsPact();
		generateAxesAnvil();
		generateStonesAnvil();
		generateLightsAnvil();
		generateBloodsAnvil();
		generateBloodsShield();
		generateLightsShield();
		generateStonesShield();
		generateAxesShield();
		generateBloodsSpell();
		generateAxesSpell();
		generateLightsSpell();
		generateStonesSpell();
		generateDarkPact();
		generateAwakenDead();
		generateDevilsFortune();
		generateVoidPact();
		generateBloodBath();
		generateRedAura();
		generateWildPoison();
		generateDodge();
		generateAmuletsGeis();
		generateEmptyVeins();
		generateDarkTerror();
		generateDevilsAce();
		generateParalyze();
		generateDelusion();

	}

	public void effect(int index) {
		switch (index) {
		case 1:
			lightCure(index);
			break;
		case 2:
			axesHealingSalve(index);
			break;
		case 3:
			stonesFaith(index);
			break;
		case 4:
			bloodsPact(index);
			break;
		case 5:
			axesAnvil(index);
			break;
		case 6:
			stonesAnvil(index);
			break;
		case 7:
			lightsAnvil(index);
			break;
		case 8:
			bloodAnvil(index);
			break;
		case 9:
			bloodsShield(index);
			break;
		case 10:
			lightsShield(index);
			break;
		case 11:
			stonesShield(index);
			break;
		case 12:
			axesShield(index);
			break;
		case 13:
			bloodsSpell(index);
			break;
		case 14:
			axesSpell(index);
			break;
		case 15:
			lightsSpell(index);
			break;
		case 16:
			stonesSpell(index);
			break;
		case 17:
			darkPact(index);
			break;
		case 18:
			awakenDead(index);
			break;
		case 19:
			devilsFortune(index);
			break;
		case 20:
			voidPact(index);
			break;
		case 51:
			bloodBath(index);
			break;
		case 52:
			redAura(index);
			break;
		case 53:
			wildPoison(index);
			break;
		case 54:
			dodge(index);
			break;
		case 55:
			amuletsGeis(index);
			break;
		case 56:
			emptyVeins(index);
			break;
		case 57:
			darkTerror(index);
			break;
		case 58:
			devilsAce(index);
			break;
		case 59:
			paralyze(index);
			break;
		case 60:
			delusion(index);
			break;
		}

	}

	@Override
	public void bloodsPact(int index) {
		if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue1() - enemy.getArmor()*cardList.get(index).getValue1()/100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
	}
	@Override
	public void bloodAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue1());
		player.getWeapon().setDurability(player.getWeapon().getDurability() + cardList.get(index).getValue2() );
	}
	@Override
	public void bloodsShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue2());
	}
	@Override
	public void bloodsSpell(int index) {
		enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue2() - enemy.getArmor()*cardList.get(index).getValue2()/100));
		enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue2());
	}
	
	public void generateBloodBath() {
		cardList.add(new Card(51, "Blood Bath", 10, 3, "Take your opponent's 10 Health to restore yours."));
	}

	public void bloodBath(int index) {
		enemy.setHealth(enemy.getHealth()-cardList.get(index).getValue1());
		if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+cardList.get(index).getValue1());
	}

	public void generateRedAura() {
		cardList.add(new Card(52, "Red Aura", 10, 20, 4, "Convert your 10 health to 20 armor. Master: 30 instead."));
	}

	public void redAura(int index) {
		player.setHealth(player.getHealth() - cardList.get(index).getValue1());
		if (BattleGround.turn >= 6)
			player.setArmor(player.getArmor() + cardList.get(index).getValue2());
		else
			player.setArmor(player.getArmor() + cardList.get(index).getValue2()+10);
	}

	public void generateWildPoison() {
		cardList.add(new Card(53, "Wild Poison", 1, 5, "Add 1 Attack to your weapon for each card in your hand."));
	}

	public void wildPoison(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage()+(cardList.get(index).getValue1()*player.getHand().getHand().size()));
	}

	public void generateDodge() {
		cardList.add(new Card(54, "Dodge",10,50, 6, "If your health is below 10, gain 50 armor."));
	}

	public void dodge(int index) {
		if (player.getHealth() < cardList.get(index).getValue1())
			player.setArmor(player.getArmor()+cardList.get(index).getValue2());
	}

	public void generateAmuletsGeis() {
		cardList.add(new Card(55, "Amulet's Geis", 4, 2, "Add 4 Attack to your weapon."));
	}

	public void amuletsGeis(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue1());
	}

	public void generateEmptyVeins() {
		cardList.add(new Card(56, "Empty Veins", 7, "Add attack to your weapon equal to %50 your lost health."));
	}

	public void emptyVeins(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage()+((player.getMAXHEALTH()-player.getHealth())/2));
	}

	public void generateDarkTerror() {
		cardList.add(new Card(57, "Dark Terror", 8, "Deal damage twice as your weapon' damage. Stable: Thrice instead."));
	}

	public void darkTerror(int index) {
		enemy.setHealth(enemy.getHealth() - (player.getWeapon().getDamage()*2 - enemy.getArmor()*player.getWeapon().getDamage()*2/100));
		enemy.setArmor(enemy.getArmor() - player.getWeapon().getDamage()*2);
	}

	public void generateDevilsAce() {
		cardList.add(new Card(58, "Devil's Ace", 1, "Draw a card."));
	}

	public void devilsAce(int index) {
		player.getHand().draw(player.getDeck());
	}

	public void generateParalyze() {
		cardList.add(new Card(59, "Paralyze", 8, "Reduce %25 of your opponent's armor. Focus: %50 instead."));
	}

	public void paralyze(int index) {
		if (player.getHand().getHand().size() < 5)
		enemy.setArmor(enemy.getArmor()-(enemy.getArmor()*25/100));
	}

	public void generateDelusion() {
		cardList.add(new Card(29, "Delusion", 10, "Swap health with your opponent."));
	}

	public void delusion(int index) {
		int temp = player.getHealth();
		player.setHealth(enemy.getHealth());
		enemy.setHealth(temp);
	}


}
