package SpringMVCDemo7.repository;

import java.util.List;

import SpringMVCDemo7.pojos.Customer;

public interface CustomerRepository {
	Customer getCustomer(int id);
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	void deleteCustomer(int id);
}
