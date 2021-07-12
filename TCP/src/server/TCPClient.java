package server;

import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			String s1 = "TCP Client Message ";
			dout.writeUTF(s1);
			dout.flush();
			// dout.close();

			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println(str);

			// ÝSTEMCÝDEN GÖNDERÝLEN MESAJ EKRANI
			JFrame f = new JFrame("Client");
			f.setSize(253, 253);
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			JLabel label = new JLabel("Client message\n");
			JButton button = new JButton(s1);

			panel.add(label);
			panel.add(button);

			// SUNUCUDAN GERÝ ÝSTEMCÝYE GÖNDERÝLEN MESAJ EKRANI
			JLabel label2 = new JLabel("Last message\n");
			JButton button2 = new JButton(str);

			panel.add(label2);
			panel.add(button2);
			f.add(panel);

			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);

			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
