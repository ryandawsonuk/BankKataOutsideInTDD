package should;

import static org.mockito.Mockito.verify;

import com.bankkata.Account;
import com.bankkata.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by ryan on 05/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock TransactionRepository transactionRepository;
    private Account account;

    @Before
    public void initialise(){
        account = new Account();
    }

    @Test
    public void store_a_deposit_transaction(){
        account.deposit(100);


        verify(transactionRepository).addDeposit(100);
    }
}
