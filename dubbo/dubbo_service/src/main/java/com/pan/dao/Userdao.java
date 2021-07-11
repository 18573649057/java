package com.pan.dao;


import com.pan.pojo.User;

import java.util.List;

public interface Userdao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 添加
     * @param user
     */
    public void save(User user);

    /**
     * 删除
     * @param user
     */
    public void delete(User user);

    /**
     * 修改
     * @param user
     */
    public void updata(User user);


    /**
     * 查询所有
     * @return
     */
    public List<User> findAll();
}
