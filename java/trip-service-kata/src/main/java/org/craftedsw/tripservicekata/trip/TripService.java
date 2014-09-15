package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {
    User sessionUser;
    UserSession userSession;

    public TripService(UserSession userSession) {
        this.userSession = userSession;
        sessionUser = userSession.getLoggedUser();
    }

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        boolean isFriend = false;
		if (sessionUser.isNotGuest()) {
			for (User friend : user.getFriends()) {
				if (friend.equals(sessionUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
