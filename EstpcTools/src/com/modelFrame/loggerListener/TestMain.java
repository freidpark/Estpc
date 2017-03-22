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
		SaveFileHandler saveFileHandler = new SaveFileHandler();
//		autotimer.mkComand();//완료
//		saveFileHandler.asSaveFile();//완료
		
		
		
//		HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
//		homeDisplay_panelMageHandler.callFileListCheck();
		
		
//		Process cmdPorcess = Runtime.getRuntime().exec("cmd C:/Users/freid/Desktop/Ipscan/saveLog dir");
		
//	File file = new File(Set_properties.getData_path());
//	String[] list = file.list();
//	
//	int b;
//	int[] c = new int[list.length];
//	for (int i = 0; i < list.length; i++) {
//
//		String[] aa = list[i].split("_");
//						
//						String a = aa[1];
//						 b = Integer.parseInt(a.substring(0, 8));
//						 System.out.println(b);
//						 c[i] = b;
//
//	}
//		
//		//버블정렬
//		int tmp = 0 ;
//		for (int i = list.length; i > 1; i--) {
//			for (int j = 1; j < i; j++) {
//				if (c[j-1]>c[j]){
//					tmp = c[j-1];
//					c[j-1] = c[j];
//					c[j] =tmp;
//				}
//		}
//		
//		for (int m = 0; m < c.length; m++) {
//			System.out.println(c[m]);
//		}
//		
//		}
		
	
//		SaveFileHandler sf = new SaveFileHandler();
//		sf.mkAccumulation("statistic_20170317.txt");
//		sf.extractAccumulation("statistic_20170317.txt" , "우리");
	
//		
//		String a = "17일 17:33      1회차   PC_ON : 112  -   우리";
//		String b = "17일 17:33      1회차   PC_ON : 31  -   스타";
//		String c = "17일 17:33      1회차   PC_ON : 5  -   행복";
//		
//		System.out.println(a.substring(29, 32).trim());
//		System.out.println(b.substring(29, 32).trim());
//		System.out.println(c.substring(29, 32).trim());
		
		 
		loginfo.txtWriterLogger("stared");
	}

}
