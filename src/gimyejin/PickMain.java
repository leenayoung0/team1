package gimyejin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PickMain {
	Parent user;//회원로그인한 root임
	String nowid ;
	public  PickMain(Parent user) {
		this.user=user;
		TextField id = (TextField) user.lookup("#fxId");
		nowid=id.getText();
		
	}
	public void pick() {
		PickupGame pg=new PickupGame();
		pg.play();
		
	}
	public void pickmode() {
		System.out.println(nowid);
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("game.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			PickController ctl = loader.getController();
			ctl.setRoot(root);
			ctl.setName(nowid);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
