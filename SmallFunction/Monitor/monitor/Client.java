package monitor;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;


public class Client extends JFrame implements Runnable ,ActionListener{
 
	private Socket sok = null;
	private InputStream ips = null;
	private Image image = null;   
	public static void main(String[] args) {
		  Client client = new Client();
		  Panel p=new Panel();
		  p.setSize(100, 100);
		  Button b=new Button("重启");
		  Button g=new Button("关机");
		  Button k=new Button("控制光标位置");
		  b.setSize(100, 50);
		  b.setBackground(new Color(0,100,100));
		  g.setSize(100, 50);
		  g.setBackground(new Color(0,200,100));
		  k.setSize(200, 50);
		  k.setBackground(new Color(0,150,100));
		  p.add(b);
		  p.add(g);
		  p.add(k);
		  client.add(p,BorderLayout.SOUTH);
		  client.setLocation(100, 100);
		  client.setSize(500, 350);   
		  client.setVisible(true); 
		  b.addActionListener(client);
		  g.addActionListener(client);
		  k.addActionListener(client);
		//  client.add(client);
		  new Thread(client).start();
		  client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public Client(){
		
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
		
			try {
				this.sok = new Socket("127.0.0.1",6888);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				this.ips = sok.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				image=javax.imageio.ImageIO.read(ips);
				this.repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(image!=null)
		g.drawImage(this.image, 0, 0, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String cmd=e.getActionCommand();
         if(cmd.equals("重启")){
             OutputStream os =null;
             PrintStream ps =null;
             try {
                 os = this.sok.getOutputStream();
                 ps = new PrintStream(os);
                 ps.println("重启");
             } catch (Exception ex1) {
                
             }
         }
         if(cmd.equals("关机")){
             OutputStream os =null;
             PrintStream ps =null;
             try {
                 os = this.sok.getOutputStream();
                 ps = new PrintStream(os);
                 ps.println("关机");
             } catch (Exception ex1) {
              
             }
         }
         if(cmd.equals("控制光标位置")){
             OutputStream os =null;
             PrintStream ps =null;
             try {
                 os = this.sok.getOutputStream();
                 ps = new PrintStream(os);
                 ps.println("控制光标位置");
             } catch (Exception ex1) {
              
             }
         }
	}

}
