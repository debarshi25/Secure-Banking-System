import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AboutComponent } from './components/about/about.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { OtpComponent } from './components/otp/otp.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CustomerLandingPageComponent } from './components/customer/customer-landing-page/customer-landing-page.component';
import { AccountComponent } from './components/customer/banking/account/account.component';
import { CcAccountComponent } from './components/customer/banking/cc-account/cc-account.component';
import { BankAccountSummaryComponent } from './components/customer/banking/bank-account-summary/bank-account-summary.component';
import { CreditComponent } from './components/customer/banking/credit/credit.component';
import { CcCreditComponent } from './components/customer/banking/cc-credit/cc-credit.component';
import { DebitComponent } from './components/customer/banking/debit/debit.component';
import { TransferComponent } from './components/customer/banking/transfer/transfer.component';
import { CashierCheckComponent } from './components/customer/banking/cashier-check/cashier-check.component';
import { Tier1LandingPageComponent } from './components/tier1/tier1-landing-page/tier1-landing-page.component';
import { Tier2LandingPageComponent } from './components/tier2/tier2-landing-page/tier2-landing-page.component';
import { AdminLandingPageComponent } from './components/admin/admin-landing-page/admin-landing-page.component';
import { CustomerDetailsComponent } from './components/customer/customer-details/customer-details.component';
import { CustomerProfileComponent } from './components/customer-profile/customer-profile.component';
import { EmployeeProfileComponent } from './components/employee-profile/employee-profile.component';
import { AdminFunctionsComponent } from './components/admin/admin-functions/admin-functions.component';
import { EmployeeManagementComponent } from './components/admin/employee-management/employee-management.component';
import { ViewRequestsComponent } from './components/customer/banking/view-requests/view-requests.component';
import { ScheduleAppointmentComponent } from './components/customer/banking/schedule-appointment/schedule-appointment.component';
import { NewAccountComponent } from './components/customer/banking/new-account/new-account.component';
import { BankingStatementComponent } from './components/customer/banking/banking-statement/banking-statement.component';
import { SystemLogComponent } from './components/admin/system-log/system-log.component';
import { AuthGuard } from './auth.guard';
import { Tier1FunctionsComponent } from './components/tier1/tier1-functions/tier1-functions.component';
import { Tier2FunctionsComponent } from './components/tier2/tier2-functions/tier2-functions.component';
import { ManageRequestsComponent } from './components/tier1/manage-requests/manage-requests.component';
import { CustomerFunctionsComponent } from './components/tier1/customer-functions/customer-functions.component';
import { RequestManagementComponent } from './components/tier2/request-management/request-management.component';
import { ManageCustomersComponent } from './components/tier2/manage-customers/manage-customers.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'about', component: AboutComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'otp', component: OtpComponent },
  {path: 'home', component: CustomerLandingPageComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }, children: [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: CustomerDetailsComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    {path: 'view-requests', component: ViewRequestsComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    {path: 'schedule-appointment', component: ScheduleAppointmentComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    {path: 'new-account', component: NewAccountComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    {path: 'cc-account', component: CcAccountComponent, canActivate: [AuthGuard], canActivateChild: [AuthGuard], data: { role: ['customer', 'tier1', 'tier2', 'admin'] }, children: [
      {path: '', redirectTo: "cc-account-summary", pathMatch: "full"},
      {path: 'cc-account-summary', component: BankAccountSummaryComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'banking-statement', component: BankingStatementComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'cc-credit', component: CcCreditComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'debit', component: DebitComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'transfer', component: TransferComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'cashier-check', component: CashierCheckComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    ]},
    {path: 'account', component: AccountComponent, canActivate: [AuthGuard], canActivateChild: [AuthGuard], data: { role: ['customer', 'tier1', 'tier2', 'admin'] }, children: [
      {path: '', redirectTo: "account-summary", pathMatch: "full"},
      {path: 'account-summary', component: BankAccountSummaryComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'banking-statement', component: BankingStatementComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'credit', component: CreditComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'debit', component: DebitComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'transfer', component: TransferComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
      {path: 'cashier-check', component: CashierCheckComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
    ]}
  ]},
  {path: 'tier1', component: Tier1LandingPageComponent, canActivate: [AuthGuard], canActivateChild: [AuthGuard], data: { role: ['tier1', 'tier2', 'admin'] }, children: [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: Tier1FunctionsComponent, canActivate: [AuthGuard],  data: { role: ['tier1', 'tier2', 'admin'] }},
    {path: 'manage-requests', component: ManageRequestsComponent, canActivate: [AuthGuard],  data: { role: ['tier1', 'tier2', 'admin'] }},
    {path: 'customer-functions', component: CustomerFunctionsComponent, canActivate: [AuthGuard], data: { role: ['tier1', 'tier2', 'admin'] }},
  ]},
  {path: 'tier2', component: Tier2LandingPageComponent, canActivate: [AuthGuard], canActivateChild: [AuthGuard], data: { role: ['tier2', 'admin'] }, children: [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: Tier2FunctionsComponent, canActivate: [AuthGuard],  data: { role: ['tier2', 'admin'] }},
    {path: 'manage-requests', component: RequestManagementComponent, canActivate: [AuthGuard],  data: { role: ['tier2', 'admin'] }},
    {path: 'manage-customers', component: ManageCustomersComponent, canActivate: [AuthGuard], data: { role: ['tier2', 'admin'] }},
  ]},
  {path: 'admin', component: AdminLandingPageComponent, canActivate: [AuthGuard], canActivateChild: [AuthGuard], data: { role: 'admin' }, children: [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: AdminFunctionsComponent, canActivate: [AuthGuard],  data: { role: 'admin' }},
    {path: 'manage-employees', component: EmployeeManagementComponent, canActivate: [AuthGuard],  data: { role: 'admin' }},
    {path: 'system-log', component: SystemLogComponent, canActivate: [AuthGuard], data: { role: 'admin' }},
  ]},
  {path: 'customer-profile', component: CustomerProfileComponent, canActivate: [AuthGuard],  data: { role: ['customer', 'tier1', 'tier2', 'admin'] }},
  {path: 'employee-profile', component: EmployeeProfileComponent, canActivate: [AuthGuard],  data: { role: ['tier1', 'tier2', 'admin'] }},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent, AboutComponent, AccountComponent, RegistrationComponent, OtpComponent, PageNotFoundComponent, 
  CustomerLandingPageComponent, CustomerDetailsComponent, Tier1LandingPageComponent, Tier1FunctionsComponent, Tier2LandingPageComponent, Tier2FunctionsComponent, AdminLandingPageComponent, CreditComponent,
  DebitComponent, TransferComponent, CashierCheckComponent, CcAccountComponent, CcCreditComponent, CustomerProfileComponent, EmployeeProfileComponent,
  EmployeeManagementComponent, AdminFunctionsComponent, BankAccountSummaryComponent, BankingStatementComponent, ScheduleAppointmentComponent,
  NewAccountComponent, ViewRequestsComponent, SystemLogComponent, ManageRequestsComponent, CustomerFunctionsComponent, RequestManagementComponent,
  ManageCustomersComponent,]
