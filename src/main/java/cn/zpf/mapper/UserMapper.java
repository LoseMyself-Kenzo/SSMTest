package cn.zpf.mapper;

import cn.zpf.dto.Actor;

/**
 * Created by LoseMyself on 2017/3/3.
 */
public interface UserMapper {
    public Actor findActorById(Long id) throws Exception;
}
