package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<Trip>();

	private List<User> friends = new ArrayList<User>();

	public List<User> getFriends() {
		return friends;
	}

	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}

	public List<Trip> trips() {
		return trips;
	}

<<<<<<< HEAD
    public Boolean isFriendsWith(User user) {
        return friends.contains(user);
    }
=======
    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public Boolean isNotFriend(User user) {
        return !isFriend(user);
    }
>>>>>>> 77917993b64b8f82808a54082a779c8445ce61d9
}
