import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../EmployeeService/employee-service';
import {Router} from '@angular/router';
import {Employee, IEmployee} from "../employee";
@Component({
    selector: 'app-save-employee',
    templateUrl: './save-employee.component.html',
    styleUrls: ['./save-employee.component.css']
})
export class SaveEmployeeComponent implements OnInit {
   employee:IEmployee;
  constructor(private _employeeService: EmployeeService, private _router: Router) {
  }

  ngOnInit() {
   this.employee = this._employeeService.getter();
     if(!this.employee) {
       this.employee = new Employee();
       /*{
        employeeId:0,
        firstName: "",
        lastName: "",
        gender: "",
        dob: "",
        department: ""
        };
        }*/
       /* this.employee = new Employee();*/
     }
  }

  processForm() {
    if(!this.employee.employeeId){
     this._employeeService.createUser(this.employee).subscribe((employee)=>{
     console.log(employee);
     this._router.navigate(['/list']);
     },(error)=>{
     console.log(error);
     });
     }
     else{
     {
     this._employeeService.updateUser(this.employee).subscribe((employee)=>{
     console.log(employee);
     this._router.navigate(['/list']);
     },(error)=>{
     console.log(error);
     });
     }
     }
     }
}
