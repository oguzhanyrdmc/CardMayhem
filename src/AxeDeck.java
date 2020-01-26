
public class AxeDeck extends Deck {

	public AxeDeck(Player player,Player enemy) {
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
		generateSharpenedEdge();
		generateBlacksmithsFavor();
		generateHardenedSkin();
		generateBloodFrenzy();
		generateUnarmTheWeak();
		generateTakesTheHeart();
		generateGoForTheHead();
		generateColdBlood();
		generateParry();
		generateCrumble();
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
		case 41:
			sharpenedEdge(index);
			break;
		case 42:
			blacksmithsFavor(index);
			break;
		case 43:
			hardenedSkin(index);
			break;
		case 44:
			bloodFrenzy(index);
			break;
		case 45:
			unarmTheWeak(index);
			break;
		case 46:
			takesTheHeart(index);
			break;
		case 47:
			goForTheHead(index);
			break;
		case 48:
			coldBlood(index);
			break;
		case 49:
			parry(index);
			break;
		case 50:
			crumble(index);
			break;
		}

	}

	@Override
	public void axesHealingSalve(int index) {
		if (player.getHealth()+cardList.get(index).getValue1() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+cardList.get(index).getValue1());
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue2());
	}

	@Override
	public void axesAnvil(int index) {
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue2());
	}

	@Override
	public void axesShield(int index) {
		player.setArmor(player.getArmor() + cardList.get(index).getValue1());
		player.getWeapon().setDamage(player.getWeapon().getDamage() + cardList.get(index).getValue2());
	}

	@Override
	public void axesSpell(int index) {
		enemy.setHealth(enemy.getHealth() - (player.getWeapon().getDamage() / 2 - enemy.getArmor()*cardList.get(index).getValue1()/100));
		enemy.setArmor(enemy.getArmor() - player.getWeapon().getDamage() / 2);
	}

	public void generateSharpenedEdge() {
		cardList.add(new Card(41, "Sharpened Edge", 3, 5, 1,"Add 3 Attack to your weapon. Master: 5 instead"));
	}

	public void sharpenedEdge(int index) {
		if (BattleGround.turn >= 6)
			player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue2());
		else	
			player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue1());
	}

	public void generateBlacksmithsFavor() {
		cardList.add(new Card(42, "Blacksmith's Favor", 2, 4,"Add 2 Durability to your weapon."));
	}

	public void blacksmithsFavor(int index) {
		player.getWeapon().setDurability(player.getWeapon().getDurability()+cardList.get(index).getValue1());
	}

	public void generateHardenedSkin() {
		cardList.add(new Card(43, "Hardened Skin", 10, 15, 2,"Gain 10 armor. Master:15 instead."));
	}

	public void hardenedSkin(int index) {
		if (BattleGround.turn >= 6)
			player.setArmor(player.getArmor()+cardList.get(index).getValue2());
		else
			player.setArmor(player.getArmor()+cardList.get(index).getValue1());
	}

	public void generateBloodFrenzy() {
		cardList.add(new Card(44, "Blood Frenzy", 20, 5, 5,"Lose 20 Health to add 5 Attack tou your weapon."));
	}

	public void bloodFrenzy(int index) {
		player.setHealth(player.getHealth()-cardList.get(index).getValue1());
		player.getWeapon().setDamage(player.getWeapon().getDamage()+cardList.get(index).getValue2());
	}

	public void generateUnarmTheWeak() {
		cardList.add(new Card(45, "Unarm the Weak", 2, 3,"Reduce opponent's weapon durability by 2."));
	}

	public void unarmTheWeak(int index) {
		enemy.getWeapon().setDurability(enemy.getWeapon().getDurability()-cardList.get(index).getValue1());
	}

	public void generateTakesTheHeart() {
		cardList.add(new Card(46, "Takes the Heart", 6,"Gain armor twice as your weapon's attack."));
	}

	public void takesTheHeart(int index) {
		player.setArmor(player.getArmor()+player.getWeapon().getDamage()*2);
	}

	public void generateGoForTheHead() {
		cardList.add(new Card(47, "Go for the Head", 10, 15, 7, "Deal 10 damage ignoring armor. Focus: 15 instead."));
	}

	public void goForTheHead(int index) {
		if (player.getHand().getHand().size() <= 5 ) {
			enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue2() - enemy.getArmor()*cardList.get(index).getValue2()/100));
			enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue2());
		}
		else {
			enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue1() - enemy.getArmor()*cardList.get(index).getValue1()/100));
			enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
		}
	}

	public void generateColdBlood() {
		cardList.add(new Card(48, "Cold Blood", 8, "Restore Health equal to your weapon's attack"));
	}

	public void coldBlood(int index) {
		if (player.getHealth()+player.getWeapon().getDamage() > player.getMAXHEALTH())		
			player.setHealth(player.getMAXHEALTH());
		else
			player.setHealth(player.getHealth()+player.getWeapon().getDamage());
	}

	public void generateParry() {
		cardList.add(new Card(49, "Parry", 8,"Double your armor."));
	}

	public void parry(int index) {
		player.setArmor(player.getArmor()*2);
	}

	public void generateCrumble() {
		cardList.add(new Card(50, "Crumble!", 50, 10,"If your opponent is Stone,Deal 50 Damage."));
	}

	public void crumble(int index) {
		if(enemy.getName().equals("Stone")) {
			enemy.setHealth(enemy.getHealth() - (cardList.get(index).getValue1() - enemy.getArmor()*cardList.get(index).getValue1()/100));
			enemy.setArmor(enemy.getArmor() - cardList.get(index).getValue1());
		}
	}

}
