package should;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.bankkata.Account;
import com.bankkata.StatementPrinter;
import com.bankkata.Transaction;
import com.bankkata.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ryan on 05/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock TransactionRepository transactionRepository;
    private Account account;
    @Mock StatementPrinter statementPrinter;

    @Before
    public void initialise(){

        account = new Account( transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction(){
        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdrawal_transaction(){
        account.withdraw(100);

        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_a_statement(){

        List<Transaction> transactions = Arrays.asList(new Transaction("12/05/2015",100));

        //mmock the retrieval of transactions from transactionRepository
        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
