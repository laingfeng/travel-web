package com.liang.web;

import com.liang.JsonUtil.FastJsonUtil;
import com.liang.dao.HotelMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.model.Hotel;
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
@RequestMapping(value = "/oprateSystem/hotel")
public class HotelController {
    @Autowired
    private JourneyUserMapper journeyUserMapper;
    @Autowired
    private HotelMapper hotelMapper;

    @RequestMapping("/query")
    public String queryFight(@RequestParam Integer userid, Model model) {
        model.addAttribute("localUser",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",hotelMapper.selectAll());
        return "oprate/main";
    }
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public void insertFight(Hotel hotel, Model model, HttpServletResponse responses) throws Exception{
        hotelMapper.insert(hotel);
        FastJsonUtil.sendJsonData(responses,1111);

    }
    @RequestMapping(value = "/beforUpdate",method = RequestMethod.POST)
    public String beforUpdate(Hotel hotel, Model model,HttpServletResponse responses) throws Exception{
        Hotel hotel1=hotelMapper.selectByPrimaryKey(hotel.getHotelnum());
        FastJsonUtil.sendJsonData(responses,hotel1);
        return "sucess";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateFight(Hotel hotel, Model model,HttpServletResponse responses) throws Exception{
        responses.reset();
        hotelMapper.updateByPrimaryKey(hotel);
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deleteFight(Hotel hotel, Model model,HttpServletResponse responses) throws Exception{
        hotelMapper.deleteByPrimaryKey(hotel.getHotelnum());
        FastJsonUtil.sendJsonData(responses,1111);
        return "sucess";
    }
}
