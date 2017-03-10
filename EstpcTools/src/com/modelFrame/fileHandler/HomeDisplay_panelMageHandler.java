package com.modelFrame.fileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;
import com.modelFrame.timerTool.AutoTimer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XML11Serializer;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class HomeDisplay_panelMageHandler {
	
	private String timer_period ;
	private String timer_between ;
	private File estpc_porperties ;
	public LoggerListener loginfo;
	AutoTimer autoTimer = new AutoTimer();
	HashMap<Integer,String> listHashMap = new HashMap<Integer,String>();


	public HomeDisplay_panelMageHandler() {
		estpc_porperties = new File(Set_properties.getProperties_path(),Set_properties.getProperties_file());
		loginfo = new WriterLogger();
	}
	
	
	public void setTimerPeriod(int timerPeriod){
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_porperties);
			
			document.getElementsByTagName("timer_period").item(0).setTextContent(Integer.toString(timerPeriod));
			
			loginfo.txtWriterLogger("estpc_porperties.xml의 timer_period 값을 "+timerPeriod+"로 설정");
			
			FileOutputStream fos = new FileOutputStream(estpc_porperties);
			OutputFormat outputFormat = new OutputFormat(document);
			outputFormat.setIndenting(true);

			XMLSerializer xmlSerializer = new XML11Serializer(fos, outputFormat);
			xmlSerializer.serialize(document);

			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("HomeDisplay_panelMageHandler의 setTimerPeriod() 오류는 : " + e.getMessage());
		}
	}
	
	public String  getTimerPeriod(){
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_porperties);
			
			timer_period = document.getElementsByTagName("timer_period").item(0).getTextContent();
			
			loginfo.txtWriterLogger("estpc_porperties.xml의 timer_period 값을 죄회한다 - 값 : "+timer_period);
			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("HomeDisplay_panelMageHandler의 getTimerPeriod() 오류는 : " + e.getMessage());
		}
		return timer_period;
		
	}
	
	public void setTimerBetween(int timerBetween){
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_porperties);
			
			document.getElementsByTagName("timer_between").item(0).setTextContent(Integer.toString(timerBetween));
			
			loginfo.txtWriterLogger("estpc_porperties.xml의 timer_between 값을 "+timerBetween+"로 설정");
			
			FileOutputStream fos = new FileOutputStream(estpc_porperties);
			OutputFormat outputFormat = new OutputFormat(document);
			outputFormat.setIndenting(true);

			XMLSerializer xmlSerializer = new XML11Serializer(fos, outputFormat);
			xmlSerializer.serialize(document);

			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("HomeDisplay_panelMageHandler의 getTimerBetween() 오류는 : " + e.getMessage());
		}
	}
	
	public String getTimerBetween(){
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_porperties);
			
			timer_between = document.getElementsByTagName("timer_between").item(0).getTextContent();
			
			loginfo.txtWriterLogger("estpc_porperties.xml의 getTimerBetween 값을 죄회한다 - 값 : "+timer_between);
			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("HomeDisplay_panelMageHandler의 getTimerBetween() 오류는 : " + e.getMessage());
		}
		return timer_between;
		
	}
	
	public void btnCollection(){
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_porperties);
			
			timer_between = document.getElementsByTagName("timer_between").item(0).getTextContent();
			timer_period = document.getElementsByTagName("timer_period").item(0).getTextContent();
			
			loginfo.txtWriterLogger("집계를 시작합니다. 설정값 : "+timer_between+"분/"+timer_period+"회");
			
			autoTimer.runTimer(Integer.parseInt(timer_period), Integer.parseInt(timer_between));
			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("HomeDisplay_panelMageHandler의 getTimerPeriod() 오류는 : " + e.getMessage());
		}
		
	}
	
	public void btnStopCollection(){
		autoTimer.stopTimer();
	}
	
	public HashMap callFileListCheck(){
		File f = new File(Set_properties.getData_path());
		String[] stringList = f.list();

		for (int j = 0; j < stringList.length; j++) {
			listHashMap.put(j+1, stringList[j]);
		}
		
		return listHashMap;
		
	}

}
