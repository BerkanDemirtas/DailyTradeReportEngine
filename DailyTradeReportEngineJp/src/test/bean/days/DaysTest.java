package test.bean.days;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import main.bean.days.IWorkDays;
import main.bean.days.WorkDaysArabic;
import main.bean.days.WorkDaysDefult;

public class DaysTest {

	private IWorkDays workingDays;
	private IWorkDays workingDaysArabia;

	@Before
	public void setUp() throws Exception {
		workingDays = WorkDaysDefult.getInstance();
		workingDaysArabia = WorkDaysArabic.getInstance();
	}

	@Test
	public void firstWorkingDay() {

		LocalDate friday = LocalDate.of(2017, 9, 15);
		LocalDate saturday = LocalDate.of(2017, 9, 16);
		LocalDate sunday = LocalDate.of(2017, 9, 17);
		LocalDate monday = LocalDate.of(2017, 9, 18);

		// control monday
		assertEquals(monday, workingDaysArabia.findWorkingDays(monday));

		assertEquals(monday, workingDays.findWorkingDays(monday));

		// control friday
		assertEquals(sunday, workingDaysArabia.findWorkingDays(friday));

		assertEquals(friday, workingDays.findWorkingDays(friday));

		// control saturday
		assertEquals(sunday, workingDaysArabia.findWorkingDays(saturday));

		assertEquals(monday, workingDays.findWorkingDays(saturday));

		// control sunday
		assertEquals(sunday, workingDaysArabia.findWorkingDays(sunday));

		assertEquals(monday, workingDays.findWorkingDays(sunday));

	}

}
