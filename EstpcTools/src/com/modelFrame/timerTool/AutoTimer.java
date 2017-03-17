package com.modelFrame.timerTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.modelFrame.fileHandler.SaveFileHandler;
import com.modelFrame.fileHandler.Set_properties;
import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;

public class AutoTimer {
	
	HashMap<Integer, String> userName_list= new HashMap<Integer, String>();
	HashMap<Integer, String> sIP_list= new HashMap<Integer, String>();
	HashMap<Integer, String> eIP_list= new HashMap<Integer, String>();
	LoggerListener logger = new WriterLogger();
	StringBuilder fileNmb = new StringBuilder();
	Timer mkTimer = new Timer();
	Timer collecTimer = new Timer();
	String fileNm;
	int countA = 0; 
	int countB = 0; 
	int lifetime =  3; //반복 횟수 - 3회X24시간, 값 : 시간당 2회 , 3회
	int lifeMinute = 20; //20분 간격으로 동작, 값 : 20분, 30분
	int lifeSecond = lifeMinute*60;
	int lifeMilliSecondPeriod =  lifeSecond*1000;//반복 간격시간
	
	
	public void runTimer(int lifetime , int lifeMinute){
		getIPlist();
		this.lifetime = lifetime;
		this.lifeMinute = lifeMinute;
		logger.txtWriterLogger("집계를 시작 합니다.");
		mkTimer.schedule(makeFile_content, 2500,lifeMilliSecondPeriod);
		collecTimer.schedule(collection_content, 25000,lifeMilliSecondPeriod);	

	}
	
	public void stopTimer(){
		mkTimer.cancel();
		collecTimer.cancel();
		logger.txtWriterLogger("집계를 수동으로 중지 했습니다.");
	}

	TimerTask makeFile_content = new TimerTask(){

		@Override
		public void run() {
			if(countA != lifetime){
				countA++;
				logger.txtWriterLogger(countA+" 회차 - 파일을 만든다.");
				mkComandNfile();
			}else{
				this.cancel();
				logger.txtWriterLogger("makeFile_content 타이머가 종료 되었다");
			}
		}
	};

	TimerTask collection_content = new TimerTask() {

		@Override
		public void run() {
			if(countB != lifetime){
				countB++;
				logger.txtWriterLogger(countB+" 회차 - data를 수집한다.");
				collectedData(countB);
			}else{
				this.cancel();
				logger.txtWriterLogger("collection_content 타이머가 종료 되었다");
			}
		}
	};
	
	
	public void mkComandNfile(){
		String stringCommand ;
		
		try {
			
			//명령어를 만든다. ex) ipscan_221-bawday.exe -h -f:csv 110.15.192.130 110.15.192.180 saveLog/스타.txt
			for (int indexNum = 1; indexNum < userName_list.keySet().size()+1; indexNum++) {

				StringBuilder command = new StringBuilder();
				command.append("cmd /c ");
				command.append(Set_properties.getApp_path());
				command.append("\\");
				command.append(Set_properties.getApp_file());
				command.append(" -h -f:csv ");
				command.append(sIP_list.get(indexNum));
//				command.append("221.141.125.1");
				command.append(" ");
				command.append(eIP_list.get(indexNum));
//				command.append("221.141.125.255");
				command.append(" ");
				command.append(Set_properties.getAppSaveFiles_path());
				command.append("\\");
				command.append(userName_list.get(indexNum));
				command.append(".txt");
				stringCommand = command.toString().replace("\\", "\\\\");

				Runtime.getRuntime().exec(stringCommand);
				logger.txtWriterLogger(stringCommand);
			}
				
			
//			Process cmdPorcess = Runtime.getRuntime().exec("cmd /c C:\\Users\\freid\\Desktop\\Ipscan\\ipscan_221-bawday.exe");
//			BufferedReader br = new BufferedReader(new InputStreamReader(cmdPorcess.getInputStream()));
//			
//			String line;
//			
//			for (; (line = br.readLine()) != null;){
//				System.out.println(line);
//			}
		} catch (Exception e) {
			logger.txtWriterLogger("mkComand()의 오류 : "+e.getMessage());
			// TODO: handle exception
		}
	}
	
	public void getIPlist(){
		
		try {
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File(Set_properties.getUserStore_path(),Set_properties.getUserStore_file()));
			
			int count = document.getElementsByTagName("store_num").getLength();
			
			for (int i = 1; i < count; i++) {
				
				String name = document.getElementsByTagName("store_name").item(i).getTextContent();
				String sIP = document.getElementsByTagName("store_sIP").item(i).getTextContent();
				String eIP = document.getElementsByTagName("store_eIP").item(i).getTextContent();
				
				userName_list.put(i, name);
				sIP_list.put(i, sIP);
				eIP_list.put(i, eIP);
				
			} 
			
		} catch (Exception e) {
			logger.txtWriterLogger("getIPlist()의 오류 : "+e.getMessage());
		}
		
	}
	
	public void collectedData(int eachCount){
		SaveFileHandler saveFileHandler = new SaveFileHandler();
		for (int j = 1; j < userName_list.keySet().size()+1; j++) {
			
			fileNm = userName_list.get(j)+".txt";
			saveFileHandler.asSaveTheStatisticFile(eachCount, coutnAlive(fileNm), userName_list.get(j) );
		}
		
		saveFileHandler.insertSpace();
		
	}
	
	public int coutnAlive(String fileName){
		int total = 0;
		int countDead = 0;
		int alive = 0;
		
		try {
//			File file = new File(Set_properties.getAppSaveFiles_path(),userName_list.get(1));
			File file = new File(Set_properties.getAppSaveFiles_path(),fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader); 
			String line = null;
			String[] lineArrary = null;
			while(br.ready()){
				line=br.readLine();
				lineArrary = line.split(",");
				if(!lineArrary[1].equalsIgnoreCase("Dead")){
//					countDead++;
					alive++;
				};
				total++;
//				System.out.println(line);
//				System.out.println("countDead 값 : "+countDead);
//				System.out.println("total 값 : "+total);
			}
//			alive = (total - countDead);
//			System.out.println("Alive PC 값 : "+(total - countDead));
			logger.txtWriterLogger("coutnAlive()값은 : "+alive);

		} catch (Exception e) {
			logger.txtWriterLogger("coutnAlive()의 오류 : "+e.getMessage());
		}
		return alive;
	}

}
