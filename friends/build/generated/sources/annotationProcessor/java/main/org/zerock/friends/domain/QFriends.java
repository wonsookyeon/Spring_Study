package org.zerock.friends.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFriends is a Querydsl query type for Friends
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFriends extends EntityPathBase<Friends> {

    private static final long serialVersionUID = -2097198888L;

    public static final QFriends friends = new QFriends("friends");

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    public final NumberPath<Long> fno = createNumber("fno", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public QFriends(String variable) {
        super(Friends.class, forVariable(variable));
    }

    public QFriends(Path<? extends Friends> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFriends(PathMetadata metadata) {
        super(Friends.class, metadata);
    }

}

