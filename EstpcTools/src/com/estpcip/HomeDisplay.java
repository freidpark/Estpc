package com.estpcip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.modelFrame.fileHandler.ServiceStarter;
import com.modelFrame.loggerListener.LoggerListener;
import com.modelFrame.loggerListener.writerLogger;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
//	private JTextField txt_StoreName;
//	private JTextField txt_sAclass;
//	private JTextField txt_sBclass;
//	private JTextField txt_sCclass;
//	private JTextField txt_sDclass;
//	private JTextField txt_eAclass;
//	private JTextField txt_eBclass;
//	private JTextField txt_eCclass;
//	private JTextField txt_eDclass;

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

		LoggerListener loginfo = new writerLogger();

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
		GroupLayout gl_panel_mage = new GroupLayout(panel_mage);
		gl_panel_mage.setHorizontalGroup(
			gl_panel_mage.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_mage.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
					.addGap(9))
		);
		gl_panel_mage.setVerticalGroup(
			gl_panel_mage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_mage.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
		);
		
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
		
		JButton button_sv = new JButton("등록하기");
		
		JButton button_rw = new JButton("다시쓰기");
		
		JLabel lbl_glassImg01 = new JLabel("");
		lbl_glassImg01.setIcon(new ImageIcon(HomeDisplay.class.getResource("/com/img/readingG_24.png")));
		
		txt_searchWord = new JTextField();
		txt_searchWord.setColumns(10);
		
		JButton button_searching = new JButton("검색");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbl_IP)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_ex, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStoreName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtStoreName, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(lbl_glassImg01)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_searchWord, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_searching, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
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
					.addGap(23))
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
						.addComponent(button_rw))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panel_mage.setLayout(gl_panel_mage);

//		통계 탭 시작	
		JPanel panel_static = new JPanel();
		tabbedPane.addTab("통계      ", null, panel_static, null);

		JLabel lblNewLabel_1 = new JLabel("여기는 통계입니다.");
		GroupLayout gl_panel_static = new GroupLayout(panel_static);
		gl_panel_static.setHorizontalGroup(
				gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
						.addGap(60)
						.addComponent(lblNewLabel_1)
						.addContainerGap(662, Short.MAX_VALUE))
				);
		gl_panel_static.setVerticalGroup(
				gl_panel_static.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_static.createSequentialGroup()
						.addGap(83)
						.addComponent(lblNewLabel_1)
						.addContainerGap(414, Short.MAX_VALUE))
				);
		panel_static.setLayout(gl_panel_static);

	}
}
