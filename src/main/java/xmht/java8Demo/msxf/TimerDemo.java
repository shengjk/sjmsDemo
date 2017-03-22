package msxf;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by shengjk1 on 2016/12/5.
 */
public class TimerDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Instant.now().toEpochMilli());
		System.out.println(Instant.now());
		Instant instant=Instant.now();
		System.out.println("========= "+instant.toEpochMilli());
//		Thread.currentThread().sleep(1000);
		Instant instant1=instant.now();
		System.out.println("********** "+instant1.toEpochMilli());
		Duration duration=Duration.between(instant,instant1);
		long millis=duration.toMillis();
		System.out.println(millis);
		
		//本地时间
		LocalDate today=LocalDate.now();
		LocalDateTime today1=LocalDateTime.now();
		LocalTime today2=LocalTime.now();
		System.out.println(today.toString());
		System.out.println(today1.toString());
		System.out.println(today2.toString());
		
		LocalDate localDate=LocalDate.of(2016,12,5);
		System.out.println(localDate.toString());
		
		System.out.println(LocalDate.of(2016,1,1).plusDays(256).toString());
		System.out.println(LocalDate.of(2016,1,1).plusDays(256).plus(Period.ofYears(1)).toString());
		
		
		LocalDate firstTuesday=LocalDate.of(2016,12,1).withDayOfMonth(2);//2016-12-02
		System.out.println(firstTuesday.toString());
		//某一个月的第一个周二
		LocalDate firstTuesday1=LocalDate.of(2016,12,1).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));//2016-12-02
		System.out.println(firstTuesday1.toString());
		
		//格式化
//		String formatted= DateTimeFormatter.ISO_DATE.format(firstTuesday1);
		DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String formatted= formatter.format(firstTuesday1);
		System.out.println(formatted);
		
	}
}
