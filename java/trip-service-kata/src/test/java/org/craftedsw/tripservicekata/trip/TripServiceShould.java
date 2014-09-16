package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceShould {

    private static final User GUEST = null;
    private static final User A_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User STEVEN = new User();
    private static final Trip LONDON = new Trip();
    private static final Trip PARIS = new Trip();
    private TripService tripService;

    @Before
    public void initialise() {
        tripService = new TestableTripService();
    }

    @Test(expected= UserNotLoggedInException.class) public void
    validate_a_logged_in_user() {
        tripService.getTripsByUser(A_USER, GUEST);
    }

    @Test public void
    should_return_no_trips_when_users_are_not_friends() {
       User stranger = aUser()
                            .withFriends(STEVEN)
                            .withTrips(LONDON)
                            .build();

        List<Trip> trips = tripService.getTripsByUser(stranger, REGISTERED_USER);
        assertThat(trips.isEmpty(), is(true));
    }

    @Test public void
    should_return_trips_when_users_are_friends() {
        User friend = aUser()
                            .withFriends(STEVEN, REGISTERED_USER)
                            .withTrips(LONDON, PARIS)
                            .build();

        List<Trip> trips = tripService.getTripsByUser(friend, REGISTERED_USER);
        assertThat(trips.size(), is(2));
    }

    private class TestableTripService extends TripService {
        @Override
        protected List<Trip> getTripsBy(User user) {
            return user.trips();
        }
    }

}
