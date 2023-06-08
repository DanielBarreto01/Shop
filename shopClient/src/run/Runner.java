package run;

import views.JFrameMain;
import presenters.Presenter;
import router.Router;
import router.Option;

import javax.swing.*;
import java.io.IOException;

public class Runner {
	public static void main(String[] args) throws IOException {
		JFrameMain jFrameMain = new JFrameMain();
		Presenter presenter = new Presenter();
		Router.instance = new Router(jFrameMain);
		Router.instance.navigate(Option.login, presenter);
	}
}
