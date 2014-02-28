package monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ControlCMD {

//Runtime
public void execute(String command){
  
   try {
    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec(command);
    BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while((line=reader.readLine())!=null) {
     System.out.println("命 令 行： "+command);
     System.out.println("报错信息： "+line);}
   } catch (IOException e) {
    System.out.println("远程命令 执行失败！！！");
    e.printStackTrace();
   }
}

//控制远程客户机，立即关机
public void shutdown(String ip){
   execute("shutdown -s -m \\\\"+ip);
}

//指定远程客户机，延时 i 秒关机
public void shutdown(String ip,int i){
   execute("shutdown -s -m \\\\"+ip+" -t "+i);
}

//指定远程客户机，延时 i 秒重新启动
public void restart(String ip,int i){
   execute("shutdown -r -m \\\\"+ip+" -t "+i);
}



}