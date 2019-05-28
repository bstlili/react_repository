package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.bean.UserExample;
import com.briup.apps.tb_app01.mapper.UserMapper;
import com.briup.apps.tb_app01.mapper.extend.UserExtendMapper;
import com.briup.apps.tb_app01.service.IUserService;
import com.briup.apps.tb_app01.utils.PageVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//用户接口实现类

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public PageVM<User> pageQuery(int page, int pageSize) {
        // 查询当前页中的数据
        List<User> list = userExtendMapper.pageQuery(page,pageSize);
        // 统计总共条数
        long total = userExtendMapper.count();
        PageVM<User> pageVM = new PageVM<>();
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        pageVM.setList(list);
        pageVM.setTotal(total);
        return pageVM;
    }

    @Override
    public List<User> query(User user) {
        // 用户名 姓名 性别 类型
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.getRealname()!=null){
            criteria.andRealnameLike("%"+user.getRealname()+"%");
        }
        if(user.getUsername()!=null){
            criteria.andUsernameLike("%"+user.getUsername()+"%");
        }
        if(user.getGender()!=null){
            criteria.andGenderEqualTo(user.getGender());
        }
        if(user.getType()!=null){
            criteria.andTypeEqualTo(user.getType());
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findAll() {
        UserExample example=new UserExample();
        List<User> list=userMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<User> findByType(String type) {
        UserExample example = new UserExample();
        example.createCriteria().andTypeEqualTo(type);
        return userMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(User user) {
        if(user.getId()!=null){
            User db_user = findById(user.getId());
            //将获取的值覆盖掉
            db_user.setUsername(user.getUsername());
            db_user.setRealname(user.getRealname());
            db_user.setGender(user.getGender());
            userMapper.updateByPrimaryKey(db_user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) {
        for(long id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
    }
}






