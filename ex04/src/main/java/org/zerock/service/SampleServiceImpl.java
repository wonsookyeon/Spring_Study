package org.zerock.service;
//핵심기능
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		
		System.out.println("Integer doAdd");
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	@Override
	public Integer doMinus(String str1, String str2) throws Exception {
		
		return Integer.parseInt(str1) - Integer.parseInt(str2);
	}

	@Override
	public Integer doMul(String str1, String str2) throws Exception {
			System.out.println("Integer doMul");
		return Integer.parseInt(str1) * Integer.parseInt(str2);
	}

	@Override
	public Integer doDiv(String str1, String str2) throws Exception {
		
		return Integer.parseInt(str1) / Integer.parseInt(str2);
	}

}
