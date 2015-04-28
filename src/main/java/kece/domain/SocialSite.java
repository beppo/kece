package kece.domain;

import kece.oose.Entity;

@Entity
public interface SocialSite {
    /**
     * Notifies user by available means that he/she has been keceed by a friend.
     *
     * @param user     user that is made kece
     * @param keceedBy user that made kece
     */
    void userKeceed(User user, User keceedBy);
}
