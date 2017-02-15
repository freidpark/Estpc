package com.modelFrame.loggerListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.Set_properties;


public class writerLogger implements LoggerListener {

	File file;
	FileWriter fw;
	CallFileHandler callFileHandler_properties;
	

	/**매 시점 현시간을 찍어 반환하는 메소드
	 * @return StringBuilder sb
	 */
	public StringBuilder calendar_timeStamp() {
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(cal.get(Calendar.YEAR));
		sb.append(".");
		sb.append(cal.get(Calendar.MONTH) + 1);
		sb.append(".");
		sb.append(cal.get(Calendar.DATE));
		sb.append("] ");
		sb.append("[");
		sb.append(cal.get(Calendar.HOUR_OF_DAY));
		sb.append(":");
		sb.append(cal.get(Calendar.MINUTE));
		sb.append(":");
		sb.append(cal.get(Calendar.SECOND));
		sb.append(" ");
		sb.append(cal.get(Calendar.MILLISECOND));
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
