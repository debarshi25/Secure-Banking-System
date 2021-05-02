import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Employee } from 'src/app/services/employee';
import { GatewayService } from 'src/app/services/gateway.service';

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  @ViewChild('cancel') cancel: ElementRef;
  employee: Employee;
  username: string;

  modifyEmployeeForm: FormGroup;

  constructor(public authenticationService: AuthenticationService, private gatewayService: GatewayService, private fb: FormBuilder) { }

  public employeeToModify: Employee;

  ngOnInit(): void {

    this.employee = {
      employeeId: 0,
      tier: "",
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
    }

    this.username = this.authenticationService.getUsername();

    this.gatewayService.request('GET', '/employee/getEmployee/' + this.username).subscribe(
      (response: any) => {
        this.employee = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

    this.modifyEmployeeForm = this.fb.group ({
      employeeId: '',
      tier: '',
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

  getEmployee() {
    return this.employee;
  }

  async onUpdateSubmit() { 
    if (!this.modifyEmployeeForm.valid) {
      return;
    }
      const request = this.gatewayService.request('PUT', '/employee/updateEmployee', {
        employeeId: this.employeeToModify.employeeId,
        tier: this.modifyEmployeeForm.get('tier')?.value || this.employeeToModify.tier,
        firstName: this.modifyEmployeeForm.get('firstName')?.value || this.employeeToModify.firstName,
        middleName: this.modifyEmployeeForm.get('middleName')?.value || this.employeeToModify.middleName,
        lastName: this.modifyEmployeeForm.get('lastName')?.value || this.employeeToModify.lastName,
        email: this.modifyEmployeeForm.get('email')?.value || this.employeeToModify.email,
        dob: this.modifyEmployeeForm.get('dob')?.value || this.employeeToModify.dob,
        ssn: this.modifyEmployeeForm.get('ssn')?.value || this.employeeToModify.ssn,
        streetAddress: this.modifyEmployeeForm.get('streetAddress')?.value || this.employeeToModify.streetAddress,
        addressLine2: this.modifyEmployeeForm.get('addressLine2')?.value || this.employeeToModify.addressLine2,
        city: this.modifyEmployeeForm.get('city')?.value || this.employeeToModify.city,
        state: this.modifyEmployeeForm.get('state')?.value || this.employeeToModify.state,
        zip: this.modifyEmployeeForm.get('zip')?.value || this.employeeToModify.zip,
        country: this.modifyEmployeeForm.get('country')?.value || this.employeeToModify.country,
        mobileNumber: this.modifyEmployeeForm.get('mobileNumber')?.value || this.employeeToModify.mobileNumber,
        altPhone: this.modifyEmployeeForm.get('altPhone')?.value || this.employeeToModify.altPhone,
        securityQ1: this.modifyEmployeeForm.get('securityQ1')?.value || this.employeeToModify.securityQ1,
        securityA1: this.modifyEmployeeForm.get('securityA1')?.value || this.employeeToModify.securityA1,
        securityQ2: this.modifyEmployeeForm.get('securityQ2')?.value || this.employeeToModify.securityQ2,
        securityA2: this.modifyEmployeeForm.get('securityA2')?.value || this.employeeToModify.securityA2,
      });
    request.subscribe(() => {
      this.gatewayService.request('GET', '/employee/getEmployee/' + this.username).subscribe(
        (response: any) => {
          this.employee = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }

  onModifyClick(emp: Employee) {
    this.employeeToModify = emp;
    this.modifyEmployeeForm.setValue({
     employeeId: this.employeeToModify.employeeId,
     tier: this.employeeToModify.tier,
     firstName: this.employeeToModify.firstName,
     middleName: this.employeeToModify.middleName,
     lastName: this.employeeToModify.lastName,
     email: this.employeeToModify.email,
     dob: this.employeeToModify.dob,
     ssn: this.employeeToModify.ssn,
     streetAddress: this.employeeToModify.streetAddress,
     addressLine2: this.employeeToModify.addressLine2,
     city: this.employeeToModify.city,
     state: this.employeeToModify.state,
     zip: this.employeeToModify.zip,
     country: this.employeeToModify.country,
     mobileNumber: this.employeeToModify.mobileNumber,
     altPhone: this.employeeToModify.altPhone,
     securityQ1: this.employeeToModify.securityQ1,
     securityA1: this.employeeToModify.securityA1,
     securityQ2: this.employeeToModify.securityQ2,
     securityA2: this.employeeToModify.securityA2,
    });
  }

  closeModal() {
    this.cancel.nativeElement.click();
   }

}
