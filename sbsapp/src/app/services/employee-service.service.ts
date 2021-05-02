import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { map } from 'rxjs/operators'
import { Employee } from './employee';
import { GatewayService } from './gateway.service';
@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  constructor(private gatewayService: GatewayService) {} 

  public getEmployees(): Observable<Object> {
    return this.gatewayService.request('GET', '/employee/getAll');
    //.pipe(map((response: any) => response.data as Employee[]))
  }

  // public getEmployeeById(employeeId: number): Observable<Employee> {
  //   return this.gatewayService.request('GET','/employee/getEmployee/${employeeId}');
  // }
  
  public addEmployee(employee: Employee): Observable<Employee> {
    return this.gatewayService.request('POST', '/employee/addEmployee', employee).pipe(map((response: any) => response.data as Employee));
    //return this.gatewayService.request('POST', '/employee/addEmployee', employee).pipe(map((response: any) => response.data as Employee));
  }

   public updateEmployee(employee: Employee): Observable<Employee> {
     return this.gatewayService.request('PUT', '/employee/updateEmployee', employee).pipe(map((response: any) => response.data as Employee));
   }
  
  // public deleteEmployee(employeeId: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
  // }

}
