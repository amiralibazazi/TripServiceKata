package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.UserBuilder;
import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserShould {

    private static final User BOB = new User();
    private static final User JOHN = new User();

    @Test public void
    inform_when_users_are_not_friends() {
        User user = aUser().withFriends(BOB).build();
        assertThat(user.isFriendsWith(JOHN), is(false));
    }

    @Test public void
    inform_when_users_are_friends() {
        User user = aUser().withFriends(JOHN, BOB).build();
        assertThat(user.isFriendsWith(JOHN), is(true));
    }
}
