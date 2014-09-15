package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {
    private User loggedUser;

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        loggedUser = getLoggedUser();
        checkIfLoggedIn();
        return (isFriend(user)) ? getTripsFromDAO(user) : new ArrayList<Trip>();
	}

    private void checkIfLoggedIn() {
        if (loggedUser==null) {
            throw new UserNotLoggedInException();
        }
    }

    private boolean isFriend(User user) {
        return user.getFriends().contains(loggedUser);
    }

    protected List<Trip> getTripsFromDAO(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
