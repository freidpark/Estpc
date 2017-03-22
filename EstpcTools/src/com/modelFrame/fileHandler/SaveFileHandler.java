package com.modelFrame.fileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;

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
	int currentScend;
	
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
			pw.println(registerstataticTime() +"   "+count+"회차   PC_ON : "+alive+"  -   "+userName);
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
			pw.println("                                             ");
			pw.println("                                             ");
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
		StringBuilder sb = new StringBuilder();

		sb.append("집계시작 ");
		
		switch (Integer.toString(d).length()) {
		case 1 :
			String stringDay = "0"+Integer.toString(d);
			sb.append(stringDay);
			break;
			
		default :
			sb.append(d);
			break;
		}
		sb.append("일 ");
		
		switch (Integer.toString(h).length()) {
		case 1 :
			String stringDate = "0"+Integer.toString(h);
			sb.append(stringDate);
			break;
			
		default :
			sb.append(h);
			break;
		}
		sb.append("시 ");
		
		switch (Integer.toString(m).length()) {
		case 1 :
			String stringMinute = "0"+Integer.toString(m);
			sb.append(stringMinute);
			break;
			
		default :
			sb.append(m);
			break;
		}
		sb.append("분");
		
		loginfo.txtWriterLogger(sb.toString());
	}
	
	public String registerstataticTime(){
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);
		StringBuilder sb = new StringBuilder();
		
		switch (Integer.toString(d).length()) {
		case 1 :
			String stringDay = "0"+Integer.toString(d);
			sb.append(stringDay);
			break;
			
		default :
			sb.append(d);
			break;
		}
		sb.append("일 ");
		
		switch (Integer.toString(h).length()) {
		case 1 :
			String stringDate = "0"+Integer.toString(h);
			sb.append(stringDate);
			break;
			
		default :
			sb.append(h);
			break;
		}
		sb.append(":");
		
		switch (Integer.toString(m).length()) {
		case 1 :
			String stringMinute = "0"+Integer.toString(m);
			sb.append(stringMinute);
			break;
			
		default :
			sb.append(m);
			break;
		}
		sb.append("   ");
		
		return sb.toString();
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
	
	public StringBuilder registerTime(){
		Calendar cal = Calendar.getInstance();
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		
		switch (Integer.toString(h).length()) {
		case 1 :
			String stringDate = "0"+Integer.toString(h);
			sb.append(stringDate);
			break;
			
		default :
			sb.append(h);
			break;
		}
		sb.append(":");
		
		switch (Integer.toString(m).length()) {
		case 1 :
			String stringMinute = "0"+Integer.toString(m);
			sb.append(stringMinute);
			break;
			
		default :
			sb.append(m);
			break;
		}
		sb.append(":");
		
		switch (Integer.toString(s).length()) {
		case 1 :
			String stringDay = "0"+Integer.toString(s);
			sb.append(stringDay);
			break;
			
		default :
			sb.append(s);
			break;
		}
		
		loginfo.txtWriterLogger("누적수행 - 시간 : "+sb.toString());
		return sb;
	}
	
	public void mkAccumulation(String selectedFileName){
		
		HomeDisplay_panelMageHandler hp = new HomeDisplay_panelMageHandler();
		String[][] userTable = hp.getUserList();
		String selectedUserName;
		int allTotal = 0 ; 
		int tmp = 0 ; 
		double[] rate = new double[userTable.length]  ;
		String[] percent = new String[userTable.length]  ;
		
		try {
			
			//개별 유저값을 더한 총값 구하기
			for (int i = 1; i < userTable.length; i++) {
				tmp = extractAccumulation(selectedFileName,userTable[i][0]);
				allTotal += tmp;
				}
			
			//개별 유저값의 비율구하기
			DecimalFormat df = new DecimalFormat("##0.0%"); // 백분율로 변환...
			for (int i = 1; i < rate.length; i++) {
				rate[i] =  (double) extractAccumulation(selectedFileName,userTable[i][0]) / (double) allTotal;
				percent[i] = df.format(rate[i]);
			}
			
			
			//파일에 쓰기
			CallFileHandler cf = new CallFileHandler();
			File accumFile = new File(Set_properties.getAppAccum_path(),Set_properties.getAppAccum_file());
			FileWriter fw = new FileWriter(accumFile, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(" ");
			pw.println("'IP scanner 2.21' 로 집계한 정보를 보여줍니다.");
			pw.println(" ");
			pw.println("파일이름 : "+selectedFileName);
			pw.println("취합시간 : "+cf.currentTimeBaseYMD()+"    "+ registerTime());
			pw.println(" ");
			pw.println("총누적( "+allTotal+" )     비율(100%)      대상            .");
			pw.println("-------------------------------------------------------------------");
			for (int i = 1; i < userTable.length; i++) {
			pw.println("      "+extractAccumulation(selectedFileName,userTable[i][0])+"           "+percent[i]+"          "+userTable[i][0]);
			}
			
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			loginfo.txtWriterLogger("SaveFileHandler>>accumulation()의 오류 : "+e.getMessage());
		}
		
	}
	
	public int extractAccumulation(String selectedFileName, String selectedUserName){

		String contentLine ;
		String shortcontent;
		int total = 0;
		int tmp = 0;
		try {
			File accumFile = new File(Set_properties.getData_path(),selectedFileName);
			FileReader fr = new FileReader(accumFile);
			BufferedReader br = new BufferedReader(fr);
			
			// (?i) <- "찾을 문자열"에 대소문자 구분을 없애고
			// .*   <- 문자열이 행의 어디에 있든지 찾을 수 있게
			String findStr = "(?i).*" + selectedUserName + ".*";
			int lineNumber = 1; 

			while(br.ready()){

				contentLine = br.readLine();

				if (contentLine.matches(findStr)){
					shortcontent = contentLine.substring(29, 32).trim();
					if (!contentLine.isEmpty()) {
						tmp= Integer.parseInt(shortcontent);
						total += tmp;
//						System.out.format("%3d: %s%n", lineNumber,contentLine);
						lineNumber++; // 행 번호 증가
					}
				}
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			loginfo.txtWriterLogger("SaveFileHandler>>extractAccumulation()의 오류 : "+e.getMessage());
		}
		return total;
	}
	
}
