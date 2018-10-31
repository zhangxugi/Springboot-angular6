import { Injectable } from '@angular/core';
import {Http,Headers,RequestOptions} from '@angular/http';


@Injectable()
export class AuthService {
  private baseUrl: String = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  constructor(private _http: Http ) {}
  //登录与后台连接，data是参数
  login(data:any){
    console.log(data)
    return this._http.post(this.baseUrl+'/login',data,this.options);
  }

}


