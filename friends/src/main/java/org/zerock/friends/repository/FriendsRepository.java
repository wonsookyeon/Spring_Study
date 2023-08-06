package org.zerock.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.friends.domain.Friends;
import org.zerock.friends.repository.search.FriendsSearch;

public interface FriendsRepository extends JpaRepository<Friends, Long>, FriendsSearch {

}
