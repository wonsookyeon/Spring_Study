package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	public String getTime2();
	
	//시스템자체의 시간을 알수 있음
	//어노테이션 기법
	@Select("select sysdate from dual")
	public String getTime();

	
}
