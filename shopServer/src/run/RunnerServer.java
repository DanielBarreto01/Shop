package run;

import java.io.IOException;

import presenters.PresenterServer;

public class RunnerServer {
	public static void main(String[] args) throws IOException {
		PresenterServer server = new PresenterServer();
		server.start();
	}
}
