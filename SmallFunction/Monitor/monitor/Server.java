package monitor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server extends Thread{
    private ServerSocket server=null;
    private Socket socket = null;
    private BufferedImage image = null;
    private OutputStream ots = null; 
    private GetImage gif = new GetImage();
    public Server(){
    	try {
			this.server = new ServerSocket(6888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
	public static void main(String[] args)   
    {   
		Server server = new Server();
		new Thread(server).start();
    }
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			try {
				
				System.out.println("监听中........");
				this.socket = server.accept();
				 ServiceUnit unit=new ServiceUnit(socket);
                 unit.start();
				ots = this.socket.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("不断截屏");
			this.image = gif.getImage();
			if (image == null) {  
				System.out.println("图片为空");
			     try   
			     {   
                       throw new IOException();   
			     } catch (IOException e1)   
			     {   
			  // TODO 自动生成 catch 块   
			  e1.printStackTrace();   
			     }   
			}
			try {
				javax.imageio.ImageIO.write(image, "jpg", ots);
				//this.socket.close();
				ots.flush();
			} catch (IOException e) {
				// TODO Aut = null;
				
				e.printStackTrace();
			}
			if(ots != null)
				try {
					ots.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			this.socket = null;
		}
	}

}

class ServiceUnit extends Thread{
    Socket client = null;
    InputStream is = null;
    BufferedReader br = null;
    String msg = null;
    public ServiceUnit(Socket c) {
        client=c;
    }
    public void run() {
        //users.add(client);
        while (true) {
            try {
                is = client.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                msg = null;

                while ((msg = br.readLine()) != null) {
                	Robot robot = null;
                	
                	if(msg.equals("重启")){
                		ControlCMD cmd = new ControlCMD();
                		cmd.restart("127.0.0.1", 10);
                		//cmd.restart("172.21.13.236", 10);
                		System.out.println("监听客户端控制");
                	}
                	if(msg.equals("关机")){
                		ControlCMD cmd = new ControlCMD();
                		cmd.shutdown("127.0.0.1",10);
                		System.out.println("监听客户端控制");
                	}
                	if(msg.equals("控制光标位置")){
                		robot = new Robot();
                		robot.mouseMove(50, 100);
                		System.out.println("监听客户端控制");
                	}
                	//robot.mouseMove(20, 20);
                   System.out.println("监听客户端控制信息"+msg);
                }
                Thread.sleep(100);
            } catch (Exception ex) {
                //ex.printStackTrace();
                break;
            }
        }
    }
}

