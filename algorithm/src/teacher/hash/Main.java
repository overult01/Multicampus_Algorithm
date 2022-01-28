package hash;

public class Main {

	public static void main(String[] args) {
		ChainHash<Integer, String> ch = new ChainHash(13);
		int result = ch.add(1, "삼성컴퓨터"); // 1%13=>1
		System.out.println(result);
		result = ch.add(1, "lg노트북"); // 1리턴. add 무시
		System.out.println(result);
		result = ch.add(14, "애플맥북");//삽입. next<=table[1] 0리턴
		System.out.println(result);
		result = ch.add(27, "캐논프린터");
		System.out.println(result);
	
		ch.remove(14);
		ch.dump();
		
		System.out.println(ch.search(14));
		System.out.println(ch.search(1));
	}

}
