package main.bean.days;

import java.time.LocalDate;
//working days interface for different calenders 
public interface IWorkDays {

	
	LocalDate findWorkingDays(LocalDate date);
}
