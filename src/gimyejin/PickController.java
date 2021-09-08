package gimyejin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class PickController implements Initializable{
	Parent root;
	public void setRoot(Parent root) {
		this.root=root;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void pickup() {
		//뽑기 버튼
	}
	public void item() {
		//소지한 아이템 출력 버튼
	}
	public void charge() {
		//금액 충전 버튼
	}
}
