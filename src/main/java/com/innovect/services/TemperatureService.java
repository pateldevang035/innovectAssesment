package com.innovect.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovect.dao.TemperatureDAO;
import com.innovect.entities.Temperature;

@Service
public class TemperatureService {
	@Autowired
	TemperatureDAO temperatureDao;
	
	public Collection<Temperature> getTemperature(Integer zip, Date date){
		Collection<Temperature> today = null;
		if(date == null) {
			SimpleDateFormat newDate = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = newDate.parse(newDate.format(new Date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		today = temperatureDao.getTemperature(date, zip);
		return today;
	}
}
