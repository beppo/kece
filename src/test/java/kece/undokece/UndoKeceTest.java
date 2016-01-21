package kece.undokece;

import kece.UserIsKeceException;
import kece.dao.UserDAO;
import kece.domain.SocialSite;
import kece.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import  static org.mockito.Mockito.*;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class UndoKeceTest {
    @Mock private UserDAO userDAO;
    @Mock private SocialSite socialSite;
    private UndoKece undoKece;

    private User user;
    private User friend;

    @Before
    public void setUp() {
        undoKece = new UndoKece(userDAO);
        user = new User();
        friend = new User();
        friend.setKece(true);
        user.addFriends(socialSite, Collections.singletonList(friend));
        friend.addFriends(socialSite, Collections.singletonList(user));
    }

    @Test(expected = UserIsKeceException.class)
    public void userThatAreKeceCanNotUndoKeceFriendsKece() {
        user.setKece(true);
        undoKece.undoKece(user, friend, socialSite);
        verifyZeroInteractions(socialSite);
    }

    @Test
    public void undoKece() {
        undoKece.undoKece(user, friend, socialSite);
        verify(socialSite).usersKeceUndone(friend, user);
    }
}