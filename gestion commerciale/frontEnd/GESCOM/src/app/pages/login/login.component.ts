import { Component, OnInit, AfterViewInit, ElementRef, Renderer } from '@angular/core';
import { Router } from '@angular/router';
// import { AuthService } from '../../core/auth.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { JhiEventManager } from 'ng-jhipster';
import { LoginService } from '../../services/login.service';
import { StateStorageService } from '../../services/state-storage.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit { //OnInit
  disabled : boolean = false;
  userForm: FormGroup;
  authenticationError: boolean;
  password: string;
  rememberMe: boolean;
  email: string;
  credentials: any;
  formErrors = {
    'email': '',
    'password': ''
  };
  validationMessages = {
    'email': {
      'required': 'Please enter your email',
      'email': 'please enter your vaild email'
    },
    'password': {
      'required': 'please enter your password',
      'pattern': 'The password must contain numbers and letters',
      'minlength': 'Please enter more than 4 characters',
      'maxlength': 'Please enter less than 25 characters',
    }
  };

  constructor(private router: Router,
              private fb: FormBuilder,
              private eventManager:JhiEventManager,
              private loginService: LoginService,
              private stateStorageService:StateStorageService,
              private elementRef : ElementRef,
              private renderer:Renderer,
              ) {
  }


  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.userForm = this.fb.group({
      'email': ['', [
        Validators.required,
        Validators.email
      ]
      ],
      'password': ['', [
        //Validators.pattern('^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$'),
        Validators.minLength(6),
        Validators.maxLength(25)
      ]
      ],
    });

    this.userForm.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    // if (!this.userForm) {
    //   return;
    // }
    // const form = this.userForm;
    // for (const field in this.formErrors) {
    //   if (Object.prototype.hasOwnProperty.call(this.formErrors, field)) {
    //     this.formErrors[field] = '';
    //     const control = form.get(field);
    //     if (control && control.dirty && !control.valid) {
    //       const messages = this.validationMessages[field];
    //       for (const key in control.errors) {
    //         if (Object.prototype.hasOwnProperty.call(control.errors, key)) {
    //           this.formErrors[field] += messages[key] + ' ';
    //         }
    //       }
    //     }
    //   }
    // }
  }
  /*login() {
    console.log("login!!!!!!!!!!!!!!!!!!!")
    this.router.navigateByUrl("/auth/dashboard");
  }*/
  cancel(){
    this.credentials = {
      email:null,
      password:null,
      rememberMe:true
    };
    this.authenticationError = false;
    //this.activeModal.dismiss('cancel'); popup avec materiel
  }

  login(){
    this.loginService
        .login({
          email: this.email,
          password:this.password,
          rememberMe : this.rememberMe
        })
        .then(() =>{
          this.authenticationError = false;
          // this.activeModal.dismiss('login success'); à remplacer par active modal materiel
          if(this.router.url === '/register' || /^\/activate\//.test(this.router.url) || /^\/reset\//.test(this.router.url)) {
            this.router.navigate(['/auth/dashboard']);
          }

          this.eventManager.broadcast({
            name: 'authenticationSuccess',
            content: 'Sending Authentication Success'
          });
          // previousState was set in the authExpiredInterceptor before being redirected to login modal.
                // since login is succesful, go to stored previousState and clear previousState
                const redirect = this.stateStorageService.getUrl();
                if (redirect) {
                    this.stateStorageService.storeUrl(null);
                    this.router.navigate([redirect]);
                }
        })
        .catch(() =>{
          this.authenticationError = true;
        });
  }

  register(){
    // this.activeModal.dismiss('to state register');
        this.router.navigate(['/register']);
  }

  requestResetPassword() {
    //this.activeModal.dismiss('to state requestReset');
    this.router.navigate(['/reset', 'request']);
}


}

