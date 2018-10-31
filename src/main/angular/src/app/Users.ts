/**
 * Created by Administrator on 2018/10/30 0030.
 */
export interface Iusers {
  id?:number;
  name?: string;
  password?: string;

}
export class Users implements Iusers{
  constructor(
    public id?: number,
    public name?: string,
     public password?: string
  ){}
}
