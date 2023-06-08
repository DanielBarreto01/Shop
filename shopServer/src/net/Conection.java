package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conection {
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	
	public Conection(Socket socket) throws IOException {
		this.socket = socket;
		output = new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
	}
	
	public int readInt() throws IOException {
		return input.readInt();
	}
	
	public void writeInt(int number) throws IOException {
		output.writeInt(number);
	}
	
	public String readString() throws IOException {
		return input.readUTF();
	}
	
	public void writeString(String cad) throws IOException {
		output.writeUTF(cad);
	}
	
	public void writeBoolean(boolean bool) throws IOException {
		output.writeBoolean(bool);
	}
	
	public void writeDouble(double doub) throws IOException {
		output.writeDouble(doub);
	}
	
	public double readDouble() throws IOException {
		return input.readDouble();
	}
}
