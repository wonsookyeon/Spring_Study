package org.zerock.friends.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @Column(nullable = false)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(length = 1000)
    private String address;

    @Column(length = 50)
    private String email;

    public void change(String phone,String address){
        this.phone = phone;
        this.address = address;
    }

}
