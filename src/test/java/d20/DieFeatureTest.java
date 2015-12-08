
package d20;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DieFeatureTest {
	
	@InjectMocks
	Die underTest;

	@Mock
	NumberGenerator numberGenerator;

	@Before
	public void setup() {
		underTest = new Die();
		initMocks(this);
	}

	@Test
	public void shouldRollTheGivenNumberOnDieRoll() {
		
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.roll(6), is(4));
	}
	
	@Test
	public void shouldAcceptAnOptionalModifier(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.roll(6, 0), is(4));
	}
	
	@Test
	public void shouldAddModifierAmountToDieRoll(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.roll(6, 1), is(5));
	}
	
	@Test
	public void shouldSubtractModifierAmountFromDieRoll(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.roll(6, -1), is(3));
	}
	
	@Test
	public void shouldRollDieWithAMinimumValueOf0(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.roll(6, -5), is(0));
	}
	
	@Test
	public void shouldRollDieWithModifierAndMinValueOf1(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.rollWithMin(6, -5), is(1));
	}
	@Test
	public void shouldRollTheDie2Times(){
		
		underTest.multiDie(2, 6);
		
		verify(numberGenerator, times(2)).roll(6);
	}
	
	@Test
	public void shouldReturnSumOfTwoDieRolls(){
		
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.multiDie(2, 6), is(8));
	}
	
	@Test
	public void shouldReturnSumOfThreeDieRolls(){
		when(numberGenerator.roll(6)).thenReturn(4);
		
		assertThat(underTest.multiDie(3, 6), is(12));
	}
	
	
}
