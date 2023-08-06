package org.zerock.friends.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.friends.domain.Friends;
import org.zerock.friends.domain.QFriends;

import java.util.List;

public class FriendsSearchImpl extends QuerydslRepositorySupport implements FriendsSearch {

    public FriendsSearchImpl(){
        super(Friends.class);
    }

    @Override
    public Page<Friends> search1(Pageable pageable) {

        QFriends friends = QFriends.friends;

        JPQLQuery<Friends> query = from(friends);
        query.where(friends.address.contains("수원시"));

        this.getQuerydsl().applyPagination(pageable,query);

        List<Friends> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<Friends> searchAll(String[] types, String keyword, Pageable pageable) {
            QFriends friends = QFriends.friends;
            JPQLQuery<Friends> query = from(friends);
            // select * from board

            // where
            // (title = %java% or content = %java% or writer = %java%);
            if( (types != null && types.length > 0) && keyword != null ){ //검색 조건과 키워드가 있다면

                BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

                for(String type: types){

                    switch (type){
                        case "n":
                            booleanBuilder.or(friends.name.contains(keyword));
                            break;
                        case "p":
                            booleanBuilder.or(friends.phone.contains(keyword));
                            break;
                        case "e":
                            booleanBuilder.or(friends.email.contains(keyword));
                            break;
                    }
                }//end for
                query.where(booleanBuilder);
            }//end if

            //bno > 0
            query.where(friends.fno.gt(0L));

            //select * from board
            // where
            // (title = %java% or content = %java% or writer = %java%)
            // and bno > 0L;

            System.out.println("query ===> " + query);

            //paging                            0, 10,bno.desc
            this.getQuerydsl().applyPagination(pageable, query);

            List<Friends> list = query.fetch();

            long count = query.fetchCount();

            return new PageImpl<>(list, pageable, count);
        }
    }