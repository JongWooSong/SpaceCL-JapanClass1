package chapter12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("A", "안녕하세요?");
		map.put("BB", "저의 이름은 비비탄 입니다.");
		
		System.out.println( map.get("BB") );
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String val = map.get(key);
			System.out.println("key:" + key + ", val:" + val);
		}
	}

}
