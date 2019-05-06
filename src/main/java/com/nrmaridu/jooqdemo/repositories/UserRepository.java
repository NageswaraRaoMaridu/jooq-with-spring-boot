package com.nrmaridu.jooqdemo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nrmaridu.jooqdemo.configuration.Jooq;
import com.nrmaridu.jooqdemo.jooq.UserJooq;
import com.nrmaridu.jooqdemo.model.User;

/**
 * @author nrmaridu on 5/2/2019
 */
@Repository
public class UserRepository {

    private final UserJooq userJooq = UserJooq.instance;

    @Autowired
    public Jooq jooq;

    public User createUser(User user) {
        return jooq.build()
            .insertInto(userJooq.table)
            .set(userJooq.Id, user.getId())
            .set(userJooq.name, user.getName())
            .set(userJooq.age, user.getAge())
            .set(userJooq.occupation, user.getOccupation())
            .returning(userJooq.Id,
                userJooq.name,
                userJooq.age,
                userJooq.occupation)
            .fetchOne()
            .into(User.class);
    }

    public User getUserById(UUID id) {
        return jooq.build()
            .select(userJooq.Id, userJooq.name, userJooq.age, userJooq.occupation)
            .from(userJooq.table)
            .where(userJooq.Id.eq(id))
            .fetchOneInto(User.class);
    }

    public List<String> getUserNames() {
        return jooq.build()
            .select(userJooq.name)
            .from(userJooq.table)
            .orderBy(userJooq.name)
            .fetchSingle()
            .map(record -> record.get(userJooq.name));
    }
}
