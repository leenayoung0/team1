package gimyejin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PickController implements Initializable{
	Parent root;
	pickService ps;
	String nowid;
	public void setRoot(Parent root) {
		this.root=root;
	}

	public void setName(String nowid) {//로그인한 id받아옴
		this.nowid=nowid;
		Label la =(Label)root.lookup("#userName");
		la.setText(nowid);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ps = new pickService();
		
	}
	public void pickup() {
		//뽑기 버튼
		System.out.println("뽑기");
		ps.setMoney(root);
		//ps.setuser(nowid);
		ps.play(root);
		
	}
	public void item() {
		//소지한 아이템 출력 버튼
	}
	public void charge() {
		ps.setMoney(root);
		ps.chageMoney();
		//금액 충전 버튼
	}

	
}
