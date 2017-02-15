package com.modelFrame.fileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.writerLogger;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XML11Serializer;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Set_properties  {
	
	private static String log_path;
	private static String log_file;
	private static String userStore_path;
	private static String userStore_file;
	
	private static String current_path;
	private static File estpc_propertiese;

	
	public static void start() {

		getProperty_SystemInfo();
		callGetSetProperty_Info();
		LoggerListener loginfo = new writerLogger();
		loginfo.txtWriterLogger(" == #### Programming is loading to start... ####");
		loginfo.txtWriterLogger(" == ## Step01 : Getting System-properties ...");
		loginfo.txtWriterLogger(" == ## Step02 : Properties have been loaded...");
	}


	private static void getProperty_SystemInfo(){

		current_path = System.getProperty("user.dir");
		estpc_propertiese = new File(current_path+"\\properties", "estpc_properties.xml");

		String jVersion = System.getProperty("java.version"); 
		String jVendor = System.getProperty("java.vendor"); 
		String jVendor_url = System.getProperty("java.vendor.url");
		String jHome = System.getProperty("java.home");
		String jClass_version = System.getProperty("java.class.version");
		String jClass_path = System.getProperty("java.class.path");
		String osName = System.getProperty("os.name");
		String osArch = System.getProperty("os.arch");
		String osVersion = System.getProperty("os.version");
		String fileSeparator = System.getProperty("file.separator");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		String userDir = System.getProperty("user.dir");

		try {
			HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_propertiese);
			NodeList nodelist_requestInfo = document.getElementsByTagName("requestInfo");

			boolean doOrNot = false ; // system_info xml정보를 수정할지 삽입할지 결정

			for (int i = 0; i < nodelist_requestInfo.getLength(); i++) {// 해쉬맵에  id를 모두 저장한다
				Element element_requestInfo = (Element) document.getElementsByTagName("requestInfo").item(i);
				hashMap.put(i+1, element_requestInfo.getAttribute("id"));
			}

			for(int idkey : hashMap.keySet()){// 저장된 해쉬맵에서 값이 있는지 비교한다.
				
				if(hashMap.get(idkey).equals("system_info")){
					doOrNot = true;
					break;
				}
			}
			

			if (doOrNot) {//system_info 정보를 수정한다

				document.getElementsByTagName("java.version").item(0).setTextContent(jVersion);
				document.getElementsByTagName("java.vendor").item(0).setTextContent(jVendor);
				document.getElementsByTagName("java.vendor.url").item(0).setTextContent(jVendor_url);
				document.getElementsByTagName("java.home").item(0).setTextContent(jHome);
				document.getElementsByTagName("java.class.version").item(0).setTextContent(jClass_version);
				document.getElementsByTagName("java.class.path").item(0).setTextContent(jClass_path);
				document.getElementsByTagName("os.name").item(0).setTextContent(osName);
				document.getElementsByTagName("os.arch").item(0).setTextContent(osArch);
				document.getElementsByTagName("os.version").item(0).setTextContent(osVersion);
				document.getElementsByTagName("jfile.separator").item(0).setTextContent(fileSeparator);
				document.getElementsByTagName("user.name").item(0).setTextContent(userName);
				document.getElementsByTagName("user.home").item(0).setTextContent(userHome);
				document.getElementsByTagName("userDir").item(0).setTextContent(userDir);

			}else{

				Element elementMK_requestInfo = document.createElement("requestInfo");

				elementMK_requestInfo.setAttribute("id", "system_info");

				Element element_jVersion  = document.createElement("java.version");
				element_jVersion.appendChild(document.createTextNode(jVersion));
				elementMK_requestInfo.appendChild(element_jVersion);
				Element element_jVendor  = document.createElement("java.vendor");
				element_jVendor.appendChild(document.createTextNode(jVendor));
				elementMK_requestInfo.appendChild(element_jVendor);
				Element element_jVendor_url  = document.createElement("java.vendor.url");
				element_jVendor_url.appendChild(document.createTextNode(jVendor_url));
				elementMK_requestInfo.appendChild(element_jVendor_url);
				Element element_jHome  = document.createElement("java.home");
				element_jHome.appendChild(document.createTextNode(jHome));
				elementMK_requestInfo.appendChild(element_jHome);
				Element element_jClass_version  = document.createElement("java.class.version");
				element_jClass_version.appendChild(document.createTextNode(jClass_version));
				elementMK_requestInfo.appendChild(element_jClass_version);
				Element element_jClass_path  = document.createElement("java.class.path");
				element_jClass_path.appendChild(document.createTextNode(jClass_path ));
				elementMK_requestInfo.appendChild(element_jClass_path);
				Element element_osName  = document.createElement("os.name");
				element_osName.appendChild(document.createTextNode(osName));
				elementMK_requestInfo.appendChild(element_osName);
				Element element_osArch  = document.createElement("os.arch");
				element_osArch.appendChild(document.createTextNode(osArch));
				elementMK_requestInfo.appendChild(element_osArch);
				Element element_osVersion  = document.createElement("os.version");
				element_osVersion.appendChild(document.createTextNode(osVersion));
				elementMK_requestInfo.appendChild(element_osVersion);
				Element element_fileSeparator  = document.createElement("file.separator");
				element_fileSeparator.appendChild(document.createTextNode(fileSeparator));
				elementMK_requestInfo.appendChild(element_fileSeparator);
				Element element_userName  = document.createElement("user.name");
				element_userName.appendChild(document.createTextNode(userName));
				elementMK_requestInfo.appendChild(element_userName);
				Element element_userHome = document.createElement("user.home");
				element_userHome.appendChild(document.createTextNode(userHome));
				elementMK_requestInfo.appendChild(element_userHome);
				Element element_userDir  = document.createElement("user.dir");
				element_userDir.appendChild(document.createTextNode(userDir));
				elementMK_requestInfo.appendChild(element_userDir);

				document.getElementsByTagName("ui-query-mapping").item(0).appendChild(elementMK_requestInfo);

			}
			
			//로그 및 유저 파일 경로 업데이트
			document.getElementsByTagName("log_path").item(0).setTextContent(current_path+"\\log");
			document.getElementsByTagName("userStore_path").item(0).setTextContent(current_path+"\\properties");
			

			FileOutputStream fos = new FileOutputStream(estpc_propertiese);
			OutputFormat outputFormat = new OutputFormat(document);
			outputFormat.setIndenting(true);

			XMLSerializer xmlSerializer = new XML11Serializer(fos, outputFormat);
			xmlSerializer.serialize(document);

			fos.close();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * "estpc/com/properties/estpc_properties.xml"에서 로그 정보를 불러온다.
	 * setLog_file(log_file) setLog_path(log_path)
	 */
	private static void callGetSetProperty_Info() {
		Element element_requestInfo = null;
		String requestInfo_id = null;
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(estpc_propertiese);

			NodeList node_requestInfo = document.getElementsByTagName("requestInfo");

			for (int i = 0; i < node_requestInfo.getLength(); i++) {

				element_requestInfo = (Element) node_requestInfo.item(i);
				requestInfo_id = element_requestInfo.getAttribute("id");

				switch (requestInfo_id) {
				case "log_info":
					log_path = element_requestInfo
					.getElementsByTagName("log_path").item(0)
					.getTextContent();
					log_file = element_requestInfo
							.getElementsByTagName("log_file").item(0)
							.getTextContent();
					break;

				case "userStore_info":
					userStore_path = element_requestInfo
					.getElementsByTagName("userStore_path").item(0)
					.getTextContent();
					userStore_file = element_requestInfo
							.getElementsByTagName("userStore_file").item(0)
							.getTextContent();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getLog_path() {
		return log_path;
	}

	public static String getLog_file() {
		return log_file;
	}
	public static String getUserStore_path() {
		return userStore_path;
	}
	public static String getUserStore_file() {
		return userStore_file;
	}

	public static String getCurrent_path() {
		return current_path;
	}

	//	public static void setCurrent_path(String current_path) {
	//		Set_properties.current_path = current_path;
	//	}
	//
	//	public static void setLog_path(String log_path) {
	//		Set_properties.log_path = log_path;
	//	}
	//
	//	public static void setLog_file(String log_file) {
	//		Set_properties.log_file = log_file;
	//	}
	//
	//	public static void setUserStore_path(String userStore_path) {
	//		Set_properties.userStore_path = userStore_path;
	//	}
	//
	//	public static void setUserStore_file(String userStore_file) {
	//		Set_properties.userStore_file = userStore_file;
	//	}

}
