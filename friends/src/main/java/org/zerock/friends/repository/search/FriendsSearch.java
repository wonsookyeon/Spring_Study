package org.zerock.friends.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.friends.domain.Friends;

public interface FriendsSearch {
    Page<Friends> search1(Pageable pageable);

    Page<Friends> searchAll(String[] types, String keyword, Pageable pageable);

}
