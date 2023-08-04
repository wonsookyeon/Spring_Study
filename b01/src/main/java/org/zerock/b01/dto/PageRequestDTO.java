package org.zerock.b01.dto;
// 목록/검색처리 -> PageResponseDTO 를 리턴타입으로 활용

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1; //1page

    @Builder.Default
    private int size = 10; //10개

    private String type; //검색 t,c,w,tc,tw,tcw ==> tcw
    private String keyword; //검색 단어  ==> java , 1


    public String[] getTypes(){ // tcw -> t c w ==> 문자열을 개별 문자로 분해해서 스트링 배열 저장
        if(type == null || type.isEmpty()){
            return null;
        }
        return type.split(""); // 비어있다면 개별문자로 분리
    }


    //abc, def       ;abc   ; aaa, bbb, ccc
    public Pageable getPageable(String ...props) { //가변인자                 //내림차순 정렬
                        //조건이 2개이상 일 수 있기때문에 String...props(가변인자) 사용
        return PageRequest.of(this.page -1, this.size, Sort.by(props).descending());
        //실질적으로 1page는 0page이므로 -1해줌
    }

    public String link;

    public String getLink() { // 검색조건과 페이징 조건을 문자열로 구성
        if (link == null) {
            StringBuilder builder = new StringBuilder();

            builder.append("page=" + this.page); // page = 0

            builder.append("&size=" + this.size); // page = 0 & size = 10

            if (type != null && type.length() > 0) {
                builder.append("&type=" + type); // page =0 & size=10 & type=tcw
            }

            if (keyword != null) {
                try { // page=0 & size=10 & type = tcw & keyword = java
                    builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {

                }
            }
            link = builder.toString(); // page=0 & size=10 & type = tcw & keyword = java
        }
        return link;

    }
}
