package com.estpcip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
							.addComponent(panel_timer, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"분", "20", "30"}));
		
		JLabel lblNewLabel_3 = new JLabel("하루 동안 ");
		
		JLabel label_1 = new JLabel("분 간격으로 집계 하도록 ");
		
		JButton btnNewButton = new JButton("설정저장");
		
		JLabel lblSd = new JLabel("* 현재 설정은 ");
		
		JLabel lbl_timer_view = new JLabel("time_view");
		GroupLayout gl_panel_timer = new GroupLayout(panel_timer);
		gl_panel_timer.setHorizontalGroup(
			gl_panel_timer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_timer.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_timer.createSequentialGroup()
								.addComponent(lblSd)
								.addGap(273))
							.addGroup(gl_panel_timer.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton)
								.addGap(43)))
						.addGroup(Alignment.TRAILING, gl_panel_timer.createSequentialGroup()
							.addComponent(lbl_timer_view)
							.addGap(160))))
		);
		gl_panel_timer.setVerticalGroup(
			gl_panel_timer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_timer.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_timer_view)
					.addGap(21)
					.addComponent(lblSd)
					.addGap(36)
					.addGroup(gl_panel_timer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(label_1)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(54, Short.MAX_VALUE))
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

//		통계 탭 시작	
		JPanel panel_static = new JPanel();
		tabbedPane.addTab("통계      ", null, panel_static, null);

		JLabel lblNewLabel_1 = new JLabel("여기는 통계입니다.");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("집계 시작");
		
		JButton btnNewButton_1 = new JButton("폴더열기");
		
		JButton btnNewButton_2 = new JButton("새로고침");
		JList list = new JList();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.setModel(new AbstractListModel() {
					
					private FileReader fr;
					private BufferedReader br;
					private StringBuilder stringBuilder = new StringBuilder();
					
					public void fileCheck(){
						File file = new File(Set_properties.getData_path(),Set_properties.getData_file());

						try {
							if (!file.exists()) {
								JOptionPane.showMessageDialog(null, "파일이 존재 하지 않습니다.");
							}
							fr = new FileReader(file);
							br = new BufferedReader(fr);
							;
							stringBuilder.append("\"");
							stringBuilder.append(br.readLine());
							stringBuilder.append("\"");
							for (int i = 0 ; br.ready() ; i++) {
								stringBuilder.append(",\"");
								stringBuilder.append(br.readLine());
								stringBuilder.append("\"");
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					String[] values = new String[]{stringBuilder.toString()};
					
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		GroupLayout gl_panel_static = new GroupLayout(panel_static);
		gl_panel_static.setHorizontalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addGroup(gl_panel_static.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(tglbtnNewToggleButton)
							.addGap(45)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(188)))
					.addGap(36))
		);
		gl_panel_static.setVerticalGroup(
			gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_panel_static.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_static.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18))
						.addGroup(gl_panel_static.createSequentialGroup()
							.addGroup(gl_panel_static.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnNewToggleButton)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2))
							.addGap(27)))
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addGap(18))
		);
		
		
		list.setModel(new AbstractListModel() {
			
			private FileReader fr;
			private BufferedReader br;
			private StringBuilder stringBuilder = new StringBuilder();
			
			public void fileCheck(){
				File file = new File(Set_properties.getData_path(),Set_properties.getData_file());

				try {
					if (!file.exists()) {
						JOptionPane.showMessageDialog(null, "파일이 존재 하지 않습니다.");
					}
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					;
					stringBuilder.append("\"");
					stringBuilder.append(br.readLine());
					stringBuilder.append("\"");
					for (int i = 0 ; br.ready() ; i++) {
						stringBuilder.append(",\"");
						stringBuilder.append(br.readLine());
						stringBuilder.append("\"");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			String[] values = new String[]{stringBuilder.toString()};
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(list);
		panel_static.setLayout(gl_panel_static);

	}
}
