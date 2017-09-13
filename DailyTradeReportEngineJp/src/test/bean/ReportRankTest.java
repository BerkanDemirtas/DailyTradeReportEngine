package test.bean;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import main.bean.Deal;
import main.bean.TradeAct;
import main.calculators.AmountRankCalculator;

public class ReportRankTest {

	private Deal deal;
	private Deal deal2;
	private Deal deal3;
	private Deal deal4;
	Set<Deal> deals;
	LocalDate instDate = LocalDate.of(2017, 9, 13);
	LocalDate settDate = LocalDate.of(2017, 9, 13);

	@Before
	public void setUp() throws Exception {

		deals = new HashSet<>();

		deal = new Deal("Deal1", instDate, settDate, Currency.getInstance("SAR"), new BigDecimal(5.3), 100,
				new BigDecimal(3.35), TradeAct.Buy);
		deal2 = new Deal("Deal1", instDate, settDate, Currency.getInstance("SAR"), new BigDecimal(5.4), 50,
				new BigDecimal(3.35), TradeAct.Buy);
		deal3 = new Deal("Deal1", instDate, settDate, Currency.getInstance("USD"), new BigDecimal(5.51), 40,
				new BigDecimal(4.35), TradeAct.Sell);
		deal4 = new Deal("Deal1", instDate, settDate, Currency.getInstance("SAR"), new BigDecimal(5.1), 70,
				new BigDecimal(2.35), TradeAct.Sell);

		deals.add(deal);
		deals.add(deal2);
		deals.add(deal3);
		deals.add(deal4);

	}

	@Test
	public void test() {

		assertEquals(AmountRankCalculator.dailyInComingAmnt(deals).get(settDate),deal3.getTradeAmount().add(deal4.getTradeAmount()));

		assertEquals(AmountRankCalculator.dailyOutGoingAmnt(deals).get(settDate),deal.getTradeAmount().add(deal2.getTradeAmount()));

		assertTrue(AmountRankCalculator.rankingIncomingDeals(deals).get(settDate).size()==2);
		
		assertEquals(AmountRankCalculator.rankingIncomingDeals(deals).get(settDate).get(0),deal4);
		
		assertEquals(AmountRankCalculator.rankingOutGoingDeals(deals).get(settDate).get(0),deal2);

		
		
		
	}

}
