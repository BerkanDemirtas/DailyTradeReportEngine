package main.report;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import main.bean.Deal;
import main.calculators.AmountRankCalculator;

public class ReportGenarator {

	
//writes reports to console	
	public String generateReports(Set<Deal> deals) {
		
		StringBuilder str = new StringBuilder();
		
		
		
		
		
	 str=generateDailyOutgoingRanking(deals, str);
	 str=generateDailyIncomingRanking(deals,str);
	 str=generateDailyOutgoingAmount(deals,str);
	 str=generateDailyIncomingAmount(deals,str);
		
		
	 return str.toString();
	}
	
	
// returns outgoing amounts for every days 	
	private static StringBuilder generateDailyOutgoingAmount(Set<Deal> deals, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                AmountRankCalculator.dailyOutGoingAmnt(deals);

        stringBuilder
                .append("\n         Daily Outgoing Amount          \n")
                .append("----------------------------------------\n")
                .append("      Date             Trade Amount      \n")
                .append("----------------------------------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                .append(date).append("       ---       ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }
// returns incoming amounts for every days 	
    private static StringBuilder generateDailyIncomingAmount(Set<Deal> deals, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                AmountRankCalculator.dailyInComingAmnt(deals);

        stringBuilder
                .append("\n        Daily   Incoming  Amount          \n")
                .append("----------------------------------------\n")
                .append("      Date           Trade Amount      \n")
                .append("----------------------------------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                    .append(date).append("        ---         ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }
// returns rank list of outgoing deals for every day
    private static StringBuilder generateDailyOutgoingRanking(Set<Deal> deals, StringBuilder stringBuilder) {
        final Map<LocalDate, ArrayList<Deal>> dailyOutgoingRanking =
                AmountRankCalculator.rankingOutGoingDeals(deals);
        stringBuilder
                .append("\n           Outgoing  Ranking            \n")
                .append("----------------------------------------\n")
                .append("     Date          Rank       Entity     \n")
                .append("----------------------------------------\n");

        for (LocalDate date : dailyOutgoingRanking.keySet()) {
        	int rank =1;
            
        	for (Deal deal : dailyOutgoingRanking.get(date)) {
                stringBuilder
                    .append(date).append("   ----      ")
                    .append(rank).append("   ----    ")
                    .append(deal.getEntity()).append("\n");
                rank++;
        	}
            
        }

        return stringBuilder;
    }
// returns rank list of incoming deals for every day
    private static StringBuilder generateDailyIncomingRanking(Set<Deal> deals, StringBuilder stringBuilder) {
        final Map<LocalDate, ArrayList<Deal>> dailyIncomingRanking =
                AmountRankCalculator.rankingIncomingDeals(deals);

        stringBuilder
                .append("\n         Incoming Daily Ranking          \n")
                .append("----------------------------------------\n")
                .append("     Date          Rank       Entity     \n")
                .append("----------------------------------------\n");

        for (LocalDate date : dailyIncomingRanking.keySet()) {
            int rank=1;
        	for (Deal deal : dailyIncomingRanking.get(date)) {
                stringBuilder
                        .append(date).append("   ---      ")
                        .append(rank).append("   ---    ")
                        .append(deal.getEntity()).append("\n");
                rank++;
        	}
        }

        return stringBuilder;
    }
}

