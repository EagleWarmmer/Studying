package monitor;

import java.awt.Dimension;   
import java.awt.Rectangle;   
import java.awt.Robot;   
import java.awt.Toolkit;   
import java.awt.image.BufferedImage;   
public class GetImage   
{   
 private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();   
 private String imageFormat = "jpg";   
 private int Num = 0;   
 private BufferedImage screenImage;   
 public synchronized  BufferedImage getImage()   
 {   
  try   
  {     Robot robot = new Robot();
	  screenImage = robot.createScreenCapture(new Rectangle(0,0,   
   (int) dimension.getWidth(), (int) dimension.getHeight()));  
	// robot.mouseMove(10, 10);
	 
  } catch (Exception ex)   
  {   
   System.out.println(ex);   
  }   
  return screenImage;   
 }   
}