package game1;

import java.util.Scanner;

class UpDown {
	public int com, max = 99;

	public int ranNum() {
		com = (int) (Math.random() * 99 + 1);
		return com;
	}

	public int jumsuScore(int jumsu) {
		if (max > jumsu) {
			max = jumsu;
			return 0;
		}
		return 1;
	}

	public int computerCheck(int player) {
		if (player > com)
			return 2;
		else if (player < com)
			return 1;
		return 4;
	}

	public int record() {
		return max;
	}
}

public class UpDownGame extends Plus {
	public void display() {
		UpDown updw = new UpDown();
		Scanner sc = new Scanner(System.in);
		int q, w = 0;
		int a = 0, com = 0, c = 0, score = 0, result = 0;
		int player = 0;
		while (true) {
			System.out.println(" ===== Up & Down Game ===== ");
			System.out.println(" 1. 게임시작 ");
			System.out.println(" 2. 게임전적");
			System.out.println(" 3. 게임종료");
			System.out.println(" > > ");
			a = sc.nextInt();

			switch (a) {
			case 1:
				com = updw.ranNum();
				System.out.println("랜덤 숫자 : ");
				c = 3;
				while (true) {
					if (c == 3) {
						System.out.println(" ===  게임 시작!  ===");
					} else if (c == 1) {
						System.out.println(" ===  보다 위에요!  ===");
						score++;
					} else if (c == 2) {
						System.out.println(" ===  보다 밑이에요!  === ");
						score++;

					} else {
						score++;
						System.out.println(score + "회 만에 정답!");
						result = updw.jumsuScore(player);
						score = 0;
						if (result == 0) {
							System.out.println("가장 빠른 기록 갱신!! \n");
						}
						show();
						break;
					}
					System.out.print("번호 입력 --> ");
					player = sc.nextInt();
					c = updw.computerCheck(player);
				}
				break;
			case 2:
				if (updw.record() == 99) {
					System.out.println("게임을 시작하지 않았습니다");
					break;
				}
				System.out.println("가장 빠른 기록 " + updw.record() + "회!");
				break;
			case 3:
				System.out.println("게임종료");
				show();
				System.exit(1);
			}
		}
	}
}
