package com.pan.dao;
import com.github.pagehelper.PageInfo;
import com.pan.bean.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompanyDao {
    //查询全部
    @Select("SELECT * FROM st_company")
    public List<Company> findAll();
    //添加
    @Insert("INSERT INTO st_company VALUE(id=#{id},name=#{name},expirationDate=#{expirationDate},address=#{address},licenseId=#{licenseId},representative=#{representative},phone=#{phone},companySize=#{companySize},industry=#{industry},remarks=#{remarks},state=#{state},city=#{city})")
    public void save(Company company);
    //根据ID查询
    @Select("SELECT * FROM st_company WHERE id=#{id}")
    public Company findById(String id);
    //根据id查询
    @Delete("DELETE * WHERE id=#{id}")
    public void delete(Company company);

    //修改
    @Update("UPDATE INTO st_company VALUE(name=#{name},expirationDate=#{expirationDate},address=#{address},licenseId=#{licenseId},representative=#{representative},phone=#{phone},companySize=#{companySize},industry=#{industry},remarks=#{remarks},state=#{state},city=#{city}) WHERE id=#{id}\")\n")
    public void update(Company company);

    //分页查询
    @Select("SELECT * FROM st_company")
    public PageInfo findAll(int page, int size);
}
