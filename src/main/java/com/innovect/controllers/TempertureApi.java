package com.innovect.controllers;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovect.entities.Temperature;
import com.innovect.services.TemperatureService;

@RestController
public class TempertureApi {
	@Autowired
	TemperatureService temperatureService;

	@RequestMapping(path = "/weather/city/{zip}/date/*", method = RequestMethod.GET)
	public Collection<Temperature> getTemperature(@PathVariable("zip") Integer zip,@DateTimeFormat(pattern="yyyy-MM-dd") @PathVariable(name = "date", required = false) Date date) {
		Collection<Temperature> today = null;
		today = temperatureService.getTemperature(zip, date);
		return today;
	}
}
