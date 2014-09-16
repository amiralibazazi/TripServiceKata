package org.craftedsw.tripservicekata.user;

<<<<<<< HEAD
import org.craftedsw.tripservicekata.trip.UserBuilder;
import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
=======
import org.junit.Before;
import org.junit.Test;

>>>>>>> 77917993b64b8f82808a54082a779c8445ce61d9
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserShould {
<<<<<<< HEAD

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
=======
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
>>>>>>> 77917993b64b8f82808a54082a779c8445ce61d9
    }
}
