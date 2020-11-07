import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../models/address';

import { Customer } from '../models/customer';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {

  deleteMessage=false; 
  cust:Customer[];
  address:Address[];
  customerId:number;
  constructor(private customerService:CustomerService,private router : Router) { }

  ngOnInit() {
    this.fetchAllCustomers();
  }


  fetchAllCustomers(){
    this.customerService.fetchAllCustomers().subscribe(response=>{
        this.cust = response;
      })
  }
 deleteCustomer(customerId: number) {  
   this.customerService.deleteCustomer(customerId)
     .subscribe(  
       data => {  
         console.log(data);  
         this.deleteMessage=true;  
         this.customerService.fetchAllCustomers().subscribe(data =>{  
           this.cust =data  
           })  
       },  
       error => console.log(error));  

      
 }  
    
  

   search(){
    console.log("Seach it is")
     this.customerService.searchCustomer(this.customerId).subscribe(response=>this.cust=response);
  
  }

  list(){
    this.fetchAllCustomers(); 
  }
}
