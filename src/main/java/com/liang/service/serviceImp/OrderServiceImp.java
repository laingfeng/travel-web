package com.liang.service.serviceImp;

import com.liang.dao.FlightMapper;
import com.liang.dao.HotelMapper;
import com.liang.dao.TransforMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.dao.ReservationMapper;
import com.liang.model.Flight;
import com.liang.model.Hotel;
import com.liang.model.Transfor;
import com.liang.model.JourneyUser;
import com.liang.model.Reservation;
import com.liang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private JourneyUserMapper journeyUserMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private TransforMapper transforMapper;

    @Override
    public Boolean orderFlight(String flightNum,Integer userid) {
        JourneyUser journeyUser=journeyUserMapper.selectByPrimaryKey(userid);
        Flight flight=flightMapper.selectByPrimaryKey(flightNum);
        flight.setFlightnumavail(flight.getFlightnumavail()-1);
        Reservation reservation=new Reservation();
        reservation.setrUserid(userid);
        reservation.setrUsername(journeyUser.getUsername());
        reservation.setAssociateid(flightNum);
        reservation.setResstatus("预定成功");
        reservation.setRestype("F");
        reservationMapper.insert(reservation);
        flightMapper.updateByPrimaryKeySelective(flight);
        return true;
    }

    public  Boolean orderHotel(String hotelNum,Integer userid) {
        JourneyUser journeyUser=journeyUserMapper.selectByPrimaryKey(userid);
        Hotel hotel=hotelMapper.selectByPrimaryKey(hotelNum);
        hotel.setHotelnumavail(hotel.getHotelnumavail()-1);
        Reservation reservation=new Reservation();
        reservation.setrUserid(userid);
        reservation.setrUsername(journeyUser.getUsername());
        reservation.setAssociateid(hotelNum);
        reservation.setResstatus("预定成功");
        reservation.setRestype("H");
        reservationMapper.insert(reservation);
        hotelMapper.updateByPrimaryKeySelective(hotel);
        return true;
    }

    public  Boolean orderTransfor(String carNum,Integer userid) {
        JourneyUser journeyUser=journeyUserMapper.selectByPrimaryKey(userid);
        Transfor transfor=transforMapper.selectByPrimaryKey(carNum);
        transfor.setCarnumavail(transfor.getCarnumavail()-1);
        Reservation reservation=new Reservation();
        reservation.setrUserid(userid);
        reservation.setrUsername(journeyUser.getUsername());
        reservation.setAssociateid(carNum);
        reservation.setResstatus("预定成功");
        reservation.setRestype("T");
        reservationMapper.insert(reservation);
        transforMapper.updateByPrimaryKeySelective(transfor);
        return true;
    }


}
