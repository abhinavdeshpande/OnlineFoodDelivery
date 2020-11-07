import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from "@angular/common/http";
import { Routes, RouterModule } from "@angular/router";
import { FormsModule } from '@angular/forms';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { ProfileComponent } from './profile/profile.component';




const routes: Routes = [
  
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'home',component:HomeComponent},
  { path: 'add-customer', component: AddCustomerComponent },
  { path: 'add-customer/:customerId/:addressId', component: AddCustomerComponent },
  { path: 'profile', component: ProfileComponent },
  {path:'search-delete',component:SearchDeleteComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    AddCustomerComponent,
    SearchDeleteComponent,
    HomeComponent,
    ProfileComponent,

    
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
