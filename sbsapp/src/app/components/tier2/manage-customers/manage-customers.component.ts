import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Customer } from 'src/app/services/customer';
import { GatewayService } from 'src/app/services/gateway.service';

@Component({
  selector: 'app-manage-customers',
  templateUrl: './manage-customers.component.html',
  styleUrls: ['./manage-customers.component.css']
})
export class ManageCustomersComponent implements OnInit {

  addCustomerForm: FormGroup;
  updateCustomerForm: FormGroup;

  @ViewChild('cancel') cancel: ElementRef;
  @ViewChild('cancel2') cancel2: ElementRef;
  @ViewChild('cancel3') cancel3: ElementRef;

  constructor(private gatewayService: GatewayService, private fb: FormBuilder) { }

  public customers : Customer[];
  public customerToModify: Customer;
  public customerToDelete: Customer;
  public newCustomer: Customer;

  ngOnInit(): void {
    this.gatewayService.request('GET', '/customer/getAll').subscribe(
      (response: any) => {
        this.customers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

    this.updateCustomerForm = this.fb.group ({
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

    this.addCustomerForm = this.fb.group ({
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
      password: ''
    },); 
  }

  async onUpdateSubmit() { 
    if (!this.updateCustomerForm.valid) {
      return;
    }

      const request = this.gatewayService.request('PUT', '/customer/updateCustomer', {
        username: this.customerToModify.username,
        firstName: this.updateCustomerForm.get('firstName')?.value || this.customerToModify.firstName,
        middleName: this.updateCustomerForm.get('middleName')?.value || this.customerToModify.middleName,
        lastName: this.updateCustomerForm.get('lastName')?.value || this.customerToModify.lastName,
        email: this.updateCustomerForm.get('email')?.value || this.customerToModify.email,
        dob: this.updateCustomerForm.get('dob')?.value || this.customerToModify.dob,
        ssn: this.updateCustomerForm.get('ssn')?.value || this.customerToModify.ssn,
        streetAddress: this.updateCustomerForm.get('streetAddress')?.value || this.customerToModify.streetAddress,
        addressLine2: this.updateCustomerForm.get('addressLine2')?.value || this.customerToModify.addressLine2,
        city: this.updateCustomerForm.get('city')?.value || this.customerToModify.city,
        state: this.updateCustomerForm.get('state')?.value || this.customerToModify.state,
        zip: this.updateCustomerForm.get('zip')?.value || this.customerToModify.zip,
        country: this.updateCustomerForm.get('country')?.value || this.customerToModify.country,
        mobileNumber: this.updateCustomerForm.get('mobileNumber')?.value || this.customerToModify.mobileNumber,
        altPhone: this.updateCustomerForm.get('altPhone')?.value || this.customerToModify.altPhone,
        securityQ1: this.updateCustomerForm.get('securityQ1')?.value || this.customerToModify.securityQ1,
        securityA1: this.updateCustomerForm.get('securityA1')?.value || this.customerToModify.securityA1,
        securityQ2: this.updateCustomerForm.get('securityQ2')?.value || this.customerToModify.securityQ2,
        securityA2: this.updateCustomerForm.get('securityA2')?.value || this.customerToModify.securityA2,
      });
    request.subscribe(() => {
      this.gatewayService.request('GET', '/customer/getAll').subscribe(
        (response: any) => {
          this.customers = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }

  async onAddSubmit() { 
    if (!this.addCustomerForm.valid) {
      return;
    }
    const newPwd = this.addCustomerForm.get('password')?.value;
    var newUName = "";
    const newRole = "customer";
    const request = this.gatewayService.request('POST', '/customer/createCustomer', {
      firstName: this.addCustomerForm.get('firstName')?.value,
      middleName: this.addCustomerForm.get('middleName')?.value,
      lastName: this.addCustomerForm.get('lastName')?.value,
      email: this.addCustomerForm.get('email')?.value,
      dob: this.addCustomerForm.get('dob')?.value,
      ssn: this.addCustomerForm.get('ssn')?.value,
      streetAddress: this.addCustomerForm.get('streetAddress')?.value,
      addressLine2: this.addCustomerForm.get('addressLine2')?.value,
      city: this.addCustomerForm.get('city')?.value,
      state: this.addCustomerForm.get('state')?.value,
      zip: this.addCustomerForm.get('zip')?.value,
      country: this.addCustomerForm.get('country')?.value,
      mobileNumber: this.addCustomerForm.get('mobileNumber')?.value,
      altPhone: this.addCustomerForm.get('altPhone')?.value,
      securityQ1: this.addCustomerForm.get('securityQ1')?.value,
      securityA1: this.addCustomerForm.get('securityA1')?.value,
      securityQ2: this.addCustomerForm.get('securityQ2')?.value,
      securityA2: this.addCustomerForm.get('securityA2')?.value,
      password: this.addCustomerForm.get('password')?.value,
    });

    request.subscribe((res: any) => {
      this.newCustomer = res;
    
      newUName = this.newCustomer.username;

      this.gatewayService.request('POST', '/credentials/addCredentials', {
        id: newUName,
        password: newPwd,
        role: newRole
      }).subscribe((res: any) => {});

      this.gatewayService.request('GET', '/customer/getAll').subscribe(
        (response: any) => {
          this.customers = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }

  public deleteCustomer(username: string): void {
    const request = this.gatewayService.request('DELETE', '/customer/delete/'+ username)
    
    request.subscribe(() => {
      this.gatewayService.request('GET', '/customer/getAll').subscribe(
        (response: any) => {
          this.customers = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
      this.cancel3.nativeElement.click();
   }

   onModifyClick(cust: Customer) {
    this.customerToModify = cust;
    this.updateCustomerForm.setValue({
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

  onDeleteClick(cust: Customer) {
   this.customerToDelete = cust;
  }

  closeModal() {
   this.cancel.nativeElement.click();
  }

  closeModal2() {
   this.cancel2.nativeElement.click();
  }

}
