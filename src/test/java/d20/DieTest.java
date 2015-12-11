package d20;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DieTest {
	@InjectMocks
	private Die underTest;
	
	@Mock
	private DieStringParser dieStringParser;
	
	@Mock
	private NumberGenerator numberGenerator;
	
	String dieString = "d6";
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldRoll6FacedDieToReturnANumber() {
		when(dieStringParser.getNumOfFaces()).thenReturn(6);
		when(numberGenerator.total()).thenReturn(4);
		
		assertThat(underTest.roll(dieString), is(4));
		verify(dieStringParser).rawString(dieString);
		
	}
	
	@Test
	public void shouldRoll6FacedDieToReturnARandomNumber() {
		when(dieStringParser.getNumOfFaces()).thenReturn(6);
		
		when(numberGenerator.total()).thenReturn(5);
		assertThat(underTest.roll(dieString), is(5));	
	}
	
	
	

}
