import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { TransactionsComponent } from './components/customer/banking/transactions/transactions.component';
import { CcTransactionsComponent } from './components/customer/banking/cc-transactions/cc-transactions.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from './services/authentication.service';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TransactionsComponent,
    CcTransactionsComponent,
    routingComponents,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }