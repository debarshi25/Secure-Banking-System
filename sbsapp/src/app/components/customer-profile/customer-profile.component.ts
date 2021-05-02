import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Customer } from 'src/app/services/customer';
import { GatewayService } from 'src/app/services/gateway.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  @ViewChild('cancel') cancel: ElementRef;
  customer: Customer;
  username: string;

  modifyCustomerForm: FormGroup;

  constructor(public authenticationService: AuthenticationService, private gatewayService: GatewayService, private fb: FormBuilder) { }

  public customerToModify: Customer;

  ngOnInit(): void {

    this.customer = {
      username: "",
      firstName: "",
      middleName: "",
      lastName: "",
      email: "",
      dob: "",
      ssn: "",
      streetAddress: "",
      addressLine2: "",
      city: "",
      state: "",
      zip: "",
      country: "",
      mobileNumber: "",
      altPhone: "",
      securityQ1: "",
      securityA1: "",
      securityQ2: "",
      securityA2: "",
      password: "",
      accountType: "",
    }

    this.username = this.authenticationService.getUsername();

    this.gatewayService.request('GET', '/customer/getCustomer/' + this.username).subscribe(
      (response: any) => {
        this.customer = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

    this.modifyCustomerForm = this.fb.group ({
      username: '',
      firstName: '',
      middleName: '',
      lastName: '',
      email: '',
      dob: '',
      ssn: '',
      streetAddress: '',
      addressLine2: '',
      city: '',
      state: '',
      zip: '',
      country: '',
      mobileNumber: '',
      altPhone: '',
      securityQ1: '',
      securityA1: '',
      securityQ2: '',
      securityA2: '',
    },); 

  }

  getCustomer() {
    return this.customer;
  }

  async onUpdateSubmit() { 
    if (!this.modifyCustomerForm.valid) {
      return;
    }
      const request = this.gatewayService.request('PUT', '/customer/updateCustomer', {
        username: this.customerToModify.username,
        firstName: this.modifyCustomerForm.get('firstName')?.value || this.customerToModify.firstName,
        middleName: this.modifyCustomerForm.get('middleName')?.value || this.customerToModify.middleName,
        lastName: this.modifyCustomerForm.get('lastName')?.value || this.customerToModify.lastName,
        email: this.modifyCustomerForm.get('email')?.value || this.customerToModify.email,
        dob: this.modifyCustomerForm.get('dob')?.value || this.customerToModify.dob,
        ssn: this.modifyCustomerForm.get('ssn')?.value || this.customerToModify.ssn,
        streetAddress: this.modifyCustomerForm.get('streetAddress')?.value || this.customerToModify.streetAddress,
        addressLine2: this.modifyCustomerForm.get('addressLine2')?.value || this.customerToModify.addressLine2,
        city: this.modifyCustomerForm.get('city')?.value || this.customerToModify.city,
        state: this.modifyCustomerForm.get('state')?.value || this.customerToModify.state,
        zip: this.modifyCustomerForm.get('zip')?.value || this.customerToModify.zip,
        country: this.modifyCustomerForm.get('country')?.value || this.customerToModify.country,
        mobileNumber: this.modifyCustomerForm.get('mobileNumber')?.value || this.customerToModify.mobileNumber,
        altPhone: this.modifyCustomerForm.get('altPhone')?.value || this.customerToModify.altPhone,
        securityQ1: this.modifyCustomerForm.get('securityQ1')?.value || this.customerToModify.securityQ1,
        securityA1: this.modifyCustomerForm.get('securityA1')?.value || this.customerToModify.securityA1,
        securityQ2: this.modifyCustomerForm.get('securityQ2')?.value || this.customerToModify.securityQ2,
        securityA2: this.modifyCustomerForm.get('securityA2')?.value || this.customerToModify.securityA2,
      });
    request.subscribe(() => {
      this.gatewayService.request('GET', '/customer/getCustomer/' + this.username).subscribe(
        (response: any) => {
          this.customer = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }

  onModifyClick(cust: Customer) {
    this.customerToModify = cust;
    this.modifyCustomerForm.setValue({
     username: this.customerToModify.username,
     firstName: this.customerToModify.firstName,
     middleName: this.customerToModify.middleName,
     lastName: this.customerToModify.lastName,
     email: this.customerToModify.email,
     dob: this.customerToModify.dob,
     ssn: this.customerToModify.ssn,
     streetAddress: this.customerToModify.streetAddress,
     addressLine2: this.customerToModify.addressLine2,
     city: this.customerToModify.city,
     state: this.customerToModify.state,
     zip: this.customerToModify.zip,
     country: this.customerToModify.country,
     mobileNumber: this.customerToModify.mobileNumber,
     altPhone: this.customerToModify.altPhone,
     securityQ1: this.customerToModify.securityQ1,
     securityA1: this.customerToModify.securityA1,
     securityQ2: this.customerToModify.securityQ2,
     securityA2: this.customerToModify.securityA2,
    });
  }

  closeModal() {
    this.cancel.nativeElement.click();
   }


}
