package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
public class PageDTO {

    private int startPage;      //시작페이지
    private int endPage;        //끝페이지
    private boolean prev, next; //이전, 다음 버튼 활성화

    private int total;      //데이터베이스 전체 레코드 갯수
    private Criterial cri;  //현재페이지번호, 페이지당 보여질 갯수

    public PageDTO(Criterial cri, int total) {
        this.cri = cri;
        this.total = total;

        //Math.ceil() => 소숫점 절대 올림
        this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
        this.startPage = endPage - 9; //화면에 10개씩 보여주고 1부터 시작하므로

        int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));

        if(realEnd < endPage) {
            endPage = realEnd;
        }

        this.prev = this.startPage > 1; //이전페이지 보임
        this.next = realEnd > endPage;  //다음페이지 보임
    }
}
