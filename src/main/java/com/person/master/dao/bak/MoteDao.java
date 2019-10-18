package com.person.master.dao.bak;

import com.person.master.dto.bak.MoteDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jjma
 * created 2019/10/16
 */
@Mapper
@Component
public interface MoteDao {

    /**
     * 获取当前用户下待办事项
     * @param user_id
     * @return
     */
    @Select("select * from mote where user_id=#{user_id} and type = #{type}")
    List<MoteDto> getUntreat(@Param("user_id") int user_id,@Param("type") int type);

    /**
     * 根据title获取指定事项
     * @param title
     * @return
     */
    @Select("select * from mote where title=#{title}")
    List<MoteDto> getMoteByTitle(@Param("title") String title);

    /**
     * 根据id查询事项
     * @param user_id
     * @return
     */
    @Select("select * from mote where user_id=#{user_id} and id = #{id}")
    List<MoteDto> getUntreatById(@Param("user_id") int user_id,@Param("id") int id);

    /**
     * 根据id删除事项
     * @param user_id
     * @param id
     */
    @Delete("delete from mote where user_id = #{user_id} and id=#{id}")
    void delNote(@Param("user_id") int user_id,@Param("id") int id);

    /**
     * 更新事项
     * @param title
     * @param content
     * @param type
     * @param id
     */
    @Update("update mote set title = #{title},content=#{content},type=#{type} where id=#{id}")
    void ediNote(@Param("title") String title,@Param("content") String content,@Param("type") int type,@Param("id") int id);

    /**
     * 根据id更新事项类型
     * @param type
     * @param id
     */
    @Update("update mote set type = #{type} where id = #{id}")
    void updateType(@Param("type") int type,@Param("id") int id);

    /**
     * 添加事项
     * @param title
     * @param content
     * @param type
     * @param user_id
     */
    @Options(useGeneratedKeys = true)
    @Insert("insert into mote(title,content,type,user_id) value(#{title},#{content},#{type},#{user_id})")
    void addMote(@Param("title") String title,@Param("content") String content,@Param("type") int type,@Param("user_id") int user_id);
}
