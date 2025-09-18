import React, { useEffect, useState } from 'react';
import CustomerService from '../services/CustomerService';
import { toast } from 'react-toastify';

function CustomerList() {
    const [customers, setCustomers] = useState([]);

    const fetchCustomers = () => {
        CustomerService.getAllCustomers()
            .then((data) => {
                setCustomers(data); // fetch returns plain JSON array
            })
            .catch(() => toast.error('Error fetching customers'));
    };

    useEffect(() => {
        fetchCustomers();
    }, []);

    const handleDelete = (id) => {
        if (!id) return;

        CustomerService.deleteCustomer(id)
            .then((res) => {
                if (res.ok) { // ✅ fetch provides .ok for 200–299 responses
                    toast.success('Customer deleted successfully');
                    fetchCustomers();
                } else {
                    toast.error('Failed to delete customer');
                }
            })
            .catch(() => toast.error('Error deleting customer'));
    };

    return (
        <div className="card shadow p-4">
            <h3 className="mb-4 text-primary">Customer List</h3>
            {customers.length === 0 ? (
                <div className="alert alert-info">No customers found.</div>
            ) : (
                <table className="table table-hover table-bordered">
                    <thead className="table-light">
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th className="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {customers.map((c, index) => (
                            <tr key={c.id}>
                                <td>{index + 1}</td>
                                <td>{c.name}</td>
                                <td>{c.email}</td>
                                <td>{c.phone}</td>
                                <td className="text-center">
                                    <button
                                        className="btn btn-sm btn-danger"
                                        onClick={() => handleDelete(c.id)}
                                    >
                                        <i className="bi bi-trash"></i> Delete
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}

export default CustomerList;
