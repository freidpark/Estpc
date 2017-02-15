package com.estpcip;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.modelFrame.fileHandler.CallFileHandler;

public class UserManageFrame {

	private JFrame frame;
	private JTable table;
	private JTable tblshowbox;
	private JTextField txt_sAclass;
	private JTextField txt_sBclass;
	private JTextField txt_sCclass;
	private JTextField txt_sDclass;
	private JTextField txt_eAclass;
	private JTextField txt_eBclass;
	private JTextField txt_eCclass;
	private JTextField txt_eDclass;
	private JTextField txt_StoreName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UserManageFrame window = new UserManageFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserManageFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("대상관리 매니져");
		frame.setBounds(100, 100, 610, 453);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB4F1\uB85D\uD558\uAE30", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JButton btnSearch = new JButton("검색");

		JTextArea textArea_Serarch = new JTextArea();

		JButton btnDelete = new JButton("삭제");

		JButton btnRenew = new JButton("수정");

		tblshowbox = new JTable();
		tblshowbox.setModel(new DefaultTableModel(
				new Object[][] {
						{"\uC120\uD0DD", "\uC21C\uBC88", "\uC0C1\uD638\uBA85", "\uC2DC\uC791IP", "\uC885\uB8CCIP", "\uB4F1\uB85D\uC77C\uC790", "\uC218\uC815\uC77C\uC790"},
				},
				new String[] {
						"\uC120\uD0DD", "\uC21C\uBC88", "\uC0C1\uD638\uBA85", "\uC2DC\uC791IP", "\uC885\uB8CCIP", "\uB4F1\uB85D\uC77C", "\uC218\uC815\uC77C"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					true, false, false, false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblshowbox.getColumnModel().getColumn(6).setPreferredWidth(96);
		tblshowbox.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(UserManageFrame.class.getResource("/com/img/readingG_24.png")));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tblshowbox, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(lblimg)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textArea_Serarch, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
										.addComponent(btnRenew)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnDelete))
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
										.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(24)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDelete)
								.addComponent(btnRenew)
								.addComponent(textArea_Serarch, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblimg)
								.addComponent(btnSearch))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tblshowbox, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addContainerGap())
				);

		JLabel lblSdsdsd = new JLabel("상호명:");

		JLabel lblsdfd = new JLabel("IP등록:");

		JLabel lblNewLabel = new JLabel("~");

		JButton btnSave_info = new JButton("등록");
		btnSave_info.addActionListener(new ActionListener() {
			private String store_sIP;
			private String store_eIP;
			private boolean frag = true; //모든 정보가 정상여부 판단
			int spaceKey ; //공백이 있는 객체의 hashmap key값 저장

			@Override
			public void actionPerformed(ActionEvent actionevent) {

				CallFileHandler callFileHandler = new CallFileHandler();
				HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
				
				String jClass_path = System.getProperty("java.class.path");
				JOptionPane.showMessageDialog(null, jClass_path);

				String userdir = System.getProperty("user.dir");
				JOptionPane.showMessageDialog(null, userdir);

				hashMap.put(1, txt_StoreName.getText());
				hashMap.put(2, txt_sAclass.getText());
				hashMap.put(3, txt_sBclass.getText());
				hashMap.put(4, txt_sCclass.getText());
				hashMap.put(5, txt_sDclass.getText());
				hashMap.put(6, txt_eAclass.getText());
				hashMap.put(7, txt_eBclass.getText());
				hashMap.put(8, txt_eCclass.getText());
				hashMap.put(9, txt_eDclass.getText());

				for (int idkey : hashMap.keySet()){

					if(hashMap.get(idkey).equals("")){
						frag = false;
						spaceKey = idkey;
						break;
					}
				}

				if(frag){

					store_sIP = "";
					store_sIP+=txt_sAclass.getText();
					store_sIP+=".";
					store_sIP+=txt_sBclass.getText();
					store_sIP+=".";
					store_sIP+=txt_sCclass.getText();
					store_sIP+=".";
					store_sIP+=txt_sDclass.getText();

					store_eIP = "";
					store_eIP+=txt_eAclass.getText();
					store_eIP+=".";
					store_eIP+=txt_eBclass.getText();
					store_eIP+=".";
					store_eIP+=txt_eCclass.getText();
					store_eIP+=".";
					store_eIP+=txt_eDclass.getText();

					callFileHandler.setStoreInfo(txt_StoreName.getText(), store_sIP, store_eIP);

				}else if(spaceKey == 1){
					JOptionPane.showMessageDialog(null, "상호명 입력은 필수입니다.");
				}else{
					JOptionPane.showMessageDialog(null, "IP 입력은 필수 입니다.");
				}
			}
		});

		txt_sAclass = new JTextField();
		txt_sAclass.setColumns(10);

		txt_sBclass = new JTextField();
		txt_sBclass.setColumns(10);

		txt_sCclass = new JTextField();
		txt_sCclass.setColumns(10);

		txt_sDclass = new JTextField();
		txt_sDclass.setColumns(10);

		txt_eAclass = new JTextField();
		txt_eAclass.setColumns(10);

		txt_eBclass = new JTextField();
		txt_eBclass.setColumns(10);

		txt_eCclass = new JTextField();
		txt_eCclass.setColumns(10);

		txt_eDclass = new JTextField();
		txt_eDclass.setColumns(10);

		JLabel lblAsdasd = new JLabel("예) 192.168.10.1");
		
		txt_StoreName = new JTextField();
		txt_StoreName.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSdsdsd)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblsdfd)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAsdasd)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txt_StoreName, Alignment.LEADING)
												.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
													.addComponent(txt_sAclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txt_sBclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txt_sCclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txt_sDclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txt_eAclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txt_eBclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txt_eCclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txt_eDclass, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(253)
							.addComponent(btnSave_info, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSdsdsd)
						.addComponent(txt_StoreName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblsdfd)
						.addComponent(txt_sAclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sBclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sCclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sDclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_eAclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_eBclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_eCclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_eDclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(btnSave_info)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAsdasd)
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);

		frame.getContentPane().setLayout(groupLayout);
	}
}
