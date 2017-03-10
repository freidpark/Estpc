package com.estpcip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.fileHandler.Set_properties;
import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.WriterLogger;

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
	private JTextField txt_searchWord;
	private JTable table_userList;
	private int timerPeriod;
	private int timerBetween;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String selectedFileName;
	
	

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

		LoggerListener loginfo = new WriterLogger();

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
				UserManageFrame userManageFrame = new UserManageFrame();

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
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 761, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_panel_mage.createSequentialGroup()
							.addComponent(panel_timer, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(238, Short.MAX_VALUE))))
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
					timerBetween = 20;
					timerPeriod = 72;
					break;

				case 2:
					JOptionPane.showMessageDialog(null, "30분 설정은 하루동안 총 48번 자동 반복됩니다.");
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
				
				int YorN  = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "타이머 주기 저장", 0 );
				
				if (YorN == 0){
					HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
					homeDisplay_panelMageHandler.setTimerBetween(timerBetween);
					homeDisplay_panelMageHandler.setTimerPeriod(timerPeriod);
					
					lblveiw.setText("24시간 동안 /"+homeDisplay_panelMageHandler.getTimerBetween()+"분 간격 / 총"+homeDisplay_panelMageHandler.getTimerPeriod()+"회 집계");
				}
			}
		});
		
		JLabel lblSd = new JLabel("* 현재 설정 값 :  ");
		
		JButton btnSdsd = new JButton("조회");
		btnSdsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
				lblveiw.setText("24시간 동안 /"+homeDisplay_panelMageHandler.getTimerBetween()+"분 간격 / 총"+homeDisplay_panelMageHandler.getTimerPeriod()+"회 집계");
				
			}
		});
		
		GroupLayout gl_panel_timer = new GroupLayout(panel_timer);
		gl_panel_timer.setHorizontalGroup(
			gl_panel_timer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(combo_chooseMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addComponent(lblSd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblveiw, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_timer.createSequentialGroup()
							.addComponent(btnSettingSave)
							.addGap(19))
						.addGroup(gl_panel_timer.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSdsd, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_timer.setVerticalGroup(
			gl_panel_timer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSd)
						.addComponent(lblveiw, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSdsd))
					.addGap(36)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(combo_chooseMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSettingSave)
						.addComponent(label_1))
					.addContainerGap(44, Short.MAX_VALUE))
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
		
		JLabel lbl_glassImg01 = new JLabel("");
		lbl_glassImg01.setIcon(new ImageIcon(HomeDisplay.class.getResource("/com/img/readingG_24.png")));
		
		txt_searchWord = new JTextField();
		txt_searchWord.setColumns(10);
		
		JButton button_searching = new JButton("검색");
		
		JScrollPane scrollPane = new JScrollPane();
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
								.addComponent(lbl_eIP)
								.addComponent(lbl_sIP, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txt_sAclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_sBclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_sCclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(txt_sDclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txt_eAclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_eBclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_eCclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txt_eDclassIP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_sv)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_rw)))))
					.addGap(59)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_glassImg01)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_searchWord, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
							.addGap(18)
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
							.addComponent(txt_searchWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_searching))
						.addComponent(lbl_glassImg01)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStoreName)
							.addComponent(txtStoreName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
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
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_sv)
								.addComponent(button_rw)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table_userList = new JTable();
		scrollPane.setViewportView(table_userList);
		table_userList.setModel(new DefaultTableModel(
			new Object[][] {
				{"\uD589\uBCF5\uD574", "192.168.10.1", "192.168.10.255", "2017-02-15", "2017-02-16"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uC0C1\uD638\uBA85", "\uC2DC\uC791IP", "\uC885\uB8CCIP", "\uCD5C\uCD08\uB4F1\uB85D\uC77C\uC790", "\uCD5C\uC885\uC218\uC815\uC77C\uC790"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_userList.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(gl_panel);
		panel_mage.setLayout(gl_panel_mage);

		
		
		
		
//		===== 통계 탭 시작 ========================================================	
		JPanel panel_static = new JPanel();
		tabbedPane.addTab("통계      ", null, panel_static, null);

		JLabel lblNewLabel_1 = new JLabel("* [통 계] ");
		
		JScrollPane scrollPane_log = new JScrollPane();
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("집계 시작");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
				homeDisplay_panelMageHandler.btnCollection();
			}
		});
		
		JButton btnOpenFolder = new JButton("폴더열기");
		
		JButton btnRefresh_log = new JButton("새로고침");
		JList jlist_view = new JList();
		DefaultListModel defaultListModel_jlist_view = new DefaultListModel();
		
		btnRefresh_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(Set_properties.getData_path(),selectedFileName);
				try {
					if (!file.exists()) {
						JOptionPane.showMessageDialog(null,  "파일이 존재 하지 않습니다.");
					}
					
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					defaultListModel_jlist_view.removeAllElements();;
					
					for (int i = 0 ; br.ready() ; i++) {
						defaultListModel_jlist_view.addElement(br.readLine());
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "HomeDisplay_panelMageHandler.getfileCheck()의 오류"+e.getMessage());
				}
			}
		});
		
		JButton btnStopCollection = new JButton("집계 멈춤");
		btnStopCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeDisplay_panelMageHandler homeDisplay_panelMageHandler = new HomeDisplay_panelMageHandler();
				homeDisplay_panelMageHandler.btnStopCollection();
				
			}
		});
		
		JComboBox comboBox_fileInfo = new JComboBox();
		
		DefaultComboBoxModel defaultComboModel = new DefaultComboBoxModel();
		defaultComboModel.addElement("파일을 선택하세요.");
		
		String current_path = System.getProperty("user.dir");
		File ab_estpc_properties = new File(current_path+"\\data");
		String[] stringList = ab_estpc_properties.list();
		HashMap<Integer,String> listHashMap = new HashMap<Integer,String>();

		for (int j = 0; j < stringList.length; j++) {
			listHashMap.put(j+1, stringList[j]);
		}

		if (defaultComboModel.getSize()<2) {
			
			for (int idkey = 1; idkey < listHashMap.size()+1; idkey++) {
					defaultComboModel.addElement(listHashMap.get(idkey));
			}
			
		}else{
			
			for (int i = 1; i < defaultComboModel.getSize(); i++) {
				
				for (int idkey = 1; idkey < listHashMap.size()+1; idkey++) {
					
					if (	!defaultComboModel.getElementAt(i).equals(listHashMap.get(idkey))) {
						defaultComboModel.addElement(listHashMap.get(idkey));
					}
				}
			}
		}
		
		comboBox_fileInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				selectedFileName = (String) defaultComboModel.getSelectedItem();
				
			}
		});
		
		
//		comboBox_fileInfo.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//
//				JOptionPane.showMessageDialog(null, defaultComboModel.getSelectedItem());
//				
//			}
//		});
		
		comboBox_fileInfo.setModel(defaultComboModel);
		
		GroupLayout gl_panel_static = new GroupLayout(panel_static);
		gl_panel_static.setHorizontalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_log, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addGroup(gl_panel_static.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tglbtnNewToggleButton)
							.addGap(18)
							.addComponent(btnStopCollection)
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
							.addComponent(comboBox_fileInfo, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRefresh_log)
							.addGap(18)
							.addComponent(btnOpenFolder)))
					.addGap(36))
		);
		gl_panel_static.setVerticalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnNewToggleButton)
						.addComponent(btnOpenFolder)
						.addComponent(lblNewLabel_1)
						.addComponent(btnStopCollection)
						.addComponent(btnRefresh_log)
						.addComponent(comboBox_fileInfo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(27, 27, Short.MAX_VALUE)
					.addComponent(scrollPane_log, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addGap(18))
		);
		
		
		jlist_view.setModel(defaultListModel_jlist_view);
		scrollPane_log.setViewportView(jlist_view);
		panel_static.setLayout(gl_panel_static);

	}
}
