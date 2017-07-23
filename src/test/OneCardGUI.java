package test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OneCardGUI extends JFrame{

	protected JPanel Main_p, contentPane_Start, contentPane_Join, contentPane_Main;
	protected JTextField textField_Start_1, textField_Start_2, textField_Join_1, textField_Join_2, textField_Join_3;
	protected CardLayout cards;
	private JLabel la_Join_1, la_Join_2, la_Join_3;
	protected JButton btn_Start_1, btn_Start_2, btn_Join;
	public JButton playerCard[] = new JButton[14];
	private Image img;
	private int x = 0, y = 0;
	protected JTextField sendMsg;
	private JLabel player2Label2;
	public JLabel player2CardCnt;
	private JPanel player3Panel;
	private JLabel player3Label1;
	private JLabel player3Label2;
	public JLabel player3CardCnt;
	private JPanel player4Panel;
	private JLabel player4Label1;
	private JLabel player4Label2;
	public JLabel player4CardCnt;
	private JPanel countSecondsPanel;
	public JLabel countLabel1;
	public JLabel countSeconds;
	protected JLabel player2_nameLabel;
	protected JLabel player3_nameLabel;
	protected JLabel player4_nameLabel;
	protected JTextArea systemMsg;
	protected JTextArea userMsg;
	protected JScrollPane systemMsgBar, userMsgBar;
	public static JLabel centerNameLa = new JLabel("userName");;
	//뒤로가기 버튼
	protected JButton joinBackBtn, mainBackBtn;
	// dialog
	protected JDialog dialog;
	protected JLabel la_dialog;
	public static JButton frontCard; 
	public static JButton cardDeck;
	public JLabel userName_La;

	public OneCardGUI() {
		// CardLayout 으로 화면전환 (시작화면 , 회원가입 화면 , 게임플레이 화면)
		getContentPane().setLayout(new BorderLayout());
		cards = new CardLayout();
		Main_p = new JPanel();
		Main_p.setLayout(cards); // 프레임에 카드레이아웃 설정

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 800); // 기본크기

		// 유저 카드버튼 생성
		for (int i = 0; i < 14; i++) {
			playerCard[i] = new JButton();
			playerCard[i].setVisible(false);
		}

		// <<이미지-Start, Join 공용>>
		img = Toolkit.getDefaultToolkit().getImage("src/image/card2.png");
		
		// << 시작화면 >>
		contentPane_Start = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(img, x, y, this);
			}
		};
		// contentPane_Start.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane_Start);
		contentPane_Start.setLayout(null);

		// 아이디를 입력받는 텍스트피드 생성.
		textField_Start_1 = new JTextField();
		textField_Start_1.setBounds(392, 471, 200, 40);
		contentPane_Start.add(textField_Start_1);
		textField_Start_1.setColumns(10);

		textField_Start_2 = new JTextField();
		textField_Start_2.setColumns(10);
		textField_Start_2.setBounds(392, 533, 200, 40);
		contentPane_Start.add(textField_Start_2);

		JLabel la1 = new JLabel("아이디");
		la1.setBounds(303, 483, 57, 15);
		contentPane_Start.add(la1);

		JLabel la2 = new JLabel("비밀번호");
		la2.setBounds(303, 545, 57, 15);
		contentPane_Start.add(la2);

		btn_Start_1 = new JButton("로그인");
		btn_Start_1.setBounds(392, 600, 97, 23);
		contentPane_Start.add(btn_Start_1);

		btn_Start_2 = new JButton("회원가입");
		btn_Start_2.setBounds(495, 600, 97, 23);
		contentPane_Start.add(btn_Start_2);
		// btn_Start_2.addActionListener(this);

		// << 회원가입 화면 >>
		contentPane_Join = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(img, x, y, this);
			}
		};
		// contentPane_Join.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane_Join);
		contentPane_Join.setLayout(null);
		
		textField_Join_3 = new JTextField();
		textField_Join_3.setColumns(10);
		textField_Join_3.setBounds(392, 282, 200, 40);
		contentPane_Join.add(textField_Join_3);

		textField_Join_1 = new JTextField();
		textField_Join_1.setColumns(10);
		textField_Join_1.setBounds(392, 344, 200, 40);
		contentPane_Join.add(textField_Join_1);

		textField_Join_2 = new JTextField();
		textField_Join_2.setColumns(10);
		textField_Join_2.setBounds(392, 408, 200, 40);
		contentPane_Join.add(textField_Join_2);

		

		la_Join_1 = new JLabel("아이디");
		la_Join_1.setBounds(323, 294, 57, 15);
		contentPane_Join.add(la_Join_1);

		la_Join_2 = new JLabel("비밀번호");
		la_Join_2.setBounds(323, 356, 57, 15);
		contentPane_Join.add(la_Join_2);

		la_Join_3 = new JLabel("이름");
		la_Join_3.setBounds(323, 420, 57, 15);
		contentPane_Join.add(la_Join_3);

		btn_Join = new JButton("J O I N");
		btn_Join.setBounds(433, 483, 118, 31);
		contentPane_Join.add(btn_Join);
		// btn_Join.addActionListener(this);
		
		joinBackBtn = new JButton("\u25C0 back");//뒤로가기 버튼
		joinBackBtn.setBounds(12, 10, 90, 23);
		contentPane_Join.add(joinBackBtn);

		// << 게임플레이 화면 >>
		contentPane_Main = new JPanel();
		contentPane_Main.setBackground(new Color(102, 153, 153));
		// contentPane_Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane_Main);
		contentPane_Main.setLayout(null);

		//뒤로가기 버튼 
		mainBackBtn = new JButton("\u25C0 back");
		mainBackBtn.setBounds(12, 10, 90, 23);
		contentPane_Main.add(mainBackBtn);
		
		systemMsg = new JTextArea();
		// systemMsg.setBounds(526, 563, 443, 69);
		systemMsg.setEditable(false);
		// contentPane_Main.add(systemMsg);
		// systemMsg 의 스크롤바를 생성한다.
		systemMsgBar = new JScrollPane(systemMsg);
		systemMsgBar.setBounds(526, 563, 443, 69);
		contentPane_Main.add(systemMsgBar, "Center");

		userMsg = new JTextArea();
		userMsg.setEditable(false);
		// userMsg.setBounds(526, 644, 443, 76);
		// contentPane_Main.add(userMsg);
		// userMsgBar 의 스크롤바를 생성한다.
		userMsgBar = new JScrollPane(userMsg);
		userMsgBar.setBounds(526, 651, 443, 69);
		contentPane_Main.add(userMsgBar, "Center");

		JPanel playerCardPanel = new JPanel();
		playerCardPanel.setBounds(12, 563, 502, 188);
		contentPane_Main.add(playerCardPanel);
		playerCardPanel.setLayout(null);

		// 자신이 낼 카드가 보이는 곳[버튼]
		playerCard[0].setBounds(10, 10, 63, 88);
		playerCardPanel.add(playerCard[0]);

		playerCard[1].setBounds(80, 10, 63, 88);
		playerCardPanel.add(playerCard[1]);

		playerCard[2].setBounds(150, 10, 63, 88);
		playerCardPanel.add(playerCard[2]);

		playerCard[3].setBounds(220, 10, 63, 88);
		playerCardPanel.add(playerCard[3]);

		playerCard[4].setBounds(290, 10, 63, 88);
		playerCardPanel.add(playerCard[4]);

		playerCard[5].setBounds(360, 10, 63, 88);
		playerCardPanel.add(playerCard[5]);

		playerCard[6].setBounds(430, 10, 63, 88);
		playerCardPanel.add(playerCard[6]);

		playerCard[7].setBounds(10, 100, 63, 88);
		playerCardPanel.add(playerCard[7]);

		playerCard[8].setBounds(80, 100, 63, 88);
		playerCardPanel.add(playerCard[8]);

		playerCard[9].setBounds(150, 100, 63, 88);
		playerCardPanel.add(playerCard[9]);

		playerCard[10].setBounds(220, 100, 63, 88);
		playerCardPanel.add(playerCard[10]);

		playerCard[11].setBounds(290, 100, 63, 88);
		playerCardPanel.add(playerCard[11]);

		playerCard[12].setBounds(360, 100, 63, 88);
		playerCardPanel.add(playerCard[12]);

		playerCard[13].setBounds(430, 100, 63, 88);
		playerCardPanel.add(playerCard[13]);

		JPanel frontCardDeckPanel = new JPanel(new GridLayout(1,1));
		frontCardDeckPanel.setBounds(499, 248, 63, 88);
		frontCard = new JButton();
		
		frontCardDeckPanel.add(frontCard);
		contentPane_Main.add(frontCardDeckPanel);

		JPanel selectCardDeckPanel = new JPanel(new GridLayout(1,1));
		selectCardDeckPanel.setBounds(391, 248, 63, 88);
		cardDeck = new JButton("시작");
		selectCardDeckPanel.add(cardDeck);
		contentPane_Main.add(selectCardDeckPanel);

		// CardLayout 배치
		  Main_p.add(contentPane_Main, "Main");
	      Main_p.add(contentPane_Start, "Start");
	      Main_p.add(contentPane_Join, "Join");
	      

	      // 채팅에 사용되는 텍스트필드 생성.
	      sendMsg = new JTextField();
	      sendMsg.setBounds(526, 730, 404, 21);
	      contentPane_Main.add(sendMsg);
	      sendMsg.setColumns(10);
	      // sendMsg.addActionListener(this);

	      
	      Button sendMsgBtn = new Button("전송");//전송 버튼
	      sendMsgBtn.setBounds(936, 728, 36, 23); 
	      contentPane_Main.add(sendMsgBtn);

	      JPanel player2Panel = new JPanel();
	      player2Panel.setBounds(33, 235, 142, 90);
	      contentPane_Main.add(player2Panel);
	      player2Panel.setLayout(null);

	      JLabel player2Label1 = new JLabel("<<플레이어 2>>");
	      player2Label1.setBounds(27, 5, 90, 15);
	      player2Panel.add(player2Label1);

	      player2Label2 = new JLabel("남은 카드 수 : ");
	      player2Label2.setBounds(12, 65, 90, 15);
	      player2Panel.add(player2Label2);

	      player2CardCnt = new JLabel("0");
	      player2CardCnt.setBounds(101, 65, 16, 15);
	      player2Panel.add(player2CardCnt);

	      player2_nameLabel = new JLabel("New label");
	      player2_nameLabel.setBounds(12, 35, 90, 15);
	      player2Panel.add(player2_nameLabel);

	      player3Panel = new JPanel();
	      player3Panel.setLayout(null);
	      player3Panel.setBounds(421, 10, 142, 90);
	      contentPane_Main.add(player3Panel);

	      player3Label1 = new JLabel("<<플레이어 3>>");
	      player3Label1.setBounds(27, 5, 90, 15);
	      player3Panel.add(player3Label1);

	      player3Label2 = new JLabel("남은 카드 수 : ");
	      player3Label2.setBounds(12, 65, 90, 15);
	      player3Panel.add(player3Label2);

	      player3CardCnt = new JLabel("0");
	      player3CardCnt.setBounds(101, 65, 16, 15);
	      player3Panel.add(player3CardCnt);

	      player3_nameLabel = new JLabel("New label");
	      player3_nameLabel.setBounds(12, 35, 90, 15);
	      player3Panel.add(player3_nameLabel);

	      player4Panel = new JPanel();
	      player4Panel.setLayout(null);
	      player4Panel.setBounds(810, 235, 142, 90);
	      contentPane_Main.add(player4Panel);

	      player4Label1 = new JLabel("<<플레이어 4>>");
	      player4Label1.setBounds(27, 5, 90, 15);
	      player4Panel.add(player4Label1);

	      player4Label2 = new JLabel("남은 카드 수 : ");
	      player4Label2.setBounds(12, 65, 90, 15);
	      player4Panel.add(player4Label2);

	      player4CardCnt = new JLabel("0");
	      player4CardCnt.setBounds(101, 65, 16, 15);
	      player4Panel.add(player4CardCnt);

	      player4_nameLabel = new JLabel("New label");
	      player4_nameLabel.setBounds(12, 35, 90, 15);
	      player4Panel.add(player4_nameLabel);

	      countSecondsPanel = new JPanel();
	      countSecondsPanel.setBounds(631, 132, 106, 25);
	      contentPane_Main.add(countSecondsPanel);

	      countLabel1 = new JLabel("쌓인 카드 : ");
	      countSecondsPanel.add(countLabel1);

	      countSeconds = new JLabel("0");
	      countSecondsPanel.add(countSeconds);
	      getContentPane().add(Main_p);
	      
	      JPanel playerPanel = new JPanel();// 내가 낼 카드 위에 ~의 카드다 라는것을 명시
	      playerPanel.setBounds(12, 528, 163, 31);
	      contentPane_Main.add(playerPanel);
	      playerPanel.setLayout(null);
	      
	      userName_La = new JLabel("userName");// 내가 낼 카드 위에 ~의 카드다 라는것을 명시
	      userName_La.setBounds(12, 10, 73, 15);
	      playerPanel.add(userName_La);
	      
	      JLabel myCard_la = new JLabel(" 의 카드");// 내가 낼 카드 위에 ~의 카드다 라는것을 명시
	      myCard_la.setBounds(94, 10, 57, 15);
	      playerPanel.add(myCard_la);
	      
	      JLabel systemLabel = new JLabel("시스템 창");//시스템창이라는 것을 알려주는 라벨 
	      systemLabel.setForeground(Color.WHITE);
	      systemLabel.setBounds(526, 544, 57, 15);
	      contentPane_Main.add(systemLabel);
	      
	      JLabel chatLabel = new JLabel("채팅");//채팅창이라는 것을 알려주는 라벨 
	      chatLabel.setForeground(Color.WHITE);
	      chatLabel.setBounds(526, 634, 57, 15);
	      contentPane_Main.add(chatLabel);
	      
	      JPanel centerMsgPanel = new JPanel();//중앙에 모든플레이어들이 누구차례인지 보이는 곳
	      centerMsgPanel.setLayout(null);
	      centerMsgPanel.setBounds(385, 188, 200, 31);
	      contentPane_Main.add(centerMsgPanel);
	      
//	      centerNameLa = new JLabel("userName");//중앙에 모든플레이어들이 누구차례인지 보이는 곳
	      centerNameLa.setBounds(12, 10, 73, 15);
	      centerMsgPanel.add(centerNameLa);
	      
	      JLabel centerMsgLa = new JLabel("의 차례입니다.");//중앙에 모든플레이어들이 누구차례인지 보이는 곳
	      centerMsgLa.setBounds(94, 10, 90, 15);
	      centerMsgPanel.add(centerMsgLa);
	      getContentPane().add(Main_p);

	      // 다이얼로그 생성
	      dialog = new JDialog();
	      la_dialog = new JLabel("다이얼로그");
	      dialog.getContentPane().setLayout(new BorderLayout());
	      dialog.getContentPane().add(new JLabel(" "), "South");
	      dialog.getContentPane().add(la_dialog, "Center");
	      dialog.getContentPane().add(new JLabel(" "), "North");
	      dialog.getContentPane().add(new JLabel(" "), "East");
	      dialog.getContentPane().add(new JLabel("　　　"), "West");
	      dialog.setSize(400, 150);
	      dialog.setLocation(800, 400);
	   }

	
	/*
	 * // GUI실행 public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * OneCardGUI frame = new OneCardGUI(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } });
	 * 
	 * }
	 */

}
