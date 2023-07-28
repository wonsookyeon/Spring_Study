package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.Board;

public interface BoardRepository  extends JpaRepository<Board, Long> {
                                                    //테이블명, 기본키타입

    Board findByTitle(String title);

}
