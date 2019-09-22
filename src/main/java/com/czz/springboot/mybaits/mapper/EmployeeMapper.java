package com.czz.springboot.mybaits.mapper;

import com.czz.springboot.mybaits.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 8:46
 */
public interface EmployeeMapper {
    @Select("select *  from mybatis.employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update mybatis.employee set lastName = #{lastName},email = #{email},gender = #{gender},d_id = #{dId}")
    public void updateEmp(Employee employee);

    @Update("insert into mybatis.employee (lastName,email,gender,d_id) values (#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Delete("delete from mybatis.employee where id = #{id}")
    public void deleteEmp(Integer id);

    @Select("select *  from mybatis.employee where lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
