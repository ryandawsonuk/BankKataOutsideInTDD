package should;

import com.bankkata.Clock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ryan on 06/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClockShould {

    private Clock clock;

    @Before
    public void initialise(){
        clock = new TestatableClock();
    }

    /**
     * The side-effect to test for is the format of the date but need to control the date to test this
     */
    @Test
    public void return_todays_date_in_dd_MM_yyyy(){
        String date = clock.dateAsString();

        assertThat( date, is("24/04/2015"));
    }

    /**
     * Control the date returned by our Clock
     */
    private class TestatableClock extends Clock {
        @Override
        protected LocalDate today(){
            return LocalDate.of(2015,4,24);
        }
    }
}
