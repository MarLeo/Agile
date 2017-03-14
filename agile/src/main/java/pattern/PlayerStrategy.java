package pattern;

import org.joda.time.LocalDate;

public interface PlayerStrategy {
	
	Integer salary(Integer salary);
	
	void addContract(final String name, final String surname, final LocalDate start, final LocalDate end, final String club, final Integer salary);
}
