package gimyejin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PickMain {
	Parent root;//회원로그인한 root임
	String nowid ;
	public  PickMain(Parent root) {
		this.root=root;
		TextField id = (TextField) root.lookup("#fxId");
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
			Parent root2 = loader.load();
			Scene scene = new Scene(root2);
			
			PickController ctl = loader.getController();
			ctl.setRoot(root2);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
