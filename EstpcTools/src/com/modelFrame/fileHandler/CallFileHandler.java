package com.modelFrame.fileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class CallFileHandler  {

	private final File estpc_dataMap ;
	public LoggerListener loginfo;


	public CallFileHandler() {
		estpc_dataMap = new File(Set_properties.getUserStore_path(),Set_properties.getUserStore_file());
		loginfo = new WriterLogger();
	}

	public void getStoreInfo(){

		String store_num_id = null;
		Element element_requestInfo = null;
		String requestInfo_id= null;
		Element element_store_num = null;

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_dataMap);
			NodeList node_requestInfo = document.getElementsByTagName("requestInfo");

			for (int i = 0; i < node_requestInfo.getLength(); i++) {
				element_requestInfo = (Element) node_requestInfo.item(i);
				requestInfo_id = element_requestInfo.getAttribute("id");

				if (requestInfo_id.equals("store")) {
					NodeList node_store_num = document.getElementsByTagName("store_num");

					for (int j = 0; j < node_store_num.getLength(); j++) {
						element_store_num= (Element) node_store_num.item(j);
						store_num_id =  element_store_num.getAttribute("id");

						switch (store_num_id) {
						case "1001":

							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_name").item(0).getTextContent());           
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_sIP").item(0).getTextContent());            
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_eIP").item(0).getTextContent());            
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_regitDay").item(0).getTextContent());       
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_modifiDay").item(0).getTextContent());      

							break;

						case "1002":

							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_name").item(0).getTextContent());           
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_sIP").item(0).getTextContent());            
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_eIP").item(0).getTextContent());            
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_regitDay").item(0).getTextContent());       
							loginfo.txtWriterLogger(element_store_num.getElementsByTagName("store_modifiDay").item(0).getTextContent());      

							break;

						default:
							loginfo.txtWriterLogger("찾고자하는 store_num_id의 ["+store_num_id+"]값이 없습니다.");
							break;
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("에러입니다." + e.getMessage());
		}
	}



	public int setStoreInfo(String store_name, String store_sIP, String store_eIP) {
		
		boolean existOrNot = false;
		int result = 0; //0실패, 1등록, 2수정
		Element element_store_num;
		HashMap<Integer, String > hashMap = new HashMap<Integer, String>();

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_dataMap);
			
			for (int i = 0; i < document.getElementsByTagName("store_num").getLength(); i++) {
				element_store_num = (Element) document.getElementsByTagName("store_num").item(i);
				hashMap.put(i+1, element_store_num.getAttribute("id"));
			}
			
			for(int idkey : hashMap.keySet()){//존재 여부 판단
				
				if (hashMap.get(idkey).equals(store_name)){
					
					existOrNot = true;
					break;
				}
			}
			
			// 여기서 부터 코딩~~
			
			if(existOrNot){//엘러먼트를 수정
				
				for (int i = 0; i < document.getElementsByTagName("store_num").getLength(); i++) {
					Element sameElement = (Element) document.getElementsByTagName("store_num").item(i);
					if(sameElement.getAttribute("id").equals(store_name)){
						
						document.getElementsByTagName("store_name").item(i).setTextContent(store_name);
						document.getElementsByTagName("store_sIP").item(i).setTextContent(store_sIP);
						document.getElementsByTagName("store_eIP").item(i).setTextContent(store_eIP);
						document.getElementsByTagName("store_modifiDay").item(i).setTextContent(currentTimeBaseYMD().toString());
						
					}
				}
				
				result = 2;

			}else{// 엘러먼트 생성
				
				Element mkElement_store_num = document.createElement("store_num");
				mkElement_store_num.setAttribute("id", store_name);

				Element element_store_name = document.createElement("store_name");
				element_store_name.appendChild(document.createTextNode(store_name));
				mkElement_store_num.appendChild(element_store_name);
				Element element_store_sIP = document.createElement("store_sIP");
				element_store_sIP.appendChild(document.createTextNode(store_sIP));
				mkElement_store_num.appendChild(element_store_sIP);
				Element element_store_eIP = document.createElement("store_eIP");
				element_store_eIP.appendChild(document.createTextNode(store_eIP));
				mkElement_store_num.appendChild(element_store_eIP);
				Element element_store_regitDay = document.createElement("store_regitDay");
				element_store_regitDay.appendChild(document.createTextNode(currentTimeBaseYMD().toString()));
				mkElement_store_num.appendChild(element_store_regitDay);
				Element element_store_modifiDay = document.createElement("store_modifiDay");
				element_store_modifiDay.appendChild(document.createTextNode(""));
				mkElement_store_num.appendChild(element_store_modifiDay);

				document.getElementsByTagName("user").item(0).appendChild(mkElement_store_num);
				
				result = 1;
			}
			
			/**
			 * OutputFormat 및 FileOutputStream를 이용하여 xmlSerializer로 xml 파일 쓰기
			 * 장점 : 출력파일이 표준 xml layout 으로 출력되어 보기가 좋다.
			 */
			FileOutputStream fos = new FileOutputStream(estpc_dataMap);

			OutputFormat outputFormat = new OutputFormat(document);
			outputFormat.setIndenting(true);

			XMLSerializer xmlSerializer = new XMLSerializer(fos, outputFormat);
			xmlSerializer.serialize(document);

			fos.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("CallFileHandler.setStoreInfo()의 에러 : "+e.getMessage());
			result = 0;
		}

		return result;
	}
	
	public StringBuilder currentTimeBaseYMD(){
		
		Calendar cal = Calendar.getInstance();
		StringBuilder BaseYMD = new StringBuilder();
		BaseYMD.append(cal.get(Calendar.YEAR));
		BaseYMD.append("-");
		BaseYMD.append(cal.get((Calendar.MONTH))+1);
		BaseYMD.append("-");
		BaseYMD.append(cal.get(Calendar.DATE));
		
		return BaseYMD;
		
	}
	


}
