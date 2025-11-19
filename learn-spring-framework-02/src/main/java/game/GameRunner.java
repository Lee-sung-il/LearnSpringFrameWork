package game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//PacmanGame
@Component
public class GameRunner {
	
	private GamingConsole game;
	
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
		this.game = game;
	}

	public void run() {
		
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
		
	}

}

/*
@primary 여러 후보자가 자격을 갖추면 bean 을 선호해야 합니다

@qualifier 특정 bean은 자동 배선되어야 합니다(bean 이름은 자격에 따라 사용할 수 있습니다)

@Primary 와 @Qualifier 중에서 선택할 때 항상 이 특정 의존성을 사용하는 클래스의 관점에서  생각해야 합니다.
    @AutoWired만 사용하고 있는데요, 한정자는 전혀 적용되지 않았죠
    @AutoWired만 사용하다면 가장 적합한 Sorting 알고리즘을 달라고 요청 하는겁니다.
    어떤 짧은 알고리즘이든 상관없다는 건데요
    짧은 알고리즘이 1개인 경우, 그 1개를 주고  10개의 짧은 알고리즘을 갖고 있다면, 가장 적합한 걸 달라는 겁니다.
    따라서 Complex 알고리즘은 가장 적합한 짧은 알고리즘을 달라고 요청 하고 있다.
    하지만 @Qualifier를 사용하면 어떨까요, 기본적으로 @AutoWired 와 @Qualifier를 같이 사용합니다.
    @Qualifier가 @Primary보다 더 높은 우선 순위를 갖고 있다는점을 항상 기억해두세요
 */