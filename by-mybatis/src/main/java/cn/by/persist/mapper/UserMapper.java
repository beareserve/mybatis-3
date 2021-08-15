package cn.by.persist.mapper;

import cn.by.persist.entity.User;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface UserMapper {
    User selectById(Long id);

    List<User> selectAllUser();
}
