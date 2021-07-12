package server;

import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TCPServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();// establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();

			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			String str1 = "TCP Server Message ";
			dout.writeUTF(str + str1);
			dout.flush();
			dout.close();

			// SERVER MESAJ EKRANI
			JFrame f = new JFrame("Server");
			f.setSize(253, 253);
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Server Message\n");
			panel.setLayout(new FlowLayout());
			JButton button = new JButton(str1);

			panel.add(label);
			panel.add(button);
			f.add(panel);

			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);

			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
