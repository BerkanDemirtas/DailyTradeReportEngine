package main.bean.days;

import java.time.LocalDate;

public interface IWorkDays {

	
	LocalDate findWorkingDays(LocalDate date);
}
