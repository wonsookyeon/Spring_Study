package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;

@Table(name="reply", indexes = {
        @Index(name= "idx_reply_board_bno", columnList = "board_bno")})
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)//Reply:Many to Board:One
    private Board board;

    private String replyText;

    private String replyer;
}
