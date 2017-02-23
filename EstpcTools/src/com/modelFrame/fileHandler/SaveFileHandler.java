package com.modelFrame.fileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class SaveFileHandler {
	
	File file ;
	private String fileName = Set_properties.getData_file() ;
	private PrintWriter pw;
	private FileWriter fw;
	private BufferedWriter bw;
	
	int currentDate;
	int currentHour;
	int currentMinute;
	
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
			System.out.println(e.getMessage());
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
	public void asSaveTheStatisticFile(int alive){
		
		Calendar cal = Calendar.getInstance();
		StringBuilder allFileName = new StringBuilder();
		
		int lastOfDay = lastOfDayStamp(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY)+1);
		int monthy = cal.get(Calendar.MONDAY)+1;
		int date = cal.get(Calendar.DATE);
		
		allFileName.append(Set_properties.getData_file());
		allFileName.append("_");
		allFileName.append(cal.get(Calendar.YEAR));
		
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
		
		String stringAllFileName = allFileName.toString();
		
		file = new File(Set_properties.getData_path(),stringAllFileName);
		try {
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file, true);
		    bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(currentDate+"일 "+currentHour+":"+currentMinute+"   "+"파일에 한줄씩 내용을 저장합니다. - "+alive);
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	}

}
