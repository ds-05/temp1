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
public class CapacityDaoService implements Callable<Integer> {

	//int flag = 0;
	RequestPOJO request;

	CapacityDaoService() {
	}

	CapacityDaoService(RequestPOJO request) {
		this.request = request;
	}

	private static List<Capacity> capacityList = new ArrayList<>();

	static {

		try {
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 0.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 2.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 2.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22"), 0.0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws ParseException {
		String storeNumber = this.request.getStoreNo();
		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());

		List<Capacity> cap = capacityList.stream()
				.filter(capacity -> capacity.getDate().compareTo(reqDate) == 0)
				.filter(capacity -> capacity.getNoOfOrdersAccepted() > 0)
				.collect(Collectors.toList());
		return cap.size();
	}

}
