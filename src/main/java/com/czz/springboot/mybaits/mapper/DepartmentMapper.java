package com.czz.springboot.mybaits.mapper;

import com.czz.springboot.mybaits.domain.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-19 22:19
 */
public interface DepartmentMapper {
    @Select("select * from mybatis.department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from mybatis.department where id = #{id}")
    public int deleteDept(Department department);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into mybatis.department (departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    @Update("update mybatis.department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
