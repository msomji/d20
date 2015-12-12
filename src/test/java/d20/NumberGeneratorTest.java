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
	}
	@Ignore
	@Test
	public void shouldReturnANumberBetween1And10() {
		
		assertThat(underTest.returnRandom(10), lessThan(11));
		assertThat(underTest.returnRandom(10), greaterThan(0));
		
	}
	
//	@Test
//	public void shouldThrowIlleagalArgumentExceptionIfNumberIsNegative(){
//		
//	}
	@Test
	public void shouldRollOnceIfThereisOneDie(){
		when(random.nextInt(6)).thenReturn(4);
		underTest.generateRandom(6, 1, 0, 0);
		verify(random, times(1)).nextInt(6);
		
		assertThat(underTest.total(), is(5));
		
	}
	
	@Test
	public void shouldRollTwiceIfThereAreTwoDie(){
		when(random.nextInt(6)).thenReturn(4);
		underTest.generateRandom(6, 2, 0, 0);
		verify(random, times(2)).nextInt(6);
		
		assertThat(underTest.total(), is(10));
	}
	
	@Test
	public void shouldsetMinRollValueTo0(){
		when(random.nextInt(6)).thenReturn(4);
		underTest.generateRandom(6, 20, 50, 0);
		verify(random, times(20)).nextInt(6);
		
		assertThat(underTest.total(), is(0));
	}

}
