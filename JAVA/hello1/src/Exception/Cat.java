package Exception;

public class Cat {
	public void feed(String food) throws CatException {
		if (!food.equals("사료")) {
			throw new CatException("고양이가 " + food + "를 싫어합니다.");
		}
		System.out.println("고양이가 " + food + "를 맛있게 먹습니다.");
	}
}