package com.modelFrame.loggerListener;


import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.SaveFileHandler;
import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.timerTool.AutoTimer;


public class TestMain {

	
	public static void main(String[] args) throws Exception{
 
		ServiceStarter ss = new ServiceStarter();
		ss.serviceStarter();
		
		LoggerListener loginfo = new WriterLogger();
		
		loginfo.txtWriterLogger("console-mode start");
		
		CallFileHandler cf = new CallFileHandler();
		
//		loginfo.txtWriterLogger("timer start");
//		
		SaveFileHandler saveFileHandler = new SaveFileHandler("DM_OVPS_RESULT");
		saveFileHandler.asSaveFile();
		
		AutoTimer autotimer = new AutoTimer();
//		autotimer.runTimer();//완료
//		autotimer.mkComand();//완료
//		autotimer.collecteData();//진행중
		
		
//		Process cmdPorcess = Runtime.getRuntime().exec("cmd C:/Users/freid/Desktop/Ipscan/saveLog dir");
		
		 
		loginfo.txtWriterLogger("end");
	}

}
