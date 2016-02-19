package kece.domain.events;

import kece.domain.SocialSite;
import kece.domain.User;

/**
 * An event fired whenever a user is made kece.
 */
public class UserMadeKece extends Event{
    /**
     * User that is kece now.
     */
    private final User user;

    /**
     * Users friend that made him/her kece.
     */
    private final User friend;

    /**
     * Social site on which kece has happened.
     */
    private final SocialSite socialSite;

    public UserMadeKece(User user, User friend, SocialSite socialSite) {
        this.user = user;
        this.friend = friend;
        this.socialSite = socialSite;
    }

	public User getUser() {
		return user;
	}

	public User getFriend() {
		return friend;
	}

	public SocialSite getSocialSite() {
		return socialSite;
	}
}
