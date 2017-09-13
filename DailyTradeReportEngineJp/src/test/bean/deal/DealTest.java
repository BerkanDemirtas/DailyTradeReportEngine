package test.bean.deal;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import org.junit.Before;
import org.junit.Test;

import main.bean.Deal;
import main.bean.TradeAct;

public class DealTest {

	
	private Deal deal;
	
	@Before
	public void setUp() throws Exception {
		LocalDate instDate= LocalDate.of(2017, 9, 13);
		LocalDate settDate= LocalDate.of(2017, 9, 13);
		
		
		deal= new Deal("Deal1", instDate, settDate, Currency.getInstance("SAR"),new BigDecimal(5.3), 100, new BigDecimal(3.35), TradeAct.Buy);
		
	}

	@Test
	public void DealInit() {
		assertEquals(new BigDecimal(5.3), deal.getAggreedFx());
		assertEquals(LocalDate.of(2017, 9, 13), deal.getSettlementDate());
		assertEquals(100, deal.getUnits());
		assertEquals(new BigDecimal(3.35), deal.getPricePerUnit());
		
		BigDecimal tradeAmount = new BigDecimal(5.3).multiply(new BigDecimal(3.35)).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(tradeAmount, deal.getTradeAmount());
		
	}

}
