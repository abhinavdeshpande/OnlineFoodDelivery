import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AddCustomerComponent } from '../add-customer/add-customer.component';
import { Address } from '../models/address';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  base_url = 'http://localhost:2703/customer/';
  fetch_customers = "all";
  add_customer = "addCustomer";
  update_customer = "updateCustomer";
  search = "search/";
  delete = "delete/"
  address: Address;
  customer: Customer;


  constructor(private http: HttpClient) { }

  fetchAllCustomers() {
    return this.http.get<Customer[]>(this.base_url + this.fetch_customers);
  }

  addCustomer(customer: Customer) {
    console.log("service mein hu ")
    return this.http.post(this.base_url + this.add_customer, customer);
  }

  updateCustomer(customer: Customer) {
    return this.http.put<Customer>(this.base_url + this.update_customer, customer);
  }

  searchCustomer(customerId: number) {
    console.log("Inside Search")
    return this.http.get<Customer[]>(this.base_url + this.search + customerId);
  }

  deleteCustomer(customerId: number) {
    return this.http.delete(this.base_url + this.delete + customerId);
  }
}

