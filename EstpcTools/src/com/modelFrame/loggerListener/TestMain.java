package com.modelFrame.loggerListener;


import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.ServiceStarter;
//import com.modelFrame.loggerListener.LoggerListener;


public class TestMain {

	
	public static void main(String[] args) {
 
		ServiceStarter ss = new ServiceStarter();
		ss.serviceStarter();
		
		LoggerListener loginfo = new writerLogger();
		
		loginfo.txtWriterLogger("start");
		
		CallFileHandler cf = new CallFileHandler();
//		cf.getStoreInfo();
		
		
		loginfo.txtWriterLogger("end");
	}

}
