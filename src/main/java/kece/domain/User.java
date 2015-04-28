package kece.domain;

import kece.oose.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
public class User {
    private final AtomicBoolean kece = new AtomicBoolean();
    private Map<SocialSite, List<User>> friends = new ConcurrentHashMap<>();
    private boolean allowKece = true;

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
}
