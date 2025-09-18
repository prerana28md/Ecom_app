import logo from './logo.svg';
import './App.css';
import React from 'react';
import {BrowserRouter as Router,Routes,Route,Link} from 'react-router-dom';
import AddCustomer from './components/AddCustomer';
import CustomerList from './components/CustomerList';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function App() {
  return (
    <Router>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">Customer App</Link>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <Link className="nav-link" to="/">Add Customer</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/list">View Customer</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<AddCustomer/>}/>
          <Route path="/list" element={<CustomerList/>}/>
        </Routes>
      </div>
    </Router>
  )
};
    
export default App;