package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripDAOShould {
    @Test(expected= CollaboratorCallException.class) public void
    throw_exception_when_trips_are_returned() {
        new TripDAO().tripsBy(new User());
    }
}
