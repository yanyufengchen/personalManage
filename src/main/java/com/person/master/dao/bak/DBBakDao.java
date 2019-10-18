package com.person.master.dao.bak;

import com.person.master.dto.bak.DBBakDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author jjma
 * @Date Created in 2019/08/01.
 */
@Component
@Mapper
public interface DBBakDao {

    /**
     * 获取数据备份记录
     * @param name
     * @return
     */
    @Select("<script>"
            + "SELECT sqldataback.*,user.`name` as `hr_name` FROM `sqldataback` LEFT"
            + " JOIN user ON sqldataback.hr_id = user.id"
            + "<if test='name != null and name != \"\"'>"
            + "where sqldataback.`bak_name` like \"%\"#{name}\"%\""
            + "</if>"
            + "ORDER BY sqldataback.operateDate DESC"
            + "</script>")
    List<DBBakDto> getDBbakByName(@Param("name") String name);

    /**
     * 删除数据备份
     * @param id
     * @return
     */
    @Delete("delete from sqldataback where id = #{id}")
    Integer deleteBakDB(@Param("id")Integer id);

    /**
     * 添加数据备份
     * @param dbBakDto
     */
    @Insert("insert into sqldataback(bak_name,table_name,path,node_ip,node_port,node_user,node_password," +
            " mysql_user,mysql_password,hr_id,database_name,mysql_port) values(#{bak_name},#{table_name},#{path},#{node_ip}," +
            " #{node_port},#{node_user},#{node_password},#{mysql_user},#{mysql_password},#{hr_id},#{database_name},#{mysql_port})")
    void addDBBak(DBBakDto dbBakDto);

    /**
     * 根据hrName获取HrId
     * @param name
     * @return
     */
    @Select("select id from user where name = #{name}")
    Integer getHrIdByName(@Param("name") String name);

    /**
     * 根据备份id获取备份数据详情
     * @param id
     * @return
     */
    @Select("select * from sqldataback where id = #{id}")
    DBBakDto renewDBBak(@Param("id") Integer id);

}
