package com.modelFrame.loggerListener;


import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.HomeDisplay_panelMageHandler;
import com.modelFrame.fileHandler.SaveFileHandler;
import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.timerTool.AutoTimer;


public class TestMain {

	
	public static void main(String[] args) throws Exception{
 
		ServiceStarter ss = new ServiceStarter();
		ss.serviceStarter();
		
		LoggerListener loginfo = new WriterLogger();
		
		loginfo.txtWriterLogger("You are running 'console-mode start" );
		
//		CallFileHandler cf = new CallFileHandler();
		
//		loginfo.txtWriterLogger("timer start");
//		
//		AutoTimer autotimer = new AutoTimer();
//		autotimer.runTimer(3,20);//완료
//		autotimer.runTimer(72,20);//완료
//		autotimer.runTimer(48,30);//완료
//		SaveFileHandler saveFileHandler = new SaveFileHandler();
//		autotimer.mkComand();//완료
//		saveFileHandler.asSaveFile();//완료
		
		HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
		homeDisplay_panelMageHandler.callFileListCheck();
		
		
		
//		Process cmdPorcess = Runtime.getRuntime().exec("cmd C:/Users/freid/Desktop/Ipscan/saveLog dir");
		
		 
		loginfo.txtWriterLogger("stared");
	}

}
