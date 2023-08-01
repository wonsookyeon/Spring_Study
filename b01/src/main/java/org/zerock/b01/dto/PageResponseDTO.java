package org.zerock.b01.dto;
//목록과 시작 페이지,끝 페이지 등에 대한 처리를 담당

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll") //builder 대신 withAll 로 쓸 수 있음
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){

        if(total <= 0) { return; }
        this.page = pageRequestDTO.getPage(); //0
        this.size = pageRequestDTO.getSize(); //10
        this.total = total;                 //25 --> 총페이지는 3
        this.dtoList = dtoList;
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10; //10page
                                                    // 화면에서의 마지막 번호

        this.start = this.end - 9; //1page //화면에서의 시작 번호

        int last = (int)(Math.ceil((total/(double)size))); // 25/10 = 2.5 => 3page
                                    //데이터의 개수를 계산한 마지막 페이지 번호

        this.end = end > last ? last: end; //end => 3page
        this.prev = this.start > 1; //false
        this.next = total > this.end * this.size; // 25>30 -> false
        // 105 > 10*10 = 100

    }

}
