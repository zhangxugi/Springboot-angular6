/**
 * Created by Administrator on 2018/10/29 0029.
 */
/*
export interface Employee {
  employeeId:number;
  firstName: string;
  lastName: string;
  gender: string;
  dob: string;
  department: string;
}
*/
export interface IEmployee {
  employeeId?:number;
  firstName?: string;
  lastName?: string;
  gender?: string;
  dob?: string;
  department?: string;
}
export class Employee implements IEmployee{
  constructor(
    public employeeId?: number,
    public firstName?: string,
    public lastName?: string,
    public gender?: string,
    public dob?: string,
    public  department?: string,
  ){}
}
