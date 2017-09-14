package main.calculators;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import main.bean.Deal;
import main.bean.TradeAct;

public class AmountRankCalculator {
// returns total trade amount of outgoing deals day by  day 
	public static Map<LocalDate, BigDecimal> dailyOutGoingAmnt(Set<Deal> deals) {

		Map<LocalDate, BigDecimal> outgoingAmnt = new HashMap<>();
// puts every outgoing deals in a map
//if key (date) does not exist put day, amount into map
//if key (date) exists update value 
		for (Deal dealItem : deals) {

			if (dealItem.getTradeAction().equals(TradeAct.Buy))
				if (outgoingAmnt.get(dealItem.getSettlementDate()) == null) {
					outgoingAmnt.put(dealItem.getSettlementDate(), dealItem.getTradeAmount());
				} else {
					outgoingAmnt.put(dealItem.getSettlementDate(),
							outgoingAmnt.get(dealItem.getSettlementDate()).add(dealItem.getTradeAmount()));
				}
		}

		return outgoingAmnt;

	}
// puts every incoming deals in a map
//if key (date) does not exist put day, amount into map
//if key (date) exists update value 
	public static Map<LocalDate, BigDecimal> dailyInComingAmnt(Set<Deal> deals) {

		Map<LocalDate, BigDecimal> inComingAmnt = new HashMap<>();

		for (Deal dealItem : deals) {

			if (dealItem.getTradeAction().equals(TradeAct.Sell))
				if (inComingAmnt.get(dealItem.getSettlementDate()) == null) {
					inComingAmnt.put(dealItem.getSettlementDate(), dealItem.getTradeAmount());
				} else {
					inComingAmnt.put(dealItem.getSettlementDate(),
							inComingAmnt.get(dealItem.getSettlementDate()).add(dealItem.getTradeAmount()));
				}
		}

		return inComingAmnt;

	}
// puts in an order deals according to trade amount of deals
// returns ordered arraylist of deals for dates
	public static Map<LocalDate, ArrayList<Deal>> rankingOutGoingDeals(Set<Deal> deals) {

		Map<LocalDate, ArrayList<Deal>> outgoingRank = new HashMap<>();

		for (Deal dealItem : deals) {

			if (dealItem.getTradeAction().equals(TradeAct.Buy)) {

				if (outgoingRank.get(dealItem.getSettlementDate()) == null) {
					ArrayList<Deal> list = new ArrayList<Deal>();
					list.add(dealItem);
					outgoingRank.put(dealItem.getSettlementDate(), list);
				} else {
					ArrayList<Deal> list = outgoingRank.get(dealItem.getSettlementDate());
					list.add(dealItem);
					outgoingRank.put(dealItem.getSettlementDate(), list);
				}

			}

		}

		for (LocalDate date : outgoingRank.keySet()) {

			ArrayList<Deal> unrankedList = outgoingRank.get(date);

			Collections.sort(unrankedList, new Comparator<Deal>() {

				public int compare(Deal deal1, Deal deal2) {
					return deal1.getTradeAmount().compareTo(deal2.getTradeAmount());
				}
			});

			outgoingRank.put(date, unrankedList);
		}

		return outgoingRank;
	}

// puts in an order deals according to trade amount of deals
// returns ordered arraylist of deals for dates	
	public static Map<LocalDate, ArrayList<Deal>> rankingIncomingDeals(Set<Deal> deals) {

		Map<LocalDate, ArrayList<Deal>> incomingRank = new HashMap<>();

		for (Deal dealItem : deals) {

			if (dealItem.getTradeAction().equals(TradeAct.Sell)) {

				if (incomingRank.get(dealItem.getSettlementDate()) == null) {
					ArrayList<Deal> list = new ArrayList<Deal>();
					list.add(dealItem);
					incomingRank.put(dealItem.getSettlementDate(), list);
				} else {
					ArrayList<Deal> list = incomingRank.get(dealItem.getSettlementDate());
					list.add(dealItem);
					incomingRank.put(dealItem.getSettlementDate(), list);
				}

			}

		}

		for (LocalDate date : incomingRank.keySet()) {

			ArrayList<Deal> unrankedList = incomingRank.get(date);

			Collections.sort(unrankedList, new Comparator<Deal>() {

				public int compare(Deal deal1, Deal deal2) {
					return deal1.getTradeAmount().compareTo(deal2.getTradeAmount());
				}
			});

			incomingRank.put(date, unrankedList);
		}

		return incomingRank;
	}

}
