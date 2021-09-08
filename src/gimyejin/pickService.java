package gimyejin;

import java.util.ArrayList;
import java.util.HashMap;

import common.db.AlertClass;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class pickService {// 상세기능 만들기(impl역할)
	Parent root;
	int money;
	AlertClass alert;
	itemDTO dto;
	Label pulsMoney;
	ArrayList pick;
	HashMap< String, String > useprint;
	public void setMoney(Parent root) {
		this.root = root;
		Label stMoney = (Label) root.lookup("#money");
		money = Integer.parseInt(stMoney.getText());
		pick = new ArrayList();
		useprint =new HashMap<String, String>();
	}

	public void play(Parent root) {
		checkMoney();
		money -=100;
		pulsMoney.setText(Integer.toString(money));
	}

	public void checkMoney() {
		if (money >= 100) {
			pickup();
		} else {
			alert.atler("잔액이 부족합니다");
		}
	}

	public void chageMoney() {
		TextField chageM = (TextField) root.lookup("#chargeMoney");
		money = money + (Integer.parseInt(chageM.getText()));
		chageM.setText(Integer.toString(money));
		System.out.println("충전 완료");
		pulsMoney = (Label) root.lookup("#money");
		pulsMoney.setText(Integer.toString(money));
	}

	public void pickup() {
		dto = new itemDTO();
		int ran = (int) (Math.random() * 100) + 1;
		System.out.println(ran);
		if (ran == 2) {
			System.out.println("!!!대 성공!!!");
			
			System.out.println(dto.item.get(14));
			alert.atler(dto.getItem().get(14));
			money += 2000;
			pulsMoney.setText(Integer.toString(money));

		} else if (ran > 2 && ran < 11) {
			System.out.println("!!성공!!");
			
			int random = (int) (Math.random() * 3) + 11;
			System.out.println(dto.getItem().get(random));
			alert.atler(dto.getItem().get(random));
			inMyItem(random);//소지품 출력용
		} else {
			int random = (int) (Math.random() * 10) + 1;
			System.out.println(dto.getItem().get(random));
			alert.atler(dto.getItem().get(random));
			inMyItem(random);
		}
	}
	public void inMyItem(int key) {
		String i = dto.getItem().get(key);
		int finalIndex = i.indexOf("]");
		i = i.substring(1, finalIndex);
		pick.add(i);
		useprint.put(i,dto.item.get(key));
	}

}
