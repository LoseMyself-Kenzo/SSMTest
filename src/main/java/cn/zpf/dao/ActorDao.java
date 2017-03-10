package cn.zpf.dao;

import cn.zpf.dto.Actor;
/**
 * Created by LoseMyself on 2017/3/9.
 */
public interface ActorDao {

    // 根据Id查用户信息
    public Actor findUserById(Long id) throws Exception;

}
