package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criterial {
	
	private int pageNum;
	private int amount; //page 당 몇개씩 보여줄건지
	
	public Criterial() {
		this(1,10);
	}
	
	public Criterial(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	
	
	
	
	
}


