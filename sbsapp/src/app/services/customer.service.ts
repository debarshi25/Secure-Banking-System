import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class CustomerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {} 

  public getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.apiServerUrl}/customer/getAll`);
  }

  public getCustomerByUsername(username: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.apiServerUrl}/customer/getCustomer/${username}`);
  }
  
  public addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.apiServerUrl}/customer/addCustomer`, customer);
  }

  public updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.apiServerUrl}/customer/updateCustomer`, customer);
  }
  
  public deleteCustomer(username: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/customer/delete/${username}`);
  }
}