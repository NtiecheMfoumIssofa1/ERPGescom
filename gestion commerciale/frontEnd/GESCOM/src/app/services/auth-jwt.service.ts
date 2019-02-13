import { HttpClient } from "@angular/common/http";
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';
import { Observable } from "rxjs";
import { SERVER_API_URL } from "../Config/config";
import { map } from "rxjs/operators";
import { Injectable } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class AuthServerProvider{
    constructor(
        private http:HttpClient,
        private $localStorage:LocalStorageService,
        private $sessionStorage:SessionStorageService){}

        getToken(){
            return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken');
        }

        login(credentials):Observable<any>{
            const data = {
                email:credentials.email,
                password:credentials.password,
                rememberMe:credentials.rememberMe
            };
            return this.http.post(SERVER_API_URL+'api/authenticate',data,{observe:'response'})
            .pipe(map(authenticateSuccess.bind(this)));
            
            function authenticateSuccess(resp){
                const bearerToken = resp.headers.get('Authorization');
                 if(bearerToken && bearerToken.slice(0, 7) === 'Bearer '){
                     const jwt = bearerToken.slice(7, bearerToken.length);
                     this.storeAuthenticationToken(jwt,credentials.rememberMe);
                        return jwt;
                    }
            }
        }

        loginWithToken(jwt, rememberMe){
            if(jwt){
                this.storeAuthenticationToken(jwt,rememberMe);
                return Promise.resolve(jwt);
            }else{
                return Promise.reject('Erreur de connexion !!!');
            }
        }

        storeAuthenticationToken(jwt, rememberMe){
            if(rememberMe){
                this.$localStorage.store('authenticationToken',jwt);
            }else{
                this.$sessionStorage.store('authenticationToken',jwt);
            }
        }

        logout():Observable<any>{
            return new Observable(observer =>{
                this.$localStorage.clear('authenticationToken');
                this.$sessionStorage.clear('authenticationToken');
                observer.complete();
            });
        }

}