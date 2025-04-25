package rpg;

public class Character {
	private String name;
	private int hp;
	private int attack;
	private String race;

	// 생성자
	public Character(String name, int hp, int attack, String race) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.race = race;
	}

	// 캐릭터 정보 출력 
	public void info() {
		System.out.println("이름: " + name);
		System.out.println("체력: " + hp);
		System.out.println("공격력: " + attack);
		System.out.println("종족: " + race);
	}
}




