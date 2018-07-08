package com.liang.service.serviceImp;

import com.liang.dao.FlightMapper;
import com.liang.dao.HotelMapper;
import com.liang.dao.ReservationMapper;
import com.liang.dao.TransforMapper;
import com.liang.model.Flight;
import com.liang.model.Hotel;
import com.liang.model.Reservation;
import com.liang.model.Transfor;
import com.liang.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyServiceImp implements MyService{
    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private TransforMapper transforMapper;

    @Autowired
    private ReservationMapper reservationMapper;


    @Override
    public Map<String, Object> getOrderInfo(Integer userid) {
        List<Reservation>  reservationList=reservationMapper.selectByUserId(userid);
        Map<String,Object> reserMap=new HashMap<String, Object>();
        List<Flight> flightList=new ArrayList<Flight>();
        List<Hotel> hotelList=new ArrayList<Hotel>();
        List<Transfor> transforList=new ArrayList<Transfor>();
        for (Reservation reservation:reservationList){
            System.out.print(reservation.getRestype());
            if (reservation.getRestype().equals("F")){
                flightList.add(flightMapper.selectByPrimaryKey(reservation.getAssociateid()));
            }
            if (reservation.getRestype().equals("T")){
                transforList.add(transforMapper.selectByPrimaryKey(reservation.getAssociateid()));
            }
            if (reservation.getRestype().equals("H")){
                hotelList.add(hotelMapper.selectByPrimaryKey(reservation.getAssociateid()));
            }
        }
        reserMap.put("flightList",flightList);
        reserMap.put("transforList",transforList);
        reserMap.put("hotelList",hotelList);
        return reserMap;
    }
}
