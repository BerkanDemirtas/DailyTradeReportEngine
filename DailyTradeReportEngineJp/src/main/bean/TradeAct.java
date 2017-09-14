package main.bean;


//trade action enum class 
public enum TradeAct{
		Buy("B"),
	    Sell("S");
		private String text;
		
		  TradeAct(String text) {
		        this.text = text;
		    }

		    public String getText() {
		        return this.text;
		    }
		    
		    public static TradeAct fromString(String text) {

		        if (text != null) {
		            for (TradeAct tmp : TradeAct.values()) {
		                if (text.equalsIgnoreCase(tmp.text)) {
		                    return tmp;
		                }
		            }

		            throw new IllegalArgumentException("There is no known" + text + " action!");
		        } else {
		            throw new NullPointerException("Null value supplied.");
		        }
		    }

	}
