import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {catchError,map} from "rxjs/operators";
import {Observable} from  'rxjs';
import {Employee} from "../employee";
import {HttpClient} from "selenium-webdriver/http";
import {HttpHeaders} from "@angular/common/http";
@Injectable()
export class EmployeeService {
  private baseUrl:String='http://localhost:8080/api';
  private headers= new Headers({'Content-Type':'application/json'});
  private options= new RequestOptions({headers:this.headers});
  private employee :Employee;
  constructor(private _http:Http) { }
/*  constructor(private http: HttpClient) {
  }*/

  getUsers(){
    return this._http.get(this.baseUrl+'/empselect',this.options).
    pipe(map((response:Response)=>response.json()),catchError(this.errorHandler));

  }

  getUser(id:Number){
    return this._http.get(this.baseUrl+'/empselect/'+id,this.options).
    pipe(map((response:Response)=>response.json()),catchError(this.errorHandler));

  }

  deleteUser(id:Number){
    return this._http.delete(this.baseUrl+'/delete/'+id,this.options).
    pipe(map((response:Response)=>response.json()),catchError(this.errorHandler));

  }
  createUser(employee:Employee){
    return this._http.post(this.baseUrl+'/add',JSON.stringify(employee),  this.options).
    pipe(map((response:Response)=>response.json()),catchError(this.errorHandler));
  }
  updateUser(employee :Employee){
    return this._http.put(this.baseUrl+'/update',JSON.stringify(employee),this.options).
    pipe(map((response:Response)=>response.json()),catchError(this.errorHandler));

  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");

  }

  setter(employee:Employee){
    this.employee=employee;
  }
  getter(){
    return this.employee;
  }
}
