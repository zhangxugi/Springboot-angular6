import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Iusers, Users} from "../Users";
import {AuthService} from "./auth.service";
import {Http} from "@angular/http";

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css']
})
export class LoginsComponent implements OnInit {
 users:Users;
  constructor(private _router:Router, private authService: AuthService,private  _http: Http) { }

  ngOnInit() {
    this.users =new Users();
  }
  onSubmit() {
    console.log(this.users);
    let data= {name: this.users.name,password:this.users.password};
    this.authService.login(data).subscribe((data)=>{
      console.log(data);
      this._router.navigate(['/s']);
    },(error)=>{
      console.log(error);
    })
  }

}
