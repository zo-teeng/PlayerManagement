package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import InjuryPlayer.InjuryPlayer;
import InjuryPlayer.InjuryPlayerDAO;
import Player.Player;
import Player.PlayerDAO;
import User.User;
import User.UserDAO;


public class MainPlayerFrame extends JFrame {
	
	JPanel btnPanel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel loginPanel = new JPanel();
	JPanel joinPanel = new JPanel();
	JButton btn1 = new JButton("선수등록");
	JButton btn2 = new JButton("선수방출");
	JButton btn3 = new JButton("선수목록");
	JButton btn4 = new JButton("부상자 관리");
	JButton btn5 = new JButton("선수정보수정");
	JButton btn6 = new JButton("종료");
	
	public MainPlayerFrame() {

		setTitle("야구선수 관리 프로그램");
		setSize(500,300);
		setLocation(570, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		
//		setBtnPanel();
		setLoginPanel();
		
		setVisible(true);
	}
	
	
	
	private void setLoginPanel() {
		
		
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel login = new JPanel();
		login.setBackground(Color.LIGHT_GRAY);
		login.setLayout(new GridLayout(2,2,5,5));
		
		JLabel lbl1 = new JLabel("아이디");
		JLabel lbl2 = new JLabel("패스워드");
		JTextField id = new JTextField(20);
		JPasswordField pwd = new JPasswordField(20);
		
		login.add(lbl1);	login.add(id);
		login.add(lbl2);	login.add(pwd);
		
		loginPanel.add(login);
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnLogin = new JButton("로그인하기");
		JButton btnJoin = new JButton("회원가입하기");
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userId = id.getText();
				String userPwd = String.valueOf(pwd.getPassword());
				
				UserDAO dao = new UserDAO();
				boolean result = dao.checkId(userId, userPwd);
				
				if(result == true) {
					setSize(700,600);
					setVisibleFalse();
					setBtnPanel();
				} else
					setLoginPanel();
			}
			
		});
		
		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setJoinPanel();
			}
			
		});
		
		bPanel.add(btnLogin);
		bPanel.add(btnJoin);
		loginPanel.add(bPanel);
//		loginPanel.add(lbl);
		add(loginPanel);
		
		setVisibleFalse();
		loginPanel.setVisible(true);
		
	}

	private void setJoinPanel() {
		
		joinPanel = new JPanel();
		joinPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel join = new JPanel();
		join.setBackground(Color.LIGHT_GRAY);
		join.setLayout(new GridLayout(2,2,5,5));
		
		JLabel lbl1 = new JLabel("아이디");
		JLabel lbl2 = new JLabel("패스워드");
		JTextField id = new JTextField(20);
		JTextField pwd = new JTextField(20);
		
		join.add(lbl1);	join.add(id);
		join.add(lbl2);	join.add(pwd);
		
		joinPanel.add(join);
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnJoin = new JButton("회원가입하기");
		
		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = id.getText();
				String userPwd = pwd.getText();
				
				UserDAO dao = new UserDAO();
				User user = new User(userId, userPwd);
				dao.insertUser(user);
				
				setLoginPanel();
			}
			
		});
		
		bPanel.add(btnJoin);
		joinPanel.add(bPanel);
//		loginPanel.add(lbl);
		add(joinPanel);
		
		setVisibleFalse();
		joinPanel.setVisible(true);
		
	}

	private void setBtnPanel() {
		
		// 맨위 버튼 ---------------------------------------------------------	
				BtnActionListener listener = new BtnActionListener();
//				JButton btn1 = new JButton("선수등록");
//				btn1.setBounds(10, 10, 120, 30);
				btn1.setBackground(Color.LIGHT_GRAY);
				btn1.setBorderPainted(false); // 버튼 테두리 없애기
				btn1.addActionListener(listener);
				
//				JButton btn2 = new JButton("선수삭제");
//				btn2.setBounds(140, 10, 120, 30);
				btn2.setBackground(Color.LIGHT_GRAY);
				btn2.setBorderPainted(false); // 버튼 테두리 없애기
				btn2.addActionListener(listener);
				
//				JButton btn3 = new JButton("선수목록");
//				btn3.setBounds(270, 10, 120, 30);
				btn3.setBackground(Color.LIGHT_GRAY);
				btn3.setBorderPainted(false); // 버튼 테두리 없애기
				btn3.addActionListener(listener);
				
//				JButton btn4 = new JButton("부상자 관리");
//				btn4.setBounds(400, 10, 120, 30);
				btn4.setBackground(Color.LIGHT_GRAY);
				btn4.setBorderPainted(false); // 버튼 테두리 없애기
				btn4.addActionListener(listener);
				
//				JButton btn5 = new JButton("라인업");
//				btn5.setBounds(530, 10, 120, 30);
				btn5.setBackground(Color.LIGHT_GRAY);
				btn5.setBorderPainted(false); // 버튼 테두리 없애기
				btn5.addActionListener(listener);
				
//				JButton btn6 = new JButton("종료");
//				btn6.setBounds(660, 10, 120, 30);
				btn6.setBackground(Color.LIGHT_GRAY);
				btn6.setBorderPainted(false); // 버튼 테두리 없애기
				btn6.addActionListener(listener);
				
				btnPanel.add(btn1);
				btnPanel.add(btn2);
				btnPanel.add(btn3);
				btnPanel.add(btn4);
				btnPanel.add(btn5);
				btnPanel.add(btn6);

				add(btnPanel, BorderLayout.NORTH);
		
	}



	void setVisibleFalse() {
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		loginPanel.setVisible(false);
		joinPanel.setVisible(false);
	}
	
	// 추가
	private void setPanel1() {
		
		panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		setBtnColor();
		btn1.setBackground(Color.white);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(6,2,3,3));
		infoPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbl1 = new JLabel("등번호");
		JLabel lbl2 = new JLabel("이름");
		JLabel lbl3 = new JLabel("나이");
		JLabel lbl4 = new JLabel("키");
		JLabel lbl5 = new JLabel("몸무게");
		JLabel lbl6 = new JLabel("포지션");
		JTextField tfNo = new JTextField(20);
		JTextField tfName = new JTextField(20);
		JTextField tfAge = new JTextField(20);
		JTextField tfHeight = new JTextField(20);
		JTextField tfWeight = new JTextField(20);
		String[] position = {"OF","IF","C","P"};
		JComboBox comboPosition = new JComboBox(position);
		
		infoPanel.add(lbl1);	infoPanel.add(tfNo);
		infoPanel.add(lbl2);	infoPanel.add(tfName);
		infoPanel.add(lbl3);	infoPanel.add(tfAge);
		infoPanel.add(lbl4);	infoPanel.add(tfHeight);
		infoPanel.add(lbl5);	infoPanel.add(tfWeight);
		infoPanel.add(lbl6);	infoPanel.add(comboPosition);
		
		panel1.add(infoPanel);
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnInsert = new JButton("추가");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String no = tfNo.getText();
				String name = tfName.getText();
				String age = tfAge.getText();
				String height = tfHeight.getText();
				String weight = tfWeight.getText();
				String position = (String)comboPosition.getSelectedItem();
				
				Player Player = new Player(no,name,age,height,weight,position);
				
				PlayerDAO dao = new PlayerDAO();
				dao.insertPlayer(Player);
			}
			
		});
		
		bPanel.add(btnInsert);
		panel1.add(bPanel);
		
		add(panel1);
		
		setVisibleFalse();
		panel1.setVisible(true);
	}
	
	// 삭제
	private void setPanel2() {
		
		panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		setBtnColor();
		btn2.setBackground(Color.white);
		
		JLabel warning = new JLabel();
		warning.setBounds(300,600,100,50);
		warning.setText("부상자는 방출할 수 없습니다.");
		
		Vector<String> tableTitle = new Vector<String>();
		tableTitle.add("등번호");
		tableTitle.add("이름");
		tableTitle.add("나이");
		tableTitle.add("키");
		tableTitle.add("몸무게");
		tableTitle.add("포지션");
		
		DefaultTableModel model = new DefaultTableModel(tableTitle,0);
		JTable table = new JTable(model);
		
		PlayerDAO dao = new PlayerDAO();
		Player player = new Player();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int srow=table.getSelectedRow();
				String no = (String)table.getValueAt(srow, 0);
				String name = (String)table.getValueAt(srow, 1);
				String age = (String)table.getValueAt(srow, 2);
				String height = (String)table.getValueAt(srow, 3);
				String weight = (String)table.getValueAt(srow, 4);
				String position = (String)table.getValueAt(srow, 5);
				
				player.setBackNum(no);
				player.setName(name);
				player.setAge(age);
				player.setHeight(height);
				player.setWeight(weight);
				player.setPosition(position);
				
				System.out.println(player);
				
			}
		});
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnDelete = new JButton("방출");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dao.deletePlayer(player);
			}
			
		});
		
		ArrayList<Player> playerList = dao.getPlayerList();
		
		for(Player Player : playerList) {
			Vector<String> v = new Vector<String>();
			v.add(Player.getBackNum());
			v.add(Player.getName());
			v.add(Player.getAge());
			v.add(Player.getHeight());
			v.add(Player.getWeight());
			v.add(Player.getPosition());
			
			model.addRow(v);
		}

		//*******************
		
		JTextField tfSearch = new JTextField(40);
		tfSearch.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String val = tfSearch.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
			
		});
		
		panel2.add(tfSearch);
		panel2.add(new JScrollPane(table));
		
		bPanel.add(btnDelete);
		panel2.add(bPanel);
		panel2.add(warning);
		add(panel2);
		
		
		setVisibleFalse();
		panel2.setVisible(true);
		
	}
	
	// 목록
	private void setPanel3() {
		
		panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		setBtnColor();
		btn3.setBackground(Color.white);
		
		//-------------------
		
		Vector<String> tableTitle = new Vector<String>();
		tableTitle.add("등번호");
		tableTitle.add("이름");
		tableTitle.add("나이");
		tableTitle.add("키");
		tableTitle.add("몸무게");
		tableTitle.add("포지션");
		
		DefaultTableModel model = new DefaultTableModel(tableTitle,0);
		JTable table = new JTable(model);
		
		PlayerDAO dao = new PlayerDAO();
		Player player = new Player();
		InjuryPlayerDAO idao = new InjuryPlayerDAO();
		InjuryPlayer injuryPlayer = new InjuryPlayer();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int srow=table.getSelectedRow();
				String no = (String)table.getValueAt(srow, 0);
				String name = (String)table.getValueAt(srow, 1);
				String age = (String)table.getValueAt(srow, 2);
				String height = (String)table.getValueAt(srow, 3);
				String weight = (String)table.getValueAt(srow, 4);
				String position = (String)table.getValueAt(srow, 5);
				
				player.setBackNum(no);
				player.setName(name);
				player.setAge(age);
				player.setHeight(height);
				player.setWeight(weight);
				player.setPosition(position);
				
				injuryPlayer.setBackNum(no);
				injuryPlayer.setName(name);
				injuryPlayer.setAge(age);
				injuryPlayer.setHeight(height);
				injuryPlayer.setWeight(weight);
				injuryPlayer.setPosition(position);
				
				System.out.println(player);
				
			}
		});
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnUpdate = new JButton("부상자 등록");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dao.deletePlayer(player);
				idao.insertInjuryPlayer(injuryPlayer);
			}
			
		});
		
		//*******************
		
		ArrayList<Player> playerList = dao.getPlayerList();
		
		for(Player Player : playerList) {
			Vector<String> v = new Vector<String>();
			v.add(Player.getBackNum());
			v.add(Player.getName());
			v.add(Player.getAge());
			v.add(Player.getHeight());
			v.add(Player.getWeight());
			v.add(Player.getPosition());
			
			model.addRow(v);
		}

		//*******************
		
		JTextField tfSearch = new JTextField(40);
		tfSearch.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String val = tfSearch.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
			
		});
		
		panel3.add(tfSearch);
		panel3.add(new JScrollPane(table));
		
		//-------------------
		
		bPanel.add(btnUpdate);
		panel3.add(bPanel);
		add(panel3);
		
		setVisibleFalse();
		panel3.setVisible(true);
	
		
	}
	
	private void setPanel4() {
		
		panel4 = new JPanel();
		panel4.setBackground(Color.LIGHT_GRAY);
		setBtnColor();
		btn4.setBackground(Color.white);
		
		//-------------------
		
		Vector<String> tableTitle = new Vector<String>();
		tableTitle.add("등번호");
		tableTitle.add("이름");
		tableTitle.add("나이");
		tableTitle.add("키");
		tableTitle.add("몸무게");
		tableTitle.add("포지션");
		
		DefaultTableModel model = new DefaultTableModel(tableTitle,0);
		JTable table = new JTable(model);
		
		PlayerDAO dao = new PlayerDAO();
		Player player = new Player();
		InjuryPlayerDAO idao = new InjuryPlayerDAO();
		InjuryPlayer injuryPlayer = new InjuryPlayer();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int srow=table.getSelectedRow();
				String no = (String)table.getValueAt(srow, 0);
				String name = (String)table.getValueAt(srow, 1);
				String age = (String)table.getValueAt(srow, 2);
				String height = (String)table.getValueAt(srow, 3);
				String weight = (String)table.getValueAt(srow, 4);
				String position = (String)table.getValueAt(srow, 5);
				
				player.setBackNum(no);
				player.setName(name);
				player.setAge(age);
				player.setHeight(height);
				player.setWeight(weight);
				player.setPosition(position);
				
				injuryPlayer.setBackNum(no);
				injuryPlayer.setName(name);
				injuryPlayer.setAge(age);
				injuryPlayer.setHeight(height);
				injuryPlayer.setWeight(weight);
				injuryPlayer.setPosition(position);
				
			}
		});
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnDelete = new JButton("부상자 말소");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dao.insertPlayer(player);
				idao.deleteInjuryPlayer(injuryPlayer);
			}
			
		});
		
		//*******************
		
		ArrayList<InjuryPlayer> playerList = idao.getInjuryPlayerList();
		
		for(InjuryPlayer Player : playerList) {
			Vector<String> v = new Vector<String>();
			v.add(Player.getBackNum());
			v.add(Player.getName());
			v.add(Player.getAge());
			v.add(Player.getHeight());
			v.add(Player.getWeight());
			v.add(Player.getPosition());
			
			model.addRow(v);
		}

		//*******************
		
		JTextField tfSearch = new JTextField(40);
		tfSearch.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String val = tfSearch.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
			
		});
		
		panel4.add(tfSearch);
		panel4.add(new JScrollPane(table));
		
		//-------------------
		
		bPanel.add(btnDelete);
		panel4.add(bPanel);
		add(panel4);
		
		setVisibleFalse();
		panel4.setVisible(true);
		
	}
	
	private void setPanel5() {
		
		panel5 = new JPanel();
		panel5.setBackground(Color.LIGHT_GRAY);
		setBtnColor();
		btn5.setBackground(Color.white);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(8,2,3,3));
		infoPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbl1 = new JLabel("등번호");
		JLabel lbl2 = new JLabel("이름");
		JLabel lbl3 = new JLabel("수정할 등번호");
		JLabel lbl4 = new JLabel("수정할 이름");
		JLabel lbl5 = new JLabel("수정할 나이");
		JLabel lbl6 = new JLabel("수정할 키");
		JLabel lbl7 = new JLabel("수정할 몸무게");
		JLabel lbl8 = new JLabel("수정할 포지션");
		JTextField tfNo = new JTextField(20);
		JTextField tfName = new JTextField(20);
		JTextField tfUpdateNo = new JTextField(20);
		JTextField tfUpdateName = new JTextField(20);
		JTextField tfUpdateAge = new JTextField(20);
		JTextField tfUpdateHeight = new JTextField(20);
		JTextField tfUpdateWeight = new JTextField(20);
		String[] position = {"OF","IF","C","P"};
		JComboBox comboUpdatePosition = new JComboBox(position);
		
		infoPanel.add(lbl1);	infoPanel.add(tfNo);
		infoPanel.add(lbl2);	infoPanel.add(tfName);
		infoPanel.add(lbl3);	infoPanel.add(tfUpdateNo);
		infoPanel.add(lbl4);	infoPanel.add(tfUpdateName);
		infoPanel.add(lbl5);	infoPanel.add(tfUpdateAge);
		infoPanel.add(lbl6);	infoPanel.add(tfUpdateHeight);
		infoPanel.add(lbl7);	infoPanel.add(tfUpdateWeight);
		infoPanel.add(lbl8);	infoPanel.add(comboUpdatePosition);
		
		panel5.add(infoPanel);
		
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.LIGHT_GRAY);
		JButton btnInsert = new JButton("선수정보 수정");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String no = tfNo.getText();
				String name = tfName.getText();
				String updateNo = tfUpdateNo.getText();
				String updateName = tfUpdateName.getText();
				String updateAge = tfUpdateAge.getText();
				String updateHeight = tfUpdateHeight.getText();
				String updateWeight = tfUpdateWeight.getText();
				String updatePosition = (String)comboUpdatePosition.getSelectedItem();
				
				Player Player = new Player(updateNo,updateName,updateAge,updateHeight,updateWeight,updatePosition);
				
				PlayerDAO dao = new PlayerDAO();
				dao.updatePlayer(Player, no, name);
			}
			
		});
		
		bPanel.add(btnInsert);
		panel5.add(bPanel);
		
		add(panel5);
		
		setVisibleFalse();
		panel5.setVisible(true);
		
	}
	
	void setBtnColor() {
		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn5.setBackground(Color.LIGHT_GRAY);
		btn6.setBackground(Color.LIGHT_GRAY);
	}
	
	public static void main(String[] args) {
		
		new MainPlayerFrame();
		
	}
	
	class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			if(btn.getActionCommand().equals("선수등록")) {
				setPanel1();
			} else if(btn.getActionCommand().equals("선수방출")) {
				setPanel2();
			} else if(btn.getActionCommand().equals("선수목록")) {
				setPanel3();
			} else if(btn.getActionCommand().equals("부상자 관리")) {
				setPanel4();
			} else if(btn.getActionCommand().equals("선수정보수정")) {
				setPanel5();
			} else if(btn.getActionCommand().equals("종료")) {
				JOptionPane.showMessageDialog(null, "종료합니다.");
				System.exit(0);
			}
			
		}

		
	}

}
