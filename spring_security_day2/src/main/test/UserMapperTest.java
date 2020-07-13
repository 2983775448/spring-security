import com.zj.domain.User;
import com.zj.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUpdatePassword(){
        User user = new User();
        user.setUsername("jack");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");
        user.setPassword(password);

        userMapper.updatePassword(user);
    }
}
