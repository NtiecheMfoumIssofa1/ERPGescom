import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LazyLoadModule } from './lazy-load/lazy-load.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from './core/core.module';
import { HttpClientModule } from '@angular/common/http'; 
import { Ng2Webstorage } from 'ngx-webstorage';
import { NgJhipsterModule } from 'ng-jhipster';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    LazyLoadModule,
    CoreModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    Ng2Webstorage.forRoot(),
    NgJhipsterModule.forRoot({
        // set below to true to make alerts look like toast
        alertAsToast: false,
        alertTimeout: 5000,
        i18nEnabled: true,
        defaultI18nLang: 'en'
    }),
  ],
  providers: [
    
],

  bootstrap: [AppComponent]
})
export class AppModule { }
