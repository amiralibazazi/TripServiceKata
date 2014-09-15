package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceShould {

    private static final User SOME_USER = new User();
    private static final User GUEST = null;
    private User loggedUser;
    TripService tripService;

    @Before
    public void initialise() {
        loggedUser = new User();
        tripService = new TestableTripService();
    }

    @Test(expected= UserNotLoggedInException.class) public void
	throw_an_exception_if_the_session_user_is_not_logged_in() {
        loggedUser = GUEST;
        tripService.getTripsByUser(SOME_USER);
	}

    @Test public void
    return_the_trips_of_a_friend_when_getTripsByUser_is_called() {
        SOME_USER.addFriend(loggedUser);
        assertThat(tripService.getTripsByUser(SOME_USER), is(SOME_USER.trips()));
    }

    private class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedUser;
        }

        @Override
        protected List<Trip> getTripsFromDAO(User user) {
            return user.trips();
        }
    }
}
