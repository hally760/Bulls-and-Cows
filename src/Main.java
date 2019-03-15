import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sNum[] = {0,0,0,0};
		int gNum[] = new int[4];
		sNum = randomisingNumbers(sNum);
		gNum = userInp(gNum);
	}
	
	public static int[] randomisingNumbers(int[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			boolean found = true;
			int num = 0;
			while (found) {
				found = false;
				num = r.nextInt(9) + 1;
				for (int j = 0; j < array.length; j ++) {
					if (num == array[j]) {
						found = true;
					}
				}
			}
			array[i] = num;
		}
		return array;
	}
	
	public static int[] userInp(int[] array) {
		
		
		
		return array;
	}

}
