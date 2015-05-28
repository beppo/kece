package kece.domain.events;

import kece.domain.SocialSite;
import kece.domain.User;

/**
 * An event fired whenever a user is made kece.
 */
public class UserMadeKece {
    /**
     * User that is kece now.
     */

    private final User kece;
    /**
     * User that made kece.
     */
    private final User keceleyen;

    /**
     * Social site on which kece has happened.
     */
    private final SocialSite socialSite;

    public UserMadeKece(User kece, User keceleyen, SocialSite socialSite) {
        this.kece = kece;
        this.keceleyen = keceleyen;
        this.socialSite = socialSite;
    }
}
