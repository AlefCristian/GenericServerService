package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class Listenner implements Runnable {
	protected final Socket socket;
	protected ObjectInputStream input;
	protected ObjectOutputStream output;
	//protected MessageJsonDeconstruct deconstruct;
	protected String message;
	
	public Listenner( Socket socket) {
		this.socket = socket;
		try {
			this.output = new ObjectOutputStream(socket.getOutputStream());
			this.input = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void write(String message) {
		try {
			output.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected boolean close() {
		try {
			output.close();
			socket.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}