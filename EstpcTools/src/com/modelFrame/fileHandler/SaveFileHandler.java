package com.modelFrame.fileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class SaveFileHandler {
	
	File file ;
	private String fileName ;
	private PrintWriter pw;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public SaveFileHandler(String fileName){
		this.fileName = fileName;
	}
	
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

}
