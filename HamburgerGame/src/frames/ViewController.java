package frames;

import java.awt.Container;

import assistance_page.Assistance_Panel;
import assistance_page.End_Panel;
import assistance_page.Start_Panel;
import game_page.Game_Panel;

public class ViewController {
	private Main_Frame mainFrame;
	private Container contentPane;
	private Game_Panel gamePanel;
	private Assistance_Panel currentPanel;
	public ViewController(Main_Frame mainFrame) {
		this.mainFrame = mainFrame;
		init();
	}
	// 시작화면을 초기화 시켜준다.
	private void init(){
		currentPanel = new Start_Panel(this);
		contentPane = mainFrame.getContentPane(); 
		contentPane.add(currentPanel); 
		currentPanel.requestFocus(); 
	}
	
	// 게임화면으로 넘어가기 위해 초기화시켜준다.
	// 넘어오는 변수가 엔트페이지와 스타트페이지 두개이다
	public void showGamePanel(Assistance_Panel currentPanel){
		this.currentPanel = currentPanel;
		contentPane.remove(currentPanel); 
		gamePanel = new Game_Panel(this);
		contentPane.add(gamePanel); 
		gamePanel.initialize(); 
		show();
	}
	// 엔드화면으로 넘어가는 메소드
	public void endGamePanel(int score){
		currentPanel = new End_Panel(this);
		currentPanel.gameMaxScore(score);
		contentPane.remove(gamePanel); 
		contentPane.add(currentPanel); 
		show();
	}
	// 이어하기 누를때 화면을 이어가기 위한 메소드
	public void keepGamePanel(){
		contentPane.remove(gamePanel); 
		contentPane.add(gamePanel); 
		gamePanel.keep();
		show();
	}
	// 새로하기 누를 때 화면을 새로하기 위한 메소드
	public void replayGamePanel(){
		gamePanel.replay();
		contentPane.remove(gamePanel); 
		gamePanel = new Game_Panel(this);
		contentPane.add(gamePanel); 
		gamePanel.initialize();
		show();
	}
	public void show(){
		mainFrame.setVisible(false); //메인프레임을 보이지 않게한 후 
		mainFrame.setVisible(true); //다시 보이게 한다.
	}
}
