package game1;

import java.util.Scanner;



public class Plus {
		public void show() {
			int p = (int) (Math.random() * 4) + 1;
			if (p >= 1) {
				System.out.println("다나와에서 컴퓨터를 구매하면 10% 할인!!");
			} else if (p >= 2) {
				System.out.println("컴퓨터 학원은 역시 KG IT BANK!!");
			} else if (p >= 3) {
				System.out.println("명량 핫도그 지금 구매 시 3개 3000원!!");
			} else if (p >= 4) {
				System.out.println("지금 칫솔 구매 시 3개 1000원!!");
			} 
		}
	}

