package game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary//한가지 방법으로 @primary를 사용할 수 있는데요 여러 후보가 단일 값 의존성을 자동으로 와이어링할 자격이 있는 경우
// MarioGame에 우선권을 부여하는 합니다.
public class MarioGame implements GamingConsole {
	
	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("Go into a hole");
	}
	
	public void left() {
		System.out.println("Go back");
	}

	public void right() {
		System.out.println("Accelerate");
	}


}
