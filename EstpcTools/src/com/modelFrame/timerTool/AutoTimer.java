package com.modelFrame.timerTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.modelFrame.fileHandler.Set_properties;
import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;

public class AutoTimer {
	
	HashMap<Integer, String> userName_list= new HashMap<Integer, String>();
	HashMap<Integer, String> sIP_list= new HashMap<Integer, String>();
	HashMap<Integer, String> eIP_list= new HashMap<Integer, String>();
	LoggerListener logger = new WriterLogger();
	
	Timer autotimer = new Timer();
	TimerTask autotimer_content = new TimerTask(){

		int count = 0; //반복 횟수
		@Override
		public void run() {
			
			if(count<5){
				
				System.out.println("타이머가 나를 실행 시켰다");
				count++;
			}else{
				System.out.println("타이머가 나를 종료 시켰다");
				autotimer.cancel();
			}
		}
	};
	
	public void runTimer(){
		
//		autotimer.schedule(autotimer_content, 3000);
//		autotimer.schedule(autotimer_content, 2000, 3000);
		autotimer.schedule(autotimer_content, 3000);
//		autotimer.schedule(autotimer_content, 3000);
	}
	
	public void mkComand(){
		String stringCommand ;
		
		try {
			
			getIPlist();

			//명령어를 만든다. ex) ipscan_221-bawday.exe -h -f:csv 110.15.192.130 110.15.192.180 saveLog/스타.txt
			System.out.println(userName_list.keySet().size());
			for (int indexNum = 1; indexNum < userName_list.keySet().size()+1; indexNum++) {

				StringBuilder command = new StringBuilder();
				command.append("cmd /c ");
				command.append(Set_properties.getApp_path());
				command.append("\\");
				command.append(Set_properties.getApp_file());
				command.append(" -h -f:csv ");
				command.append(sIP_list.get(indexNum));
				command.append(" ");
				command.append(eIP_list.get(indexNum));
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
			System.out.println("mkComand()의 오류 : "+e.getMessage());
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
			System.out.println("getIPlist()의 오류 : "+e.getMessage());
		}
		
	}
	
	public void collecteData(){
		try {
			int total = 0;
//			File file = new File(Set_properties.getAppSaveFiles_path(),userName_list.get(1));
			File file = new File(Set_properties.getAppSaveFiles_path(),"행복.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader); 
			String line = null;
			String[] lineArrary = null;
			while(br.ready()){
				line=br.readLine();
				lineArrary = line.split(",");
				if(lineArrary[1].equalsIgnoreCase("Dead")){
					total++;
				};
				System.out.println(lineArrary.length);
				System.out.println();
				System.out.println(line);
			}
			
		} catch (Exception e) {
			System.out.println("collecteData()의 오류 : "+e.getMessage());
		}
		
	}
	

}
