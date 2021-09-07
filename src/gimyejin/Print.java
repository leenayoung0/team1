package gimyejin;

import java.util.HashMap;

public class Print {
	public void cut(HashMap<String, String> useprint) {
		System.out.println("[아이템 상세 설명]");
		String i="";
		for(String key : useprint.keySet()) {
			i = useprint.get(key);
			int finalIndex = i.indexOf(".",0)+2;
			i = i.substring(finalIndex,i.length());
			System.out.println(key+" : "+i);
		}
		
	}
}
