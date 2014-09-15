package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Test;

import java.util.List;

public class TripServiceShould {

    private static final User GUEST = new User(0);
    private static final User USER_WITH_TRIPS = new User(1);


    @Test(expected=UserNotLoggedInException.class) public void
    throw_an_exception_if_no_one_is_logged_in() {
        TripService tripService = new TripService(new UserSession(GUEST));
        List<Trip> trips = tripService.getTripsByUser(USER_WITH_TRIPS);
    }
}
