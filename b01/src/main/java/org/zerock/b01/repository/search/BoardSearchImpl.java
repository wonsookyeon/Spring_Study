package org.zerock.b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl(){
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board; //Q도메인 객체
        JPQLQuery<Board> query = from(board); //select * from board
        query.where(board.title.contains("1")); //where title like "%" + 1 + "%"

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();
        long count = query.fetchCount();


        return new PageImpl<>(list, pageable, count);
    }

    @Override                       //tcw           java          0,10,bno,desc
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        //select * from board
        // where
        //(title = %java% or content = %java% or writer = %java%);
        if( (types != null && types.length > 0) && keyword != null ){ //검색 조건과 키워드가 있다면
            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type: types){
                switch (type){
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }//end for
            query.where(booleanBuilder);
        }//end if

        //bno > 0
        query.where(board.bno.gt(0L));  //gt => 크거나 같다
        //select * from board
        // where
        //(title = %java% or content = %java% or writer = %java%)
        // and bno > 0L;

        System.out.println("query ==> " + query);

        //paging                           0page, 10개, bno.desc
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch(); //25건 가져와서 리스트에 담기

        long count = query.fetchCount(); //25건

        return new PageImpl<>(list, pageable, count); //객체생성해서 넘겨주기
        //BoardServiceImpl 69번째줄 result로
    }

}
