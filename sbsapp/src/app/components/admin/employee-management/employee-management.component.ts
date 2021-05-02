import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { GatewayService } from 'src/app/services/gateway.service';
import { Employee } from '../../../services/employee'

@Component({
  selector: 'app-employee-management',
  templateUrl: './employee-management.component.html',
  styleUrls: ['./employee-management.component.css']
})
export class EmployeeManagementComponent implements OnInit {

  @ViewChild('cancel') cancel: ElementRef;
  @ViewChild('cancel2') cancel2: ElementRef;
  @ViewChild('cancel3') cancel3: ElementRef;

  addEmployeeForm: FormGroup;
  updateEmployeeForm: FormGroup;

  constructor(private gatewayService: GatewayService, private fb: FormBuilder) { }
  
  public employees : Employee[];
  public employeeToModify: Employee;
  public employeeToDelete: Employee;
  public newEmployee: Employee;
  
  ngOnInit(): void {
    this.gatewayService.request('GET', '/employee/getAll').subscribe(
      (response: any) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

    this.updateEmployeeForm = this.fb.group ({
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

    this.addEmployeeForm = this.fb.group ({
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
      password: ''
    },); 
  }

  async onUpdateSubmit() { 
    if (!this.updateEmployeeForm.valid) {
      return;
    }

      const request = this.gatewayService.request('PUT', '/employee/updateEmployee', {
        employeeId: this.employeeToModify.employeeId,
        tier: this.updateEmployeeForm.get('tier')?.value || this.employeeToModify.tier,
        firstName: this.updateEmployeeForm.get('firstName')?.value || this.employeeToModify.firstName,
        middleName: this.updateEmployeeForm.get('middleName')?.value || this.employeeToModify.middleName,
        lastName: this.updateEmployeeForm.get('lastName')?.value || this.employeeToModify.lastName,
        email: this.updateEmployeeForm.get('email')?.value || this.employeeToModify.email,
        dob: this.updateEmployeeForm.get('dob')?.value || this.employeeToModify.dob,
        ssn: this.updateEmployeeForm.get('ssn')?.value || this.employeeToModify.ssn,
        streetAddress: this.updateEmployeeForm.get('streetAddress')?.value || this.employeeToModify.streetAddress,
        addressLine2: this.updateEmployeeForm.get('addressLine2')?.value || this.employeeToModify.addressLine2,
        city: this.updateEmployeeForm.get('city')?.value || this.employeeToModify.city,
        state: this.updateEmployeeForm.get('state')?.value || this.employeeToModify.state,
        zip: this.updateEmployeeForm.get('zip')?.value || this.employeeToModify.zip,
        country: this.updateEmployeeForm.get('country')?.value || this.employeeToModify.country,
        mobileNumber: this.updateEmployeeForm.get('mobileNumber')?.value || this.employeeToModify.mobileNumber,
        altPhone: this.updateEmployeeForm.get('altPhone')?.value || this.employeeToModify.altPhone,
        securityQ1: this.updateEmployeeForm.get('securityQ1')?.value || this.employeeToModify.securityQ1,
        securityA1: this.updateEmployeeForm.get('securityA1')?.value || this.employeeToModify.securityA1,
        securityQ2: this.updateEmployeeForm.get('securityQ2')?.value || this.employeeToModify.securityQ2,
        securityA2: this.updateEmployeeForm.get('securityA2')?.value || this.employeeToModify.securityA2,
      });
    request.subscribe(() => {
      this.gatewayService.request('GET', '/employee/getAll').subscribe(
        (response: any) => {
          this.employees = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }


  async onAddSubmit() { 
    if (!this.addEmployeeForm.valid) {
      return;
    }
    const newPwd = this.addEmployeeForm.get('password')?.value;
    const newTier = this.addEmployeeForm.get('tier')?.value;
    var newEmpId = 0;
    const request = this.gatewayService.request('POST', '/employee/addEmployee', {
      tier: this.addEmployeeForm.get('tier')?.value,
      firstName: this.addEmployeeForm.get('firstName')?.value,
      middleName: this.addEmployeeForm.get('middleName')?.value,
      lastName: this.addEmployeeForm.get('lastName')?.value,
      email: this.addEmployeeForm.get('email')?.value,
      dob: this.addEmployeeForm.get('dob')?.value,
      ssn: this.addEmployeeForm.get('ssn')?.value,
      streetAddress: this.addEmployeeForm.get('streetAddress')?.value,
      addressLine2: this.addEmployeeForm.get('addressLine2')?.value,
      city: this.addEmployeeForm.get('city')?.value,
      state: this.addEmployeeForm.get('state')?.value,
      zip: this.addEmployeeForm.get('zip')?.value,
      country: this.addEmployeeForm.get('country')?.value,
      mobileNumber: this.addEmployeeForm.get('mobileNumber')?.value,
      altPhone: this.addEmployeeForm.get('altPhone')?.value,
      securityQ1: this.addEmployeeForm.get('securityQ1')?.value,
      securityA1: this.addEmployeeForm.get('securityA1')?.value,
      securityQ2: this.addEmployeeForm.get('securityQ2')?.value,
      securityA2: this.addEmployeeForm.get('securityA2')?.value,
      password: this.addEmployeeForm.get('password')?.value,
    });

    request.subscribe((res: any) => {
      this.newEmployee = res;
    
      newEmpId = this.newEmployee.employeeId;

      this.gatewayService.request('POST', '/credentials/addCredentials', {
        id: newEmpId,
        password: newPwd,
        role: newTier
      }).subscribe((res: any) => {});

      this.gatewayService.request('GET', '/employee/getAll').subscribe(
        (response: any) => {
          this.employees = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
  }

   public deleteEmployee(employeeId: number): void {
    const request = this.gatewayService.request('DELETE', '/employee/delete/'+ employeeId)
    
    request.subscribe(() => {
      this.gatewayService.request('GET', '/employee/getAll').subscribe(
        (response: any) => {
          this.employees = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    })
      this.cancel3.nativeElement.click();
   }

   onModifyClick(emp: Employee) {
     this.employeeToModify = emp;
     this.updateEmployeeForm.setValue({
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

   onDeleteClick(emp: Employee) {
    this.employeeToDelete = emp;
   }

   closeModal() {
    this.cancel.nativeElement.click();
   }

   closeModal2() {
    this.cancel2.nativeElement.click();
   }

}
