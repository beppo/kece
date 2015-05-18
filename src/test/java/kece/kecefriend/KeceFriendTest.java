package kece.kecefriend;

import kece.UserIsKeceException;
import kece.dao.UserDAO;
import kece.domain.SocialSite;
import kece.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class KeceFriendTest {

    @Mock private UserDAO userDAO;
    @Mock private SocialSite socialSite;
    private KeceFriend keceFriend;
    private User user;
    private User friend;

    @Before
    public void setUp() {
        keceFriend = new KeceFriend(userDAO);
        user = new User();
        friend = new User();
        user.addFriends(socialSite, Arrays.asList(friend));
        friend.addFriends(socialSite, Arrays.asList(user));
    }

    @Test(expected = UserIsKeceException.class)
    public void keceUserCanNotKeceOtherUsers() {
        user.setKece(true);
        keceFriend.keceFriend(user, friend, socialSite);
        verifyZeroInteractions(socialSite);
    }

    @Test(expected = FriendIsKeceException.class)
    public void keceFriendsCanNotBeKeceedAgain() {
        friend.setKece(true);
        keceFriend.keceFriend(user, friend, socialSite);
        verifyZeroInteractions(socialSite);
    }

    @Test
    public void friendIsKece() {
        keceFriend.keceFriend(user, friend, socialSite);
        assertTrue(friend.isKece());
        verify(socialSite).userMadeKece(friend, user);
    }
}