package login;

import common.db.AlertClass;
import gimyejin.PickMain;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import member.MemberDTO;

public class LoginServiceImpl implements LoginService {
	Parent root;
	LoginDB db;
	boolean loginchk = false;

	public LoginServiceImpl() {
		db = new LoginDB();
	}

	@Override
	public boolean loginChk(Parent root) {// DB에서 찾은 결과를 대조, 응용하는 부분
		this.root = root;
		TextField id = (TextField) root.lookup("#fxId");
		TextField pwd = (TextField) root.lookup("#fxPwd");

		MemberDTO dto = db.loginChk(id.getText());

		String msg = null;
		if (dto == null) {
			msg = "존재하지 않는 아이디입니다.";

		} else {
			if (dto.getPwd().equals(pwd.getText())) {
				msg = "인증 성공";
				loginchk = true;

			} else {
				msg = "비밀번호가 틀림";

			}
		}
		AlertClass.atler(msg);
		return loginchk;
	}

}
