package kece.domain.events;

import kece.domain.User;

public class UserLoggedIn extends Event {
	private final User user;

	public UserLoggedIn(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
