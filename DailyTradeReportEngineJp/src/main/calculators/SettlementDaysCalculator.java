package main.calculators;

import java.time.LocalDate;

import main.bean.Deal;
import main.bean.days.IWorkDays;
import main.bean.days.WorkDaysArabic;
import main.bean.days.WorkDaysDefult;

public class SettlementDaysCalculator {
//returns workdays according to currency of deal
	
	public static LocalDate calcDays(Deal dealItem) {
				
			IWorkDays workday;

//for SAR and AED returns Arabic working days, for others returns default working days		
			if (dealItem.getCurrCode().getCurrencyCode().equals("SAR")
					|| dealItem.getCurrCode().getCurrencyCode().equals("AED")) {
				workday = WorkDaysArabic.getInstance();
			}

			else {
				workday = WorkDaysDefult.getInstance();
			}

			return workday.findWorkingDays(dealItem.getSettlementDate());
	}
	
}
