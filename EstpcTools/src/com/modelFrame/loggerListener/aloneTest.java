package com.modelFrame.loggerListener;

import java.io.File;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.modelFrame.fileHandler.HomeDisplay_panelMageHandler;
import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.fileHandler.Set_properties;

public class aloneTest {

	
	
	public static void main(String[] args) {

		try {
			ServiceStarter ss = new ServiceStarter();
			ss.serviceStarter();
		
		File file = new File(Set_properties.getData_path());
//		String[] list = file.list();
//		
//		int b;
//		int[] c = new int[list.length];
//		for (int i = 0; i < list.length; i++) {
//
//			String[] aa = list[i].split("_");
//							
//							String a = aa[1];
//							 b = Integer.parseInt(a.substring(0, 8));
//							 System.out.println(b);
//							 c[i] = b;
//
//		}
//			
//			//버블정렬
//			int tmp = 0 ;
//			for (int i = list.length; i > 1; i--) {
//				for (int j = 1; j < i; j++) {
//					if (c[j-1]>c[j]){
//						tmp = c[j-1];
//						c[j-1] = c[j];
//						c[j] =tmp;
//					}
//			}
//			
//			for (int m = 0; m < c.length; m++) {
//				System.out.println(c[m]);
//			}
//			
//			}
			
		
		
		
//		String a = "192.168.10.1";
//		String[] b	= a.split("[.]");
//				System.out.println("돈다");
//				System.out.println(b.length);
//		for (int i = 0; i < b.length; i++) {
//					System.out.println(b[i]);
//					System.out.println("돌고있니?");
//		}
		
//		System.out.println(a.split(".")[1]);
		
		
		HomeDisplay_panelMageHandler hp = new HomeDisplay_panelMageHandler();
		String[][] userTable ;
		

		//유저 목록 배열로 가져오기
		userTable = hp.getUserList();
		System.out.println("start");
		if ("우리" == "=대상자를 불러왔습니다.=") {
			JOptionPane.showMessageDialog(null, "사용자를 선택하세요.");
			System.out.println("if안");
		}else{
			System.out.println("else 시작");
			System.out.println( userTable.length);
			for (int j = 1; j < userTable.length; j++) {
				System.out.println(userTable[j][1].split("[.]")[0]);
				System.out.println(userTable[j][0]);

				if ("우리".equalsIgnoreCase(userTable[j][0])) {
					
					System.out.println("true");

					System.out.println(userTable[j][1].split("[.]")[0]);

					//						txtStoreName.setText(userTable[j][0]);
//
//						txt_sAclassIP.setText(userTable[j][1].split("[.]")[0]);
//						txt_sBclassIP.setText(userTable[j][1].split("[.]")[1]);
//						txt_sCclassIP.setText(userTable[j][1].split("[.]")[2]);
//						txt_sDclassIP.setText(userTable[j][1].split("[.]")[3]);
//
//						txt_eAclassIP.setText(userTable[j][2].split("[.]")[0]);
//						txt_eBclassIP.setText(userTable[j][2].split("[.]")[1]);
//						txt_eCclassIP.setText(userTable[j][2].split("[.]")[2]);
//						txt_eDclassIP.setText(userTable[j][2].split("[.]")[3]);

						
					}
				}				
			}
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}