import java.io.IOException;
import java.net.*;
import java.io.*; 

public class Server {

	ServerSocket socket;
	int port;
	static int IDclient;
	
	public Server(int port) {

		try {

			socket = new ServerSocket(port);
			Thread t = new Thread(new Accepter_clients(socket));
			Thread t2 = new Thread(new Accepter_clients(socket));

			t.start();
			t2.start();

			System.out.println("Serveur de la calculatrice");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}


	public class Accepter_clients implements Runnable {

		private ServerSocket socketserver;
		private Socket socket;

		PrintWriter out;
		BufferedReader in;

		public Accepter_clients(ServerSocket s){

			socketserver = s;
		}

		public void run() {

			try {



				socket = socketserver.accept(); // Un client se connecte on l'accepte
				System.out.println("Un client s'est connecté !");
			
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				out.println("bienvenue");


				Calculatrice.calculatrice(out, in);

				out.flush();
				socket.close();




			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
