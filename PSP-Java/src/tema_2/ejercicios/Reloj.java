package tema_2.ejercicios;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reloj extends JFrame{
	
	private static final long serialVersionUID = 4250627773234114346L;
	
	public Reloj() {
		super("Reloj");
		JLabel l = new JLabel();
		l.setText("Hola mundo");
		setLayout(new FlowLayout());
		getContentPane().add(l);
		
		JButton b = new JButton("pulsa");
		
		Contador c=new Contador(l);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t =new Thread(c);
				t.start();
			}
		});
		getContentPane().add(b);
		setSize(500,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Reloj();
		
	}
}
