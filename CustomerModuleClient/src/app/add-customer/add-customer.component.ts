import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute , Router} from '@angular/router';
import { Address } from '../models/address';
import { Customer } from '../models/customer';


import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  @ViewChild("form") addform: NgForm;
 customer:Customer[]=[];
 cust:Customer;
  address : Address=new Address();
  customerId :number;
  addressId:number;
  submitted:boolean;

  constructor(private router: Router,private route: ActivatedRoute,private customerService:CustomerService) {}

  ngOnInit() {
   console.log("ng mein");
   this.customerId=this.route.snapshot.params["customerId"];
   this.customerService.searchCustomer(this.customerId).subscribe(response=>this.customer=response);
   if(this.customerId){
     console.log(this.customerId);
     this.update(this.cust);
   }
  }

  onSubmit() {
    if(this.addform.valid){
      this.addCustomer(this.addform.value)
    }
  }

  
  addCustomer(customer:Customer){
    // this.table=true;
    customer.address=this.address;
    
    console.log(customer.address);
    this.customerService.addCustomer(customer)
    .subscribe(response=>console.log("add ho gya"));
  
    // this.showitem=false;
  }

  redirectHome(){
    this.router.navigate(['/search-delete']);
  }

  update(cust:Customer){
      this.submitted=true;
    cust.address=this.address;
    console.log(cust.address);
      this.customerService.updateCustomer(this.cust).subscribe(response=>this.redirectHome);

  }


}

