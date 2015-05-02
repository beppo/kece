package kece.events;

import kece.domain.User;

/**
 * This event is fired whenever a user is made kece.
 */
public class UserKece {
    /**
     * User that has been made kece
     */
    private final User user;
    /**
     * Friend who made user kece.
     */
    private final User friend;


    public UserKece(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }
}
