package pattern;

import org.joda.time.LocalDate;

public interface Adapter {
	
	public int age(final LocalDate birthdate, final LocalDate now);
}
