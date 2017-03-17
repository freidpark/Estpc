package com.estpcip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.modelFrame.fileHandler.CallFileHandler;
import com.modelFrame.fileHandler.HomeDisplay_panelMageHandler;
import com.modelFrame.fileHandler.SaveFileHandler;
import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.fileHandler.Set_properties;
import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeDisplay {

	private JFrame mainframe;
	private JTextField txtStoreName;
	private JTextField txt_sAclassIP;
	private JTextField txt_sBclassIP;
	private JTextField txt_sCclassIP;
	private JTextField txt_sDclassIP;
	private JTextField txt_eAclassIP;
	private JTextField txt_eBclassIP;
	private JTextField txt_eCclassIP;
	private JTextField txt_eDclassIP;
	private int collection_state = 0;
	private int combo_chooseMinute_getSelectedIndex = 0;
	private int timerPeriod;
	private int timerBetween;
	private int comboBox_quantity_getSelectedIndex = 0;
	private int bakQuantity;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String selectedFileName="";
	private String selectedUserName=" ";
	HashMap<Integer,String> listHashMap = new HashMap<Integer,String>();
	LoggerListener loginfo = new WriterLogger();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HomeDisplay window = new HomeDisplay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public HomeDisplay() {

		initialize();

		ServiceStarter ss = new ServiceStarter();
		ss.serviceStarter();

		loginfo.txtWriterLogger("== ## Step03 : Programming START !!!");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainframe = new JFrame();
		mainframe.setTitle("EstPC IP SCAN by cbpark");
		mainframe.setBounds(100, 100, 800, 600);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		mainframe.setJMenuBar(menuBar);

		JMenu mnMa = new JMenu("File");
		menuBar.add(mnMa);

		JMenuItem menuItem = new JMenuItem("인쇄");
		mnMa.add(menuItem);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("종료");
		mnMa.add(mntmNewMenuItem_5);

		JMenu mnNewMenu = new JMenu("Management");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("대상등록");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				UserManageFrame userManageFrame = new UserManageFrame();
			}
		});

		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Report");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("통합보고서");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("On-Line");
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Version");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		
		
//		탭 메뉴 시작
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainframe.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
//		prolog 탭 시작	
		JPanel panel_prolog = new JPanel();
		tabbedPane.addTab("Prolog   ", null, panel_prolog, null);

		JLabel lblNewLabel = new JLabel("여기는 prolog 입니다.");
		GroupLayout gl_panel_prolog = new GroupLayout(panel_prolog);
		gl_panel_prolog.setHorizontalGroup(
				gl_panel_prolog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_prolog.createSequentialGroup()
						.addGap(42)
						.addComponent(lblNewLabel)
						.addContainerGap(680, Short.MAX_VALUE))
				);
		gl_panel_prolog.setVerticalGroup(
				gl_panel_prolog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_prolog.createSequentialGroup()
						.addGap(52)
						.addComponent(lblNewLabel)
						.addContainerGap(445, Short.MAX_VALUE))
				);
		panel_prolog.setLayout(gl_panel_prolog);
		
//		관리 탭 시작
		JPanel panel_mage = new JPanel();
		tabbedPane.addTab("관리      ", null, panel_mage, null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC0AC\uC6A9\uC790 \uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_timer = new JPanel();
		panel_timer.setBorder(new TitledBorder(null, "\uD0C0\uC774\uBA38 \uC124\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_mage = new GroupLayout(panel_mage);
		gl_panel_mage.setHorizontalGroup(
			gl_panel_mage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_mage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_mage.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_mage.createSequentialGroup()
							.addComponent(panel_timer, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_mage.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 761, Short.MAX_VALUE)
							.addGap(6))))
		);
		gl_panel_mage.setVerticalGroup(
			gl_panel_mage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_mage.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_timer, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("* 동작주기 설정 : ");
		
		JComboBox combo_chooseMinute = new JComboBox();
		combo_chooseMinute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switch (combo_chooseMinute.getSelectedIndex()) {
				case 1 :
					JOptionPane.showMessageDialog(null, "20분 설정은 하루동안 총 72번 자동 반복됩니다.");
					combo_chooseMinute_getSelectedIndex = 1;
					timerBetween = 20;
					timerPeriod = 72;
					break;

				case 2:
					JOptionPane.showMessageDialog(null, "30분 설정은 하루동안 총 48번 자동 반복됩니다.");
					combo_chooseMinute_getSelectedIndex = 2;
					timerBetween = 30;
					timerPeriod = 48;
					break;
				}
			}
		});
		
		combo_chooseMinute.setModel(new DefaultComboBoxModel(new String[] {"분", "20분 ", "30분"}));
		
		JLabel lblNewLabel_3 = new JLabel("하루 동안 ");
		
		JLabel label_1 = new JLabel("간격으로 자동집계 하도록 ");
		
		JLabel lblveiw = new JLabel("현재값");
		lblveiw.setText("보기");
		
		JButton btnSettingSave = new JButton("설정저장");
		btnSettingSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(combo_chooseMinute_getSelectedIndex == 0 ){
					JOptionPane.showMessageDialog(null, "시간을 설정하세요.");
				}else{
					
					int YorN  = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "타이머 주기 저장", 0 );
					
					if (YorN == 0){
						HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
						homeDisplay_panelMageHandler.setTimerBetween(timerBetween);
						homeDisplay_panelMageHandler.setTimerPeriod(timerPeriod);
						
						lblveiw.setText("24시간 동안 /"+homeDisplay_panelMageHandler.getTimerBetween()+"분 간격 / 총"+homeDisplay_panelMageHandler.getTimerPeriod()+"회 집계 / "+homeDisplay_panelMageHandler.getFileQuantity()+"개 파일 보존");
					}
				}
				
			}
		});
		
		JLabel lblSd = new JLabel("* 현재 설정 값 :  ");
		
		JButton btnSdsd = new JButton("조회");
		btnSdsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
				lblveiw.setText("24시간 동안 /"+homeDisplay_panelMageHandler.getTimerBetween()+"분 간격 / 총"+homeDisplay_panelMageHandler.getTimerPeriod()+"회 집계 / "+homeDisplay_panelMageHandler.getFileQuantity()+"개 파일 보존");
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("* 집계파일 저장 갯수 설정 : ");
		
		JComboBox comboBox_quantity = new JComboBox();
		comboBox_quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (comboBox_quantity.getSelectedIndex()) {
				case 1 :
					JOptionPane.showMessageDialog(null, "최근 파일 1개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 1 ;
					bakQuantity = 1;
					break;

				case 2:
					JOptionPane.showMessageDialog(null, "최근 파일 2개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 2 ;
					bakQuantity = 2;
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "최근 파일 3개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 3 ;
					bakQuantity = 3;
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "최근 파일 4개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 4 ;
					bakQuantity = 4;
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "최근 파일 5개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 5 ;
					bakQuantity = 5;
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "최근 파일 6개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 6 ;
					bakQuantity = 6;
					break;
				case 7:
					JOptionPane.showMessageDialog(null, "최근 파일 7개만 자동 보존됩니다.");
					comboBox_quantity_getSelectedIndex = 7 ;
					bakQuantity = 7;
					break;
				}
			}
		});
		comboBox_quantity.setModel(new DefaultComboBoxModel(new String[] {"수량", "1", "2", "3", "4", "5", "6", "7"}));
		
		JLabel lblNewLabel_6 = new JLabel("최근");
		
		JLabel lblNewLabel_7 = new JLabel("개의 파일만 보존 하도록");
		
		JButton btnNewButton = new JButton("설정저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBox_quantity_getSelectedIndex == 0) {
					JOptionPane.showMessageDialog(null, "보존 파일의 갯수를 지정하세요.");
				}else{

					int YorN  = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "파일 보존 갯수 설정", 0 );

					if (YorN == 0){
						HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
						homeDisplay_panelMageHandler.setFileQuantity(bakQuantity);

						lblveiw.setText("24시간 동안 /"+homeDisplay_panelMageHandler.getTimerBetween()+"분 간격 / 총"+homeDisplay_panelMageHandler.getTimerPeriod()+"회 집계 / "+homeDisplay_panelMageHandler.getFileQuantity()+"개 파일 보존");
					}
				}
			}
		});
		
		GroupLayout gl_panel_timer = new GroupLayout(panel_timer);
		gl_panel_timer.setHorizontalGroup(
			gl_panel_timer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(lblSd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblveiw, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(combo_chooseMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(5)
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_quantity, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel_timer.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnSettingSave)
							.addComponent(btnSdsd, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(41))
		);
		gl_panel_timer.setVerticalGroup(
			gl_panel_timer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(btnSdsd)
							.addGap(36)
							.addComponent(btnSettingSave)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSd)
								.addComponent(lblveiw, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(combo_chooseMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(18)
							.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(comboBox_quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel_timer.setLayout(gl_panel_timer);
		
		JLabel lblStoreName = new JLabel("* 상호명 : ");
		
		JLabel lbl_IP = new JLabel("* IP등록 : ");
		
		JLabel lbl_sIP = new JLabel("시작 IP");
		
		JLabel lbl_eIP = new JLabel("종료 IP");
		
		JLabel lbl_ex = new JLabel("예) 192.168.10.1");
		
		txtStoreName = new JTextField();
		txtStoreName.setColumns(10);
		
		txt_sAclassIP = new JTextField();
		txt_sAclassIP.setColumns(10);
		
		txt_sBclassIP = new JTextField();
		txt_sBclassIP.setColumns(10);
		
		txt_sCclassIP = new JTextField();
		txt_sCclassIP.setColumns(10);
		
		txt_sDclassIP = new JTextField();
		txt_sDclassIP.setColumns(10);
		
		txt_eAclassIP = new JTextField();
		txt_eAclassIP.setColumns(10);
		
		txt_eBclassIP = new JTextField();
		txt_eBclassIP.setColumns(10);
		
		txt_eCclassIP = new JTextField();
		txt_eCclassIP.setColumns(10);
		
		txt_eDclassIP = new JTextField();
		txt_eDclassIP.setColumns(10);
		
		JButton button_sv = new JButton("등록/수정하기");
		button_sv.addActionListener(new ActionListener() {
			
			private String store_sIP;
			private String store_eIP;
			private int success; //0실패, 1등록,2수정
			private boolean frag = true; //모든 정보가 정상여부 판단
			
			public void actionPerformed(ActionEvent arg0) {

				CallFileHandler callFileHandler = new CallFileHandler();
				HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

				hashMap.put(1, txtStoreName.getText());
				hashMap.put(2, txt_sAclassIP.getText());
				hashMap.put(3, txt_sBclassIP.getText());
				hashMap.put(4, txt_sCclassIP.getText());
				hashMap.put(5, txt_sDclassIP.getText());
				hashMap.put(6, txt_eAclassIP.getText());
				hashMap.put(7, txt_eBclassIP.getText());
				hashMap.put(8, txt_eCclassIP.getText());
				hashMap.put(9, txt_eDclassIP.getText());

				for (int idkey : hashMap.keySet()){
					if( hashMap.get(idkey).equals("")){
						frag = false;
						if (idkey == 1){
							JOptionPane.showMessageDialog(null, "상호명 입력은 필수입니다.");
							break;
						}else {
							JOptionPane.showMessageDialog(null, "IP 입력은 필수 입니다.");
							break;
						}
					}else {
						frag = true;
					}
				}
				
				
				if(frag){

					store_sIP = "";
					store_sIP+=txt_sAclassIP.getText();
					store_sIP+=".";
					store_sIP+=txt_sBclassIP.getText();
					store_sIP+=".";
					store_sIP+=txt_sCclassIP.getText();
					store_sIP+=".";
					store_sIP+=txt_sDclassIP.getText();

					store_eIP = "";
					store_eIP+=txt_eAclassIP.getText();
					store_eIP+=".";
					store_eIP+=txt_eBclassIP.getText();
					store_eIP+=".";
					store_eIP+=txt_eCclassIP.getText();
					store_eIP+=".";
					store_eIP+=txt_eDclassIP.getText();

					success = callFileHandler.setStoreInfo(txtStoreName.getText(), store_sIP, store_eIP);

					if(success == 0){
						JOptionPane.showMessageDialog(null, "등록 실패!! 관리자에게 문의하세요.");
					}else if(success == 1){
						JOptionPane.showMessageDialog(null, "등록 되였습니다.");
					}else if(success == 2){
						JOptionPane.showMessageDialog(null, "수정 되였습니다.");
					}
				}
			}
		});
		
		JButton button_rw = new JButton("다시쓰기");
		button_rw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtStoreName.setText("");
				txt_sAclassIP.setText("");
				txt_sBclassIP.setText("");
				txt_sCclassIP.setText("");
				txt_sDclassIP.setText("");
				txt_eAclassIP.setText("");
				txt_eBclassIP.setText("");
				txt_eCclassIP.setText("");
				txt_eDclassIP.setText("");
				
			}
		});
		
		JLabel lbl_glassImg01 = new JLabel("");
		lbl_glassImg01.setIcon(new ImageIcon(HomeDisplay.class.getResource("/com/img/readingG_24.png")));

		
		JScrollPane scrollPane = new JScrollPane();
		
		DefaultComboBoxModel defaultComboUser = new DefaultComboBoxModel();
		defaultComboUser.addElement("등록된 정보를 선택하세요");
		
		//==========================================이 아래부분 다시 보기
		JComboBox comboBox_user = new JComboBox();
		
		comboBox_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedUserName = (String) defaultComboUser.getSelectedItem();

				HomeDisplay_panelMageHandler hp = new HomeDisplay_panelMageHandler();
				String[][] userTable ;
				
				try {

					//유저 목록 배열로 가져오기
					userTable = hp.getUserList();

					for (int j = 1; j < userTable.length; j++) {
						
						if (userTable[j][0].equalsIgnoreCase(selectedUserName)) {
							
							txtStoreName.setText(userTable[j][0]);
							
							txt_sAclassIP.setText(userTable[j][1].split("[.]")[0]);
							txt_sBclassIP.setText(userTable[j][1].split("[.]")[1]);
							txt_sCclassIP.setText(userTable[j][1].split("[.]")[2]);
							txt_sDclassIP.setText(userTable[j][1].split("[.]")[3]);
							
							txt_eAclassIP.setText(userTable[j][2].split("[.]")[0]);
							txt_eBclassIP.setText(userTable[j][2].split("[.]")[1]);
							txt_eCclassIP.setText(userTable[j][2].split("[.]")[2]);
							txt_eDclassIP.setText(userTable[j][2].split("[.]")[3]);
							
						}
					}				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR : 로그파일을 확인하세요.");
					loginfo.txtWriterLogger(e2.getMessage());
				}
			}
		});
		
		JButton button_searching = new JButton("조회");
		button_searching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				HashMap<Integer,String> renewHashMap = new HashMap<Integer,String>();
				HomeDisplay_panelMageHandler hp = new HomeDisplay_panelMageHandler();
				String[][] userTable ;
				try {

					//유저 목록 배열로 가져오기
					userTable = hp.getUserList();
					
					//파일 목록 갱신
					defaultComboUser.removeAllElements();
					defaultComboUser.addElement("=대상자를 불러왔습니다.=");
										
					for (int j = 1; j < userTable.length; j++) {
						defaultComboUser.addElement(userTable[j][0]);
					}
					
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "ERROR : 로그파일을 확인하세요.");
					loginfo.txtWriterLogger(ee.getMessage());
				}
				
			}
		});
		comboBox_user.setModel(defaultComboUser);
		
		JButton btnNewButton_2 = new JButton("삭제하기");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "개발중.. 당분간..수정하기 기능으로 덮어쓰세요");
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStoreName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtStoreName, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbl_IP)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_ex, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbl_eIP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_sIP, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txt_sAclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_sBclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_sCclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(txt_sDclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(txt_eAclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txt_eBclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txt_eCclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txt_eDclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(button_rw)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(button_sv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
					.addGap(59)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_glassImg01)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_user, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(button_searching, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_searching)
							.addComponent(comboBox_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lbl_glassImg01)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStoreName)
							.addComponent(txtStoreName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_IP)
								.addComponent(lbl_ex))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(txt_sAclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txt_sBclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txt_sCclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txt_sDclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_sIP))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_eAclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_eBclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_eCclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_eDclassIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_eIP))
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_sv)
								.addComponent(button_rw))
							.addGap(18)
							.addComponent(btnNewButton_2))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panel_mage.setLayout(gl_panel_mage);

		
		
		
		
//		===== 통계 탭 시작 ========================================================	
		JPanel panel_static = new JPanel();
		tabbedPane.addTab("통계      ", null, panel_static, null);

		JLabel lblNewLabel_1 = new JLabel("* [집계 상태] ");
		
		JLabel lblDfdf = new JLabel("프로그램을 시작하세요.");
		
		JScrollPane scrollPane_log = new JScrollPane();
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("집계 시작");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int YorN  = JOptionPane.showConfirmDialog(null, "집계를 실행하겠습니까?", "집계시작", 0 );

				if (YorN == 0){

					if (collection_state == 0) {

						HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
						homeDisplay_panelMageHandler.btnCollection();

						collection_state = 1;
						lblDfdf.setText("## 집계 중 입니다. ##");

					}else{
						JOptionPane.showMessageDialog(null, "집계 중 입니다... 중지하고 재실행 하십시오.");
					}
				}
			}
		});
		
		DefaultComboBoxModel defaultComboModel = new DefaultComboBoxModel();
		defaultComboModel.addElement("목록을 조회하세요.");
		DefaultListModel defaultListModel_jlist_view = new DefaultListModel();
		
		JButton btnOpenFolder = new JButton("내용보기");
		btnOpenFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File file = new File(Set_properties.getData_path(),selectedFileName);

					if (selectedFileName =="" || selectedFileName.equalsIgnoreCase("=없는 파일은 재조회 하세요=") ) {
						JOptionPane.showMessageDialog(null,  "파일을 선택하세요.");
					}else if( !file.exists() ){
						JOptionPane.showMessageDialog(null,  "파일이 없습니다. 재조회하세요.");
					}else{
						//리스트 목록 갱신
						defaultListModel_jlist_view.removeAllElements();;
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);

						for (int i = 0 ; br.ready() ; i++) {
							defaultListModel_jlist_view.addElement(br.readLine());
						}

					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,  "ERROR : 로그 파일을 확인하세요.");
					loginfo.txtWriterLogger(e.getMessage());
				}
				
			}
		});
		
		JList jlist_view = new JList();

		
		JButton btnRefresh_log = new JButton("조  회");
		btnRefresh_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap<Integer,String> renewHashMap = new HashMap<Integer,String>();
				try {

					//집계파일 설정값대로 자동 지우기
					HomeDisplay_panelMageHandler hp = new HomeDisplay_panelMageHandler();
					SaveFileHandler saveFileHandler = new SaveFileHandler();
					saveFileHandler.autoDeleted(Integer.parseInt(hp.getFileQuantity()));
					
					//파일 목록 갱신
					File file = new File(Set_properties.getData_path());
					String[] stringList = file.list();
					
					defaultComboModel.removeAllElements();
					defaultComboModel.addElement("=없는 파일은 재조회 하세요=");
					
					
					for (int j = 0; j < stringList.length; j++) {
						defaultComboModel.addElement(stringList[j]);
					}
					
				
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "[새로고침]의 오류"+e.getMessage());
				}
			}
		});
		
		JButton btnStopCollection = new JButton("집계 중지");
		btnStopCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					int YorN  = JOptionPane.showConfirmDialog(null, "중지 하시겠습니까?", "집계중지", 0 );
					
					if (YorN == 0){
						
						HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
						homeDisplay_panelMageHandler.btnStopCollection();
						collection_state = 0;
						lblDfdf.setText("프로그램을 시작하세요.");
					}
			}
		});
		
		JComboBox comboBox_fileInfo = new JComboBox();
		comboBox_fileInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedFileName = (String) defaultComboModel.getSelectedItem();
				
			}
		});
		comboBox_fileInfo.setModel(defaultComboModel);
		
		
		JLabel lblNewLabel_4 = new JLabel("# 파일 목록 : ");
		
		JButton btnOpenData = new JButton("폴더열기");
		btnOpenData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String openCommand = "cmd /c explorer "+Set_properties.getData_path();
				
				try {
					Runtime.getRuntime().exec(openCommand);				
					loginfo.txtWriterLogger(openCommand+" 명령어 실행됨");
				} catch (Exception e) {
					loginfo.txtWriterLogger(e.getMessage());
				}
				
			}
		});
		

		
		JButton btnNewButton_1 = new JButton("로그보기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File file = new File(Set_properties.getLog_path(),Set_properties.getLog_file());

					if( !file.exists() ){
						JOptionPane.showMessageDialog(null,  "파일이 없습니다.");
					}else{
						//리스트 목록 갱신
						defaultListModel_jlist_view.removeAllElements();;
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);

						for (int i = 0 ; br.ready() ; i++) {
							defaultListModel_jlist_view.addElement(br.readLine());
						}
					}
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,  "ERROR : 로그 파일을 확인하세요.");
					loginfo.txtWriterLogger(ex.getMessage());
				}
				
			}
		});
		
		GroupLayout gl_panel_static = new GroupLayout(panel_static);
		gl_panel_static.setHorizontalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_log, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_static.createSequentialGroup()
							.addGroup(gl_panel_static.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_static.createSequentialGroup()
									.addGap(10)
									.addComponent(tglbtnNewToggleButton)
									.addGap(18)
									.addComponent(btnStopCollection))
								.addGroup(gl_panel_static.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDfdf, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
							.addGap(72)
							.addGroup(gl_panel_static.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_static.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRefresh_log)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addGroup(gl_panel_static.createSequentialGroup()
									.addComponent(comboBox_fileInfo, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnOpenFolder)
									.addGap(18)
									.addComponent(btnOpenData)))
							.addGap(1)))
					.addGap(20))
		);
		gl_panel_static.setVerticalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_4)
						.addComponent(btnRefresh_log)
						.addComponent(lblDfdf)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnNewToggleButton)
						.addComponent(btnStopCollection)
						.addComponent(comboBox_fileInfo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpenFolder)
						.addComponent(btnOpenData))
					.addGap(27)
					.addComponent(scrollPane_log, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
					.addGap(18))
		);
		
		
		jlist_view.setModel(defaultListModel_jlist_view);
		scrollPane_log.setViewportView(jlist_view);
		panel_static.setLayout(gl_panel_static);

	}
	
}
