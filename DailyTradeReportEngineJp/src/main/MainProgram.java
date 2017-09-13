package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import main.bean.Deal;
import main.bean.TradeAct;
import main.report.ReportGenarator;

public class MainProgram {

	public static void main(String[] args) {
		
		Set<Deal> Deals  = new HashSet<Deal>();
		
		Deal d1 = new Deal("bq", LocalDate.of(2017, 1, 1), LocalDate.of(2017, 3, 3), Currency.getInstance("EUR"),
				new BigDecimal(12), 3, new BigDecimal(1.5), TradeAct.Buy);

		Deal d2 = new Deal("b4", LocalDate.of(2017, 1, 1), LocalDate.of(2017, 3, 3), Currency.getInstance("EUR"),
				new BigDecimal(111), 3, new BigDecimal(3.5), TradeAct.Buy);

		
		Deals.add(d1);
		Deals.add(d2);
		
		ReportGenarator rpt = new ReportGenarator();
		
		System.out.println(rpt.generateReports(Deals));
		
		
	}

}
