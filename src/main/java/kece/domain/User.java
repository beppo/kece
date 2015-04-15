package kece.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class User {
    private AtomicBoolean kece;
    private HashMap<SocialSite, List<User>> friends;
    private boolean allowKece;

    public List<User> getFriends(SocialSite site) {
        return friends.get(site);
    }

    public void addFriends(SocialSite site, Collection<User> friends) {
        this.friends.put(site, new ArrayList<>(friends));
    }

    public boolean isKece() {
        return kece.get();
    }

    /**
     * This must ensure that only on user can do make kece.
     *
     * @param value
     */
    public boolean setKece(boolean value) {
        return kece.compareAndSet(!value, value);
    }

    public boolean allowKece() {
        return allowKece;
    }

    public void setAllowKece(boolean allowKece) {
        this.allowKece = allowKece;
    }

    public boolean keceFriend(User friend) {
        User user = this;
        if (user.isKece()) {
            throw new UserIsKeceException();
        }
        if (!user.allowKece()) {
            user.setAllowKece(true);
        }
        if (friend.isKece()) {
            throw new FriendIsKeceException();
        }
        if (!friend.allowKece()) {
            throw new FriendDoesNotAllowKeceException();
        }
        return friend.setKece(true);
    }
}
