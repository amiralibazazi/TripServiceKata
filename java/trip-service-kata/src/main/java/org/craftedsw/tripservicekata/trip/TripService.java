package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedInUser = getLoggedUser();
        validate(loggedInUser);
        return (user.isFriend(loggedInUser)) ? getTripsFromDAO(user) : new ArrayList<Trip>();
	}

    private void validate(User loggedInUser) throws UserNotLoggedInException {
        if (loggedInUser==null) {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> getTripsFromDAO(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
