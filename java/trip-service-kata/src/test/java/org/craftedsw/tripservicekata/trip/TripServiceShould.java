package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceShould {

    private static final User UNUSED_USER = new User();
    private static final User GUEST = null;
    private User loggedUser;
    TripService tripService;
    private User someUser;
    private User userWithNoFriends;

    @Before
    public void initialise() {
        loggedUser = new User();
        userWithNoFriends = new User();
        someUser = new User();
        tripService = new TestableTripService();
    }

    @Test(expected = UserNotLoggedInException.class)
    public void
    throw_an_exception_if_the_user_is_not_logged_in() {
        loggedUser = GUEST;
        tripService.getTripsByUser(UNUSED_USER);
    }

    @Test
    public void
    return_the_trips_of_a_friend() {
        someUser.addFriend(loggedUser);
        someUser.addTrip(new Trip());
        assertThat(tripService.getTripsByUser(someUser), is(someUser.trips()));
    }

    @Test
    public void
    return_nothing_if_the_trips_of_a_stranger_is_requested() {
        List<Trip> emptyList = new ArrayList<Trip>();
        userWithNoFriends.addTrip(new Trip());
        assertThat(tripService.getTripsByUser(userWithNoFriends), is(emptyList));
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
