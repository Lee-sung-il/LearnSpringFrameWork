package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
// 이 어노테이션은 자동 와어어링 시 필드나 매개변수에서 후보 Bean에 대한 한정자 (qualifier)로 쓰인다고 한다.
// 이 어노테이션은 자동 와이어링 시 필드나 매개변수에서 후보 Bean에 대한 한정자 (qualifier)로 쓰인다고
public class SuperContraGame implements GamingConsole {

	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("Sit down");
	}
	
	public void left() {
		System.out.println("Go back");
	}

	public void right() {
		System.out.println("Shoot a bullet");
	}

}
