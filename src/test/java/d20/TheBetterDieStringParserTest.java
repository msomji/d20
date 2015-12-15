package d20;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TheBetterDieStringParserTest {
	@InjectMocks
	TheBetterDieStringParser underTest;
	
	@Before
	public void setup(){
		initMocks(this);
	}
	
	@Test
	public void shouldSetNumOfFacesFieldto6() {
		String dieString = "d6";
		underTest.setFields(dieString);
		assertThat(underTest.getNumOfFaces(), is(6));		
	}
	
	@Test
	public void shouldSetNumOfFacesFieldto5() {
		String dieString = "d5";
		underTest.setFields(dieString);
		assertThat(underTest.getNumOfFaces(), is(5));		
	}
	
//	
//	@Test
//	public void shouldReturnThatThereAreTwoDie(){
//		underTest.rawString("2d5");
//		assertThat(underTest.getNumOfDie(), is(2));
//	}
//	
//	@Test
//	public void shouldReturnThatThereAreTenDie(){
//		underTest.rawString("10d5");
//		assertThat(underTest.getNumOfDie(), is(10));
//	}
//	
//	@Test
//	public void shouldReturn0ModifierifNoneArePassed(){
//		underTest.rawString("2d5");
//		assertThat(underTest.getNegativeModifier(), is(0));
//		assertThat(underTest.getPositiveModifier(), is(0));
//	}
//
//	@Test
//	public void shouldReturn3When3IsPassed(){
//		underTest.rawString("2d5+3");
//		assertThat(underTest.getPositiveModifier(), is(3));
//	}
//	
//	@Test
//	public void shouldReturn30WhenPositive30ModifierIsPassed(){
//		underTest.rawString("2d5+30");
//		assertThat(underTest.getPositiveModifier(), is(30));
//	}
//	
//	@Test
//	public void shouldReturnNegativeModifier3WhenNegative3ModifierIsPassed(){
//		underTest.rawString("2d5-3");
//		assertThat(underTest.getNegativeModifier(), is(3));
//		assertThat(underTest.getPositiveModifier(), is(0));
//	}

}
