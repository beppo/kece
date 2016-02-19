package kece.domain.events;

import kece.domain.User;

public class UserLoggedOut extends Event {

	private final User user;

	public UserLoggedOut(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
