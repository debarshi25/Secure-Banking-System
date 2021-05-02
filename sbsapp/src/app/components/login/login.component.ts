import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  public invalidCreds!: boolean;
  private loginAttempt!: boolean;

  constructor(public authService: AuthenticationService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      id: ['', Validators.required],
      pwd: ['', Validators.required]
    })
  }

  async onSubmit() {
    this.invalidCreds = false;
    this.loginAttempt = false;
    if (this.loginForm.valid) {
      try {
        await this.authService.login(this.loginForm.value);
      } catch (error: any) {
        this.invalidCreds = true;
      }
    } else {
      this.loginAttempt = true;
    }
  }

  isCredInvalid() {
    return this.authService.isInvalidCreds;
  }

}
