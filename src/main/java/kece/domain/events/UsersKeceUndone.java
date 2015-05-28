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
    private final User kece;
    /**
     * Users friend who undone users kece.
     */
    private final User acan;
    /**
     * The social site on which friend undone user kece.
     */
    private final SocialSite socialSite;

    public UsersKeceUndone(User kece, User acan, SocialSite socialSite) {
        this.kece = kece;
        this.acan = acan;
        this.socialSite = socialSite;
    }
}
