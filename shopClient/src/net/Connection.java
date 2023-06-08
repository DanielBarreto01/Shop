package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
    private final int PORT = 1234;
    private final String HOST = "localhost";
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public Connection() throws UnknownHostException, IOException{
        socket = new Socket(HOST, PORT);
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

    public boolean readBoolean() throws IOException{
        return input.readBoolean();
    }

    public void writeDouble(double doub) throws IOException {
        output.writeDouble(doub);
    }

    public double readDouble() throws IOException {
        return input.readDouble();
    }

}
