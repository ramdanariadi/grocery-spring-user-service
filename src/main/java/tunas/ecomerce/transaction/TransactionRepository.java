package tunas.ecomerce.transaction;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

    @Query("select t.id as id, t.totalPrice as totalPrice, t.transactionDate as transactionDate, " +
            "t.userName as userName, t.userMobile as userMobile, " +
            "t.userEmail as userEmail "+
            "from Transaction t where t.id = :id")
    ITransactionResponse getTransactionById(@Param("id") UUID id);

    @Query("select t.id as id, t.totalPrice as totalPrice, t.transactionDate as transactionDate, " +
            "t.userName as userName, t.userMobile as userMobile, " +
            "t.userEmail as userEmail "+
            "from Transaction t where t.user.id = :id")
    List<ITransactionResponse> getTransactionsByUserId(@Param("id") UUID id);

    interface ITransactionResponse{
        UUID getId();
        Long getTotalPrice();
        Date getTransactionDate();
        String getUserName();
        String getUserMobile();
        String getUserEmail();
    }

    @Transactional
    @Modifying
    @Query("delete from Transaction t where t.id = :id")
    int destroyTransaction(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("delete from DetailTransaction t where t.transaction.id = :id")
    int destroyTransactionDetail(@Param("id") UUID id);
}
