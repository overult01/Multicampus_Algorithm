package ch1;
// 다중루프
public class Multi99table {

	public static void main(String[] args) {

		System.out.println("====곱셈표====");
		
		
		for (int i = 1; i < 10; i++) {
			System.out.println();
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			}
		}
	}

}