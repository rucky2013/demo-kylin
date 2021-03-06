package com.wengyingjian.demo.service;

import com.wengyingjian.demo.dao.UserDao;
import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;
import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = UserService.class, exportPath = "/userService")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<List<User>> getUsers(UserQuery userQuery) {
        return ResultUtil.genSuccessResult(userDao.findUsers(userQuery));
    }

    @Override
    public Result<Boolean> modifyUser(User user) {
        return ResultUtil.genSuccessResult(userDao.updateUser(user));
    }
}
