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

public class HomeDisplay {

	private JFrame mainframe;
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
		
		
//		JLabel lblStoreName = new JLabel("* 상호명  : ");
//		JLabel lbl_IP = new JLabel("* IP 등록 : ");
//		JLabel lbl_ex = new JLabel("예) 192.168.10.1");
//		JLabel lbl_sIP = new JLabel("시작 IP");
//		JLabel lbl_eIP = new JLabel("종료 IP");
		
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
			gl_panel_mage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_mage.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_mage.setVerticalGroup(
			gl_panel_mage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_mage.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(249, Short.MAX_VALUE))
		);
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
