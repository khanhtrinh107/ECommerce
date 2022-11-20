package SpringMVCDemo7.service;

import java.util.List;

import SpringMVCDemo7.pojos.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	Customer getCustomer(int id);
	void saveCustomer(Customer customer);
	void deleteCustomer(int id);
}
