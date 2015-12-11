package d20;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NumberGeneratorTest {

	@InjectMocks
	NumberGenerator underTest;
	
	@Mock
	Random random;
	

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		underTest = new NumberGenerator();
	}
	
	@Test
	public void shouldReturnANumberBetween1And10() {
		
		assertThat(underTest.random(10), lessThan(11));
		assertThat(underTest.random(10), greaterThan(0));
		
	}
	
//	@Test
//	public void shouldThrowIlleagalArgumentExceptionIfNumberIsNegative(){
//		
//	}
	@Test
	public void shouldRollTwiceIfThereAreTwoDie(){
		underTest.generateRandom(6, 2, 0, 0);
//TODO: How to put a verify so that I can see rand.nextInt(was called twice)
		when(random.nextInt(6)).thenReturn(4);
		assertThat(underTest.total(), is(10));
	}

}
