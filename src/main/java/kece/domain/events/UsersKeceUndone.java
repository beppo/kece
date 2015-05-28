package kece.domain.events;

import kece.domain.SocialSite;
import kece.domain.User;

/**
 * An event fired whenever a users kece is undone.
 */
public class UsersKeceUndone {
    /**
     * User who was kece previously
     */
    private final User user;
    /**
     * Friend who undone users kece.
     */
    private final User friend;
    /**
     * The social site on which friend undone user kece.
     */
    private final SocialSite socialSite;

    public UsersKeceUndone(User user, User friend, SocialSite socialSite) {
        this.user = user;
        this.friend = friend;
        this.socialSite = socialSite;
    }
}
