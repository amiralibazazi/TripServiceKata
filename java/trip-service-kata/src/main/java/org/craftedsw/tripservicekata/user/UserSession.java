package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession {

    private User sessionUser;

    public UserSession(User user) {
        sessionUser = user;
    }

//	public static UserSession getInstance() {
//		return userSession;
//	}

	public User getLoggedUser() {
//		throw new CollaboratorCallException(
//				"UserSession.getLoggedUser() should not be called in an unit test");
        return sessionUser;
	}
}
