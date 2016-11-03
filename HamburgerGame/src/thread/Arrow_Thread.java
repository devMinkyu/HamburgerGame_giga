package thread;

public class Arrow_Thread extends Thread {
	Arrow_Panel canvas;
	private int swx = 3, speed = 5;

	public Arrow_Thread(Arrow_Panel c) {
		canvas = c;
	}

	public void run() {
		try {
			while (true) {
				if (canvas.getAX() < 10 || canvas.getAX() > canvas.getWidth() - 50) {
					swx *= -1; // 공이 끝에 닿을때 반대로 움직이게 함
				}
				canvas.setAX(swx); // 공 움직이기
				canvas.repaint();
				sleep(speed); // 속도 조절
			}
		} catch (Exception e) {
		}
	}
	public void setSpeed(){
		speed -= 1;
	}
}
