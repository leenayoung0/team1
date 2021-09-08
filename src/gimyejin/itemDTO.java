package gimyejin;

import java.util.HashMap;

public class itemDTO {
	HashMap<Integer, String> item = new HashMap<Integer, String>();

	public itemDTO() { // item쓰기
		item.put(1, "[돌맹이]가 나왔다. 100코인과 바꾼 돌맹이다");
		item.put(2, "[찢어진 종지]가 나왔다. 100코인과 쓰레기를 바꿨다.");
		item.put(3, "[마법서]가 나왔다. '청소 마법서'라고 적혀있다.");
		item.put(4, "[동그란 안경]가 나왔다. 패션아이템을 얻었다.");
		item.put(5, "[무딘 롱소드]가 나왔다. 무언가를 벨 수 있을 것 같지 않다.");
		item.put(6, "[물병]가 나왔다. 물이 1방울정도 있다.");
		item.put(7, "[깃펜]가 나왔다. 잉크가 필요할 것 같다.");
		item.put(8, "[B급 만화책]가 나왔다. 이게 왜 재밌지?");
		item.put(9, "[인형]가 나왔다. 토끼 인형이다.");
		item.put(10, "[포도주]가 나왔다. 싸구려 포도주 맛이다.");
		item.put(11, "[피로회복제]가 나왔다. 피로를 -30 해주는 물약이다.");
		item.put(12, "[마나 포션]가 나왔다. 마나를 +30 해주는 물약이다.");
		item.put(13, "[체력 포션]가 나왔다. 체력을 +30 해주는 물약이다.");
		item.put(14, "[2000코인]이 나왔다. 나는 이제 부자다!");
	}

	public HashMap<Integer, String> getItem() {
		return item;
	}

	public void setItem(HashMap<Integer, String> item) {
		this.item = item;
	}

}
