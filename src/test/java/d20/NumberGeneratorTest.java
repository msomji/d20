package d20;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberGeneratorTest {
	
	NumberGenerator underTest;

	
	@Before
	public void setup(){
		underTest = new NumberGenerator();
	}
	
	
	@Test
	// what is (expect = IllegalArgumentException.class)
	public void shouldRaiseErrorIfFacesIsLessThan1(){
	
	 try {
            underTest.roll(0);
            fail("expected IllegalArgumentException for number of faces");
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("faces should be greater than 1"));
        } 
	}
	
	@Test
	public void shouldReturnANumberBetween1And10() {
		assertThat(underTest.roll(10), lessThanOrEqualTo(9));
		assertThat(underTest.roll(6), greaterThan(0));
	}
	
	@Test
	public void shouldReturnARandomNumberBetween1And10(){
		assertThat(underTest.roll(6), lessThanOrEqualTo(6));
	}
	
}
