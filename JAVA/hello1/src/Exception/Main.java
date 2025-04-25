package Exception;

public class Main {

	public static void main(String[] args) {
		Cat cat = new Cat();
		try {
			cat.feed("사료");
			System.out.println(1);
			System.out.println(2);
			cat.feed("멸치");
		} catch (CatException e1) {
			e1.printStackTrace();
		}
	}

}
