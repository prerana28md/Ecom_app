import React, { useState } from 'react';
import CustomerService from '../services/CustomerService';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function AddCustomer() {
    const [form, setForm] = useState({
        name: '',
        email: '',
        phone: ''
    });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // field validation
        if (!form.name.trim() || !form.email.trim() || !form.phone.trim()) {
            toast.warn('Please fill in all the fields');
            return;
        }

        // email validation
        const emailRegex = /\S+@\S+\.\S+/;
        if (!emailRegex.test(form.email)) {
            toast.warn('Please enter a valid email address');
            return;
        }

        // submit to backend
        CustomerService.createCustomer(form)
            .then(() => {
                toast.success('Customer added successfully!');
                setForm({ name: '', email: '', phone: '' });
            })
            .catch(() => {
                toast.error('Error adding customer');
            });
    };

    return (
        <div className="card shadow p-4">
            <h3 className="mb-4 text-primary">Add New Customer</h3>
            <form onSubmit={handleSubmit} noValidate>
                <div className="form-floating mb-3">
                    <input
                        type="text"
                        className="form-control"
                        id="name"
                        name="name"
                        placeholder="Full Name"
                        value={form.name}
                        onChange={handleChange}
                        required
                    />
                    <label htmlFor="name">Full Name</label>
                </div>
                <div className="form-floating mb-3">
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        name="email"
                        placeholder="Email"
                        value={form.email}
                        onChange={handleChange}
                        required
                    />
                    <label htmlFor="email">Email</label>
                </div>
                <div className="form-floating mb-4">
                    <input
                        type="text"
                        className="form-control"
                        id="phone"
                        name="phone"
                        placeholder="Phone"
                        value={form.phone}
                        onChange={handleChange}
                        required
                    />
                    <label htmlFor="phone">Phone Number</label>
                </div>
                <button type="submit" className="btn btn-success w-100">
                    Add Customer
                </button>
            </form>

            {/* Toast container to display alerts */}
            <ToastContainer position="top-right" autoClose={3000} />
        </div>
    );
}

export default AddCustomer;
