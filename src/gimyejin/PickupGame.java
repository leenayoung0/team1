package gimyejin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class PickupGame extends Print {
	Scanner input = new Scanner(System.in);
	private int coin;
	HashMap<Integer, String> item = new HashMap<Integer, String>();
	ArrayList pick = new ArrayList();
	HashMap< String, String > useprint =new HashMap<String, String>();
	public void start() {
		System.out.println("---- 아이템 뽑기 ----");
		System.out.print("돈을 넣어주세요[100코인 당 1회] >>> ");
		coin = input.nextInt();
		check();
	}

	public void check() {
		if (coin < 100) {
			System.out.println("! 잔액이 부족합니다. !");
			System.out.println("[잔액을 충전하시겠습니까?]");
			System.out.println("[1.Yes]   [2.No]");
			String check = input.next();

			if (check.equals("1")) {
				System.out.println("추가할 금액을 넣어주세요");
				int plus = input.nextInt();
				System.out.println(plus + "코인이 추가되었습니다.\n");
				coin += plus;
				System.out.println(">현재 금액: " + coin + "코인");
				if (coin > 100)
					play();
				else
					check();
			} else if (check.equals("2")) {
				System.out.println("잔액 부족으로 메인화면으로 이동합니다.");
				System.out.println("==============================\n");;
				//MainClass mc = new MainClass();
				//mc.main(null);
				
			} else {
				System.out.println("1번과 2번 중 골라주세요.\n");
				check();

			}
		} else {
			System.out.println("[뽑기를 시작합니다.]");

			play();
		}

	}

	public void play() {
		System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("| ~~~ 아이템 뽑기 ~~~ |");
		System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		items();
		while (true) {
			System.out.println("1.뽑기  2.뽑은 아이템  3.종료");
			int num = input.nextInt();
			switch (num) {
			case 1:
				if (coin >= 100) {
					pickup();
					coin -= 100;
					System.out.println(">현재 금액: "+coin+"코인\n");
					break;
				} else {
					check();
				}
			case 2:
				myItem();
				System.out.println("아이템의 정보를 보시겠습니까? [yes/no]");
				String choose = input.next();
				if(choose.equals("yes")) {
					super.cut(useprint);
				}
				break;
			case 3:
				System.exit(1);

			}
		}
	}

	public void items() { // item쓰기
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

	public void pickup() {
		int ran = (int) (Math.random() * 100) + 1;
		if (ran == 2) {
			System.out.println("!!!대 성공!!!");
			System.out.println(item.get(14));
			coin +=2000;
		} else if (ran > 2 && ran < 11) {
			System.out.println("!!성공!!");
			int random = (int) (Math.random() * 3) + 11;
			System.out.println(item.get(random));
			inMyItem(random);
		} else {
			int random = (int) (Math.random() * 10) + 1;
			System.out.println(item.get(random));
			inMyItem(random);
		}
	}

	public void inMyItem(int key) {
		String i = item.get(key);
		int finalIndex = i.indexOf("]");
		i = i.substring(1, finalIndex);
		pick.add(i);
		useprint.put(i,item.get(key));
	}

	public void myItem() {// pick쓰기
		System.out.print("내 아이템: ");
		for (int i = 0; i < pick.size(); i++) {
			System.out.print(pick.get(i));
			if(i != (
					pick.size()-1))System.out.print(", ");
		}
		System.out.println();
	}
}
