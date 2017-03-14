package pattern;

import org.joda.time.LocalDate;

public interface PersonAdapter {
	
	public int age(final LocalDate birthdate, final LocalDate now);

}
