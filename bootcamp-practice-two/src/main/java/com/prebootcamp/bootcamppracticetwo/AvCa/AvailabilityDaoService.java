package com.prebootcamp.bootcamppracticetwo.AvCa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class AvailabilityDaoService implements Callable<Integer> {
	
	RequestPOJO request;

	AvailabilityDaoService() {
	}

	AvailabilityDaoService(RequestPOJO request) {
		this.request = request;
	}

	//int flag = 0;
	
	private static List<Availability> availabilityList = new ArrayList<>();

	static {

		try {
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 1.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 3.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 0.0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Integer call() throws ParseException {
		String storeNumber = this.request.getStoreNo();
		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());

		List<Availability> avail = availabilityList.stream()
				.filter(availability -> availability.getDate().compareTo(reqDate) == 0)
				.filter(availability -> availability.getAvailQty() > 0)
				.collect(Collectors.toList());
		return avail.size();
	}

}
