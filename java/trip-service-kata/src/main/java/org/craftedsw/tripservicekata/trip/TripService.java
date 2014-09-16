package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user, User loggedInUser) throws UserNotLoggedInException {
        validate(loggedInUser);

        return user.isFriendsWith(loggedInUser)
                ? getTripsBy(user)
                : new ArrayList<Trip>();
	}

    private void validate(User loggedInUser) {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> getTripsBy(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
