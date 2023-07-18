package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ticket {
	
	private int tno;
	private String owner;
	private String grade;
	
}
