package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	
	private final Chef chef; //@RequiredArgsConstructor
//	private Chef chef;
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
	
	
}
