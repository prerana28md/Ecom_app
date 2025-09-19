const API_URL = "https://ecom-app-1-6mjy.onrender.com/customers";

// Get all customers
const getAllCustomers = () => {
  return fetch(API_URL).then(res => res.json());
};

// Create a new customer
const createCustomer = (customer) => {
  return fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(customer),
  }).then(res => res.json());
};

// Delete a customer by ID
const deleteCustomer = (id) => {
  return fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
};

const CustomerService = {
  getAllCustomers,
  createCustomer,
  deleteCustomer,
};

export default CustomerService;
