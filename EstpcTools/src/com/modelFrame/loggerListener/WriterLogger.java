package com.modelFrame.loggerListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.Set_properties;


public class WriterLogger implements LoggerListener {

	File file;
	FileWriter fw;
	CallFileHandler callFileHandler_properties;
	

	/**매 시점 현시간을 찍어 반환하는 메소드
	 * @return StringBuilder sb
	 */
	public StringBuilder calendar_timeStamp() {
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		int ms = cal.get(Calendar.MILLISECOND) ;
		
		sb.append("[");
		sb.append(year);
		sb.append(".");
		switch (Integer.toString(month).length()) {
		case 1 :
			String stringMonth = "0"+Integer.toString(month);
			sb.append(stringMonth);
			break;

		default:
			sb.append(month);
			break;
		}
		sb.append(".");
		
		switch (Integer.toString(date).length()) {
		case 1 :
			String stringDate= "0"+Integer.toString(date);
			sb.append(stringDate);
			break;

		default:
			sb.append(date);
			break;
		}
		sb.append("] ");
		sb.append("[");
		switch (Integer.toString(h).length()) {
		case 1 :
			String stringHour= "0"+Integer.toString(h);
			sb.append(stringHour);
			break;

		default:
			sb.append(h);
			break;
		}
		sb.append(":");
		
		switch (Integer.toString(m).length()) {
		case 1 :
			String stringMin= "0"+Integer.toString(m);
			sb.append(stringMin);
			break;

		default:
			sb.append(m);
			break;
		}
		sb.append(":");
		
		switch (Integer.toString(s).length()) {
		case 1 :
			String stringSen= "0"+Integer.toString(s);
			sb.append(stringSen);
			break;

		default:
			sb.append(s);
			break;
		}
		sb.append(" ");
		switch (Integer.toString(ms).length()) {
		case 1 :
			String stringMs= "00"+Integer.toString(ms);
			sb.append(stringMs);
			break;
			
		case 2 :
			String stringMss= "0"+Integer.toString(ms);
			sb.append(stringMss);
			break;

		default:
			sb.append(ms);
			break;
		}
		sb.append("]");

		return sb;
	}

	@Override
	public void xmlWriterLogger() {
	}


	/*
	 * 로그파일경로에 메세지 기록
	 */
	@Override
	public void txtWriterLogger(String Message)  {
		
		file = new File(Set_properties.getLog_path(), Set_properties.getLog_file());
		StringBuilder sb = calendar_timeStamp();
		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file, true);
			fw.write(sb + " " + Message+"\n");
			fw.close();

		} catch (IOException e) {
			System.out.println(sb + " " +"txtWriterLogger(String Message)의 에러 : "+ e.getMessage()+"\n");
		}

	}

}
