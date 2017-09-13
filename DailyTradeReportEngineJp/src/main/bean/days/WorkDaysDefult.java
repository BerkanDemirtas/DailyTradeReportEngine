package main.bean.days;

import java.time.DayOfWeek;

public class WorkDaysDefult extends WorkDays {

	public static WorkDaysDefult getInstance() {
		return new WorkDaysDefult();

	}

	private WorkDaysDefult() {
		super();
	}

	@Override
	protected void organizeDays() {
		// TODO Auto-generated method stub
		this.workDaysMap.put(DayOfWeek.MONDAY, true);
		this.workDaysMap.put(DayOfWeek.TUESDAY, true);
		this.workDaysMap.put(DayOfWeek.WEDNESDAY, true);
		this.workDaysMap.put(DayOfWeek.THURSDAY, true);
		this.workDaysMap.put(DayOfWeek.FRIDAY, true);
		this.workDaysMap.put(DayOfWeek.SATURDAY, false);
		this.workDaysMap.put(DayOfWeek.SUNDAY, false);
	}

}
