package d20;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
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
	public void shouldReturnANumberBetween1And10() {
		
		assertThat(underTest.generateRandom(10), lessThan(10));
		assertThat(underTest.generateRandom(10), greaterThan(0));
		
	}
	
//	@Test
//	public void shouldThrowIlleagalArgumentExceptionIfNumberIsNegative(){
//		
//	}

}
