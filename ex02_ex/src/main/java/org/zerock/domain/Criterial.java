package org.zerock.domain;

import lombok.Data;

@Data
public class Criterial {
    private int pageNum;
    private int amount;
    
    private String type; //내용(C), 작성자(W), 제목(T)
    private String keyword; //검색조건

    public Criterial(){
        this(1,10);
    }
    public Criterial(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }
    
    public String[] getTypeArr() { //글자 분해 CWT --> C W T, CT --> C T
    	return type == null? new String[] {} : type.split("");
    	
    }
    
    
    
    

}
