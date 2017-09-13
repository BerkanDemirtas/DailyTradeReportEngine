package main.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import main.calculators.SettlementDaysCalculator;

public class Deal {

	private String entity;

	private LocalDate instructionDate;

	private LocalDate settlementDate;

	

	private Currency currCode;

	private BigDecimal aggreedFx;

	private int units;

	private BigDecimal pricePerUnit;

	private BigDecimal tradeAmount;

	private TradeAct tradeAction;

	public Deal(String entity, LocalDate instructionDate, LocalDate settlementDate, Currency currCode,
			BigDecimal aggreedFx, int units, BigDecimal pricePerUnit, TradeAct tradeAction) {

		if (aggreedFx == null) {
			aggreedFx = BigDecimal.ZERO;
		}
		if (pricePerUnit == null) {
			pricePerUnit = BigDecimal.ZERO;
		}

		this.entity = entity;
		this.instructionDate = instructionDate;
		
		this.currCode = currCode;
		this.aggreedFx = aggreedFx;
		this.pricePerUnit = pricePerUnit;
		this.units = units;
		this.tradeAction = tradeAction;
		this.tradeAmount = calcAmount();
		this.settlementDate = settlementDate;
		this.settlementDate = SettlementDaysCalculator.calcDays(this);
	}

	private BigDecimal calcAmount() {
		// TODO Auto-generated method stub
		return pricePerUnit.multiply(aggreedFx).multiply(new BigDecimal(units)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public String getEntity() {
		return entity;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}


	
	public Currency getCurrCode() {
		return currCode;
	}

	public BigDecimal getAggreedFx() {
		return aggreedFx;
	}

	public int getUnits() {
		return units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public TradeAct getTradeAction() {
		return tradeAction;
	}
	
	public LocalDate getSettlementDate() {
		return this.settlementDate;
	}
}
