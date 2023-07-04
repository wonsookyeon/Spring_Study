package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Restaurant {
	
	@Autowired //주입
	private Chef chef;
	
	public void test() {
		System.out.println("chef : " + chef);
	}
}
