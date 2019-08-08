package com.akhil.ecom;

import org.springframework.scheduling.annotation.Scheduled;
/**
 * 
 * @author akhil
 *
 */
//@Component
public class TrendingProducts {

	@Scheduled(fixedRate=30000)
	public void updateTrendingProducts(){
		//Generate random numbers and update the trending flag for those products
	}
}
