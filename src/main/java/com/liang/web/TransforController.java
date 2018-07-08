package com.liang.web;

import com.liang.JsonUtil.FastJsonUtil;
import com.liang.dao.TransforMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.model.Transfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/oprateSystem/transfor")
public class TransforController {
    @Autowired
    private JourneyUserMapper journeyUserMapper;
    @Autowired
    private TransforMapper transforMapper;

    @RequestMapping("/query")
    public String queryFight(@RequestParam Integer userid, Model model) {
        model.addAttribute("localUser",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("TransforList",transforMapper.selectAll());
        return "oprate/main";
    }
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public void insertFight(Transfor transfor, Model model, HttpServletResponse responses) throws Exception{
        transforMapper.insert(transfor);
        FastJsonUtil.sendJsonData(responses,1111);

    }
    @RequestMapping(value = "/beforUpdate",method = RequestMethod.POST)
    public String beforUpdate(Transfor transfor, Model model,HttpServletResponse responses) throws Exception{
        Transfor transfor1=transforMapper.selectByPrimaryKey(transfor.getCarnum());
        FastJsonUtil.sendJsonData(responses,transfor1);
        return "sucess";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateFight(Transfor transfor, Model model,HttpServletResponse responses) throws Exception{
        responses.reset();
        transforMapper.updateByPrimaryKey(transfor);
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteFight(Transfor transfor, Model model,HttpServletResponse responses) throws Exception{
        transforMapper.deleteByPrimaryKey(transfor.getCarnum());
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }
}
