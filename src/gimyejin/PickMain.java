package gimyejin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PickMain {
	Parent root;//회원로그인한 root임
	public void PickMain(Parent root) {
		this.root=root;
	}
	public void pick() {
		PickupGame pg=new PickupGame();
		pg.play();
		
	}
	public void pickmode() {
		System.out.println("창띄워");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("game.fxml"));
			Parent root2 = loader.load();//여기서 문제가 남
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
