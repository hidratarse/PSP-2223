package tema_2.ejercicios.futbolchusta;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Juego extends JFrame{
	private static final long serialVersionUID = 4250627773234114346L;
	
	public Juego() {
		super("Juego");
		JLabel l = new JLabel();
		l.setText("Hola mundo");
		setLayout(new FlowLayout());
		getContentPane().add(l);
		
		JButton b = new JButton("pulsa");
		
		Object sync = new Object();
		
		getContentPane().add(b);
		
		Futbol c=new Futbol(l, sync);
		
		Thread t =new Thread(c);
		
		t.start();
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				synchronized(sync) {
					sync.notify();
				}
			}
		});
		
		JButton bPara = new JButton("¡Para!");
		getContentPane().add(bPara);
		bPara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
			}
		});
		
		setSize(500,400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Juego();
	}

}
