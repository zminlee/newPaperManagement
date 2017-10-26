import com.ecust.Entity.User;
import com.ecust.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DoveXL on 2017/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void Test()
    {
        User user =userService.getUser("mengweiqiang");
        System.out.println(user.getName());
    }

}
