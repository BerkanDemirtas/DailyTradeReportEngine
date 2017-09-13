/**
 * 
 */
package main.bean.days;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Berkan
 *
 */
public abstract class WorkDays implements IWorkDays{

	
	protected Map<DayOfWeek, Boolean> workDaysMap = new HashMap<>();
	protected abstract void organizeDays();
	
	public WorkDays() {
	
		organizeDays();
	}
	
	@Override
	public LocalDate findWorkingDays(LocalDate date) {
		// TODO Auto-generated method stub
		final DayOfWeek day = date.getDayOfWeek();
		if(workDaysMap.get(day)){
			return date;
		}else{
			return findWorkingDays(date.plusDays(1));
		}
		
	}
	
}
