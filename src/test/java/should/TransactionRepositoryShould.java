package should;

import com.bankkata.Clock;
import com.bankkata.Transaction;
import com.bankkata.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by ryan on 06/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    public static final String TODAY = "12/05/2015";
    private TransactionRepository transactionRepository;
    @Mock Clock clock;

    @Before
    public void initialise(){
        transactionRepository = new TransactionRepository();
    }

    @Test
    public void create_and_store_a_transaction(){
        given(clock.dateAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        // want right number of transactions to have been added and for transactions to match
        assertThat(transactions.size(),is(1));
        assertThat(transactions.get(0),is(transaction(TODAY,100)));
    }

    //helper method to create a Transaction for comparison purposes
    private Transaction transaction(String date, int amount){
        return new Transaction(date, amount);
    }
}
