package repository;

import model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);
    List<Customer> findByName(String name);
    List<Customer> findByPhoneOrEmail(String phone, String email);
    List<Customer> findBySexAndBirthday(boolean sex, LocalDateTime year);

}
