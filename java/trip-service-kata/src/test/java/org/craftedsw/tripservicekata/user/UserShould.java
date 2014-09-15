package org.craftedsw.tripservicekata.user;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserShould {
    User user1;
    User user2;

    @Before
    public void initialise() {
        user1 = new User();
        user2 = new User();
    }
    @Test public void
    inform_if_a_user_is_a_friend() {
        user1.addFriend(user2);
        assertThat(user1.isFriend(user2), is(true));
    }

    @Test public void
    inform_if_a_user_is_not_a_friend() {
        assertThat(user1.isNotFriend(user2), is(true));
    }
}
