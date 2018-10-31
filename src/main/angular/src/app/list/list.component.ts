import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {EmployeeService} from "../EmployeeService/employee-service";
import {Employee} from "../employee";


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  private employees:Employee[];
  constructor(private _employeeService:EmployeeService, private _router:Router) { }

  ngOnInit() {
    this._employeeService.getUsers().subscribe((employees)=>{
      console.log(employees);
      this.employees=employees;
    },(error)=>{
      console.log(error);
    })
  }

  deleteUser(emp){
    this._employeeService.deleteUser(emp.employeeId).subscribe((data)=>{
      this.employees.splice(this.employees.indexOf(emp),1);

    },(error)=>{
      console.log(error);
    });
  }
  updateUser(emp){
    this._employeeService.setter(emp);
    this._router.navigate(['/op']);
  }

  newUser(){
    let employ: any;
    this._employeeService.setter(employ);
    this._router.navigate(['/op']);
  }

}


