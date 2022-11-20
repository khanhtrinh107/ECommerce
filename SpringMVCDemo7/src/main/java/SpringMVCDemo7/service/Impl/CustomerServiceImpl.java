package SpringMVCDemo7.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCDemo7.pojos.Customer;
import SpringMVCDemo7.repository.CustomerRepository;
import SpringMVCDemo7.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.getCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepository.getCustomer(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.saveCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteCustomer(id);
	}
	
}
