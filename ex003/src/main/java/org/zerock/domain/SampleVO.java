package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor //생성자
@NoArgsConstructor //default 생성자
public class SampleVO {
	
	private Integer mno;
	private String firstName;
	private String lastName;
	
	

}
