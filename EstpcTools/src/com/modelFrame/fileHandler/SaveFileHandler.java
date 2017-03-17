package com.modelFrame.fileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;

import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;

public class SaveFileHandler {
	
	File file ;
	private String fileName = Set_properties.getData_file() ;
	private PrintWriter pw;
	private FileWriter fw;
	private BufferedWriter bw;
	String replaceFileName;
	
	int currentDate;
	int currentHour;
	int currentMinute;
	
	LoggerListener loginfo = new WriterLogger();
	
	
	public SaveFileHandler(){
		registerBaseTime();
	}
	
	/**
	 * 년,월의 값을 주어 말일자를 뒤에 붙여 파일 이름을 만든다. ex) fileName_20170228.txt
	 */
	public void asSaveFile(){
		
		Calendar cal = Calendar.getInstance();
		StringBuilder allFileName = new StringBuilder();
		
		int lastOfDay = lastOfDayStamp(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY)+1);
		int monthy = cal.get(Calendar.MONDAY)+1;
		
		switch (Integer.toString(monthy).length()) {
		case 1 :
			String stringMonth = "0"+Integer.toString(monthy);
			
			allFileName.append(this.fileName);
			allFileName.append("_");
			allFileName.append(cal.get(Calendar.YEAR));
			allFileName.append(stringMonth);
			allFileName.append(lastOfDay);
			allFileName.append(".txt");
			break;

		default:
			allFileName.append(this.fileName);
			allFileName.append("_");
			allFileName.append(cal.get(Calendar.YEAR));
			allFileName.append(monthy);
			allFileName.append(lastOfDay);
			allFileName.append(".txt");
			break;
		}
		String stringAllFileName = allFileName.toString();
		
		file = new File(Set_properties.getLog_path(),stringAllFileName);
		try {
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file, false);
		    bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println("01- 파일에 한줄씩 내용을 저장합니다.");
			pw.write("02- 파일에 이어서 내용을 저장합니다.");
			pw.close();
			
		} catch (Exception e) {
			loginfo.txtWriterLogger(e.getMessage());
		}
	}
	
	private int lastOfDayStamp(String year, String month){
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int lastDay = cal.getActualMaximum((Calendar.DATE));
		
		return lastDay;
	}
	
	private int  lastOfDayStamp(int year, int month){
		return lastOfDayStamp(year+"",month+"");
	}
	
	/**통계값을 AutoTimer객체로 부터 받아 파일에 쓴다.
	 * @param alive 
	 */
	public void asSaveTheStatisticFile(int count , int alive, String userName){
		
		Calendar cal = Calendar.getInstance();
		StringBuilder allFileName = new StringBuilder();
		
		int lastOfDay = lastOfDayStamp(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY)+1);
		int year = cal.get(Calendar.YEAR);
		int monthy = cal.get(Calendar.MONDAY)+1;
		int date = cal.get(Calendar.DATE);
		
		allFileName.append("_");
		allFileName.append(year);
		
		switch (Integer.toString(monthy).length()) {
		case 1 :
			String stringMonth = "0"+Integer.toString(monthy);
			allFileName.append(stringMonth);
			break;

		default:
			allFileName.append(monthy);
			break;
		}
		
		switch (Integer.toString(date).length()) {
		case 1 :
			String stringDate = "0"+Integer.toString(date);
			allFileName.append(stringDate);
			break;

		default:
			allFileName.append(date);
			break;
		}
		
		allFileName.append(".txt");
		
		String stringBaseYMD = allFileName.toString();
		
		replaceFileName = fileName.replaceAll(".txt", stringBaseYMD);
		
		file = new File(Set_properties.getData_path(),replaceFileName);
		try {
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file, true);
		    bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(currentDate+"일 "+currentHour+":"+currentMinute+"   "+count+"회차   PC_ON : "+alive+"  -   "+userName);
			pw.close();
			
		} catch (Exception e) {
			loginfo.txtWriterLogger(e.getMessage());
		}
	}
	
	
	public void insertSpace(){
		file = new File(Set_properties.getData_path(),replaceFileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(" ");
			pw.println(" ");
			pw.close();

		} catch (Exception e) {
			loginfo.txtWriterLogger(e.getMessage());
		}
		
	}

	/**
	 * saveFileHandler 가  실행될 시 최초 시간을 저장한다
	 */
	public void registerBaseTime(){
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);
		
		switch (Integer.toString(d).length()) {
		case 1 :
			String stringDay = "0"+Integer.toString(d);
			currentDate = Integer.parseInt(stringDay);
			break;
			
		default :
			currentDate=d;
			break;
		}
		
		switch (Integer.toString(h).length()) {
		case 1 :
			String stringDate = "0"+Integer.toString(h);
			currentHour = Integer.parseInt(stringDate);
			break;
			
		default :
			currentHour=h;
			break;
		}
		
		switch (Integer.toString(m).length()) {
		case 1 :
			String stringMinute = "0"+Integer.toString(m);
			currentMinute = Integer.parseInt(stringMinute);
			break;
			
		default :
			currentMinute=m;
			break;
		}
		loginfo.txtWriterLogger("집계시작 "+currentDate+"일 "+currentHour+"시 "+currentMinute+"분");
	}

	public void autoDeleted(int fileQuantity){
		try {

			File file = new File(Set_properties.getData_path());
			String[] fileList = file.list();

			int b;
			int[] reFileList = new int[fileList.length];
			//날짜별만 잘라서 배열로 다시 정의
			for (int i = 0; i < fileList.length; i++) {

				String[] aa = fileList[i].split("_");

				String a = aa[1];
				b = Integer.parseInt(a.substring(0, 8));
				reFileList[i] = b;
			}

			//버블정렬
			int tmp = 0 ;
			for (int i = fileList.length; i > 1; i--) {
				for (int j = 1; j < i; j++) {
					if (reFileList[j-1]>reFileList[j]){
						tmp = reFileList[j-1];
						reFileList[j-1] = reFileList[j];
						reFileList[j] =tmp;
					}
				}
			}
//			양수라면 지우기 수행
			if (reFileList.length-fileQuantity>0) {
				
				for (int i = 0; i < reFileList.length-fileQuantity; i++) {
					
					String openCommand = "cmd /c del "+Set_properties.getData_path()+"\\statistic_"+reFileList[i]+".txt";
					
					Runtime.getRuntime().exec(openCommand);				
					loginfo.txtWriterLogger(openCommand+" 명령어 실행됨");
				}
			}
			

		} catch (Exception e) {
			loginfo.txtWriterLogger(e.getMessage());
		}

	}
	
	public void selectDelet(){
		
	}
	
}
