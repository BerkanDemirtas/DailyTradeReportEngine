package main.bean.days;

import java.time.DayOfWeek;

public class WorkDaysArabic extends WorkDays {
	//arabic working days
	public static WorkDaysArabic getInstance() {
		return new WorkDaysArabic();

	}

	private WorkDaysArabic() {
		super();
	}
	//set status of days for arabic working days
	@Override
	protected void organizeDays() {
		// TODO Auto-generated method stub
		this.workDaysMap.put(DayOfWeek.MONDAY, true);
		this.workDaysMap.put(DayOfWeek.TUESDAY, true);
		this.workDaysMap.put(DayOfWeek.WEDNESDAY, true);
		this.workDaysMap.put(DayOfWeek.THURSDAY, true);
		this.workDaysMap.put(DayOfWeek.FRIDAY, false);
		this.workDaysMap.put(DayOfWeek.SATURDAY, false);
		this.workDaysMap.put(DayOfWeek.SUNDAY, true);
	}

}
