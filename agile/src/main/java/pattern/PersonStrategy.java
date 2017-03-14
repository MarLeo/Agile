package pattern;

import org.joda.time.LocalDate;

public interface PersonStrategy {

	public int Age(final LocalDate birthdate, final LocalDate now);	
}
