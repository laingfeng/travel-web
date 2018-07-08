package com.liang.service.serviceImp;

import com.liang.dao.JourneyUserMapper;
import com.liang.model.JourneyUser;
import com.liang.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private  JourneyUserMapper journeyUserMapper;

    private Logger logger=Logger.getLogger(LoginServiceImp.class);

    @Override
    public boolean compareInfo(JourneyUser user) {
       List<JourneyUser> journeyUserList= journeyUserMapper.selectByName(user.getUsername());
       if (journeyUserList.size()>1){
           logger.error("用户名相同的不止一位，请确认");
           return false;
       }
       if (journeyUserList.size()==1){
           if (journeyUserList.get(0).getPassword().equals(user.getPassword())){
               return true;
           }
       }
        return false;
    }
}
