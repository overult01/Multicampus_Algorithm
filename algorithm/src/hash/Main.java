package hash;

public class Main {

	public static void main(String[] args) {

		ChainHash<Integer, String> ch = new ChainHash(13);
		int result = ch.add(1, "삼성컴퓨터"); // key, value주면 노드로 반환. 결과는 int로 리턴된다.
		System.out.println(result);
		// 동일 키가 저장되려고 하는 경우.
		result = ch.add(1, "lg노트북"); // 같은 키가 있어서 무시된다.(return 1) 
		System.out.println(result);
		// 동일 해시값이 저장되려고 하는 경우.
		result = ch.add(14, "애플맥북"); // key, value주면 노드로 반환. 결과는 int로 리턴된다.
		System.out.println(result); // 0이 나온 것은 저장이 됐다는 뜻.

		result = ch.add(27, "캐논프린터"); // key, value주면 노드로 반환. 결과는 int로 리턴된다.
		System.out.println(result); // 0이 나온 것은 저장이 됐다는 뜻.

//		result = ch.add(3, "삼성맥북"); // 같은 키를 가진value를 덮어씌움.(아직 체이닝이 안되어서) 
//		System.out.println(result); 
//
//		result = ch.add(14, "삼성프린터"); // 같은 키를 가진value를 덮어씌움.(아직 체이닝이 안되어서) 
//		System.out.println(result); 

		ch.remove(14);
		ch.dump();

		System.out.println(ch.search(14));
		System.out.println(ch.search(1));

	}

}


/*
 * HashMap처럼 데이터를 키(key)와 값(value)의 형태로 저장하는 컬렉션 클래스는 지정해줘야 할 타입이 두 개이다. 그래서<K.V>와 같이 두 개의 타입을 콤마 ','로 구분해서 적어줘야한다. 여기서 'K'와 'V'는 각각 'Key'와 'Value'의 첫 글자에서 따온 것일 뿐 'T'나 'E'와 마찬가지로 참조형 타입(reference type)을 의미한다.
 * */


/*
 * 
 * <new ChainHash(13); 수행결과>
00  
01  → 1 (삼성컴퓨터)  
02  → 2 (lg노트북)  
03  → 3 (애플맥북)  
04  
05  
06  
07  
08  
09  
10  
11  
12  
 * 
 * 
 * */
