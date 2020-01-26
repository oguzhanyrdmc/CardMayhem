public class Weapon {
	private int damage;
	private int durability;
	private boolean hit;

	public Weapon(int damage, int durability) {

		this.damage = damage;
		this.durability = durability;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

}