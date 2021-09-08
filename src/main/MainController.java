package main;

import java.net.URL;
import java.util.ResourceBundle;

import common.db.AlertClass;
import gimyejin.PickMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import login.LoginService;
import login.LoginServiceImpl;
import member.MemberDTO;
import javafx.scene.control.Alert.AlertType;

public class MainController implements Initializable {
	Parent root;
	public static DBClass db;
	public common.db.DBClass comDB;// 공통사용
	private LoginService ls;
	boolean chk;
	AlertClass alert;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		comDB = new common.db.DBClass();// 다른사람들과 공통으로 사용하는 부분
		ls = new LoginServiceImpl();
	}

	public void membership() {
		TextField id = (TextField) root.lookup("#memberId");
		TextField pwd = (TextField) root.lookup("#memberPwd");
		TextField name = (TextField) root.lookup("#memberName");

		MemberDTO dto = new MemberDTO();

		dto.setId(id.getText());
		dto.setPwd(pwd.getText());
		dto.setName(name.getText());

		int result = db.insert(dto);
		Alert alert = new Alert(AlertType.INFORMATION);
		if (result == 1) {
			alert.setContentText("회원가입 성공");
			alert.show();
		} else {
			alert.setContentText("동일한 아이디가 존재한다.");
			alert.show();
		}
	}

	public boolean login() {// 만약 로그인 기능을 다른사람이 만드다는 가정하에
		chk = ls.loginChk(root);
		return chk;
	}

	public void setRoot(Parent root) {
		this.root = root;

	}

	public void pickup() {
		if (chk == true) {
			PickMain pm = new PickMain(root);
			// pm.pick();

			pm.pickmode();
		}else {
			alert.atler("로그인을 하시오");
		}

	}

}