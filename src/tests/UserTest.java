package tests;

import com.sadzbr.model.User;
import com.sadzbr.utils.model.UserUtil;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void loginTest() {
        User user = new User();

        user.setLogin("root");
        user.setPassword("root");
        User x = UserUtil.loginUser(user);
        Assert.assertNotNull(x);

        user.setLogin("");
        user.setPassword("");
        x = UserUtil.loginUser(user);
        Assert.assertNull(x);

        user.setLogin("root");
        user.setPassword("");
        x = UserUtil.loginUser(user);
        Assert.assertNull(x);

        user.setLogin("");
        user.setPassword("root");
        x = UserUtil.loginUser(user);
        Assert.assertNull(x);

        user.setLogin("");
        user.setPassword("105 or 1=1");
        x = UserUtil.loginUser(user);
        Assert.assertNull(x);

        user.setLogin("");
        user.setPassword("\" or \"\"=\"");
        x = UserUtil.loginUser(user);
        Assert.assertNull(x);
    }

    @Test
    public void loginUniqueTest() {
        User user = new User();
        user.setLogin("root");
        Assert.assertFalse(UserUtil.isLoginUnique(user));
        user.setLogin("uniqueLoginForSure");
        Assert.assertTrue(UserUtil.isLoginUnique(user));
    }

}
