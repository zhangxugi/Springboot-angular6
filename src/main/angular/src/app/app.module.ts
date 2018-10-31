import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {ListComponent} from "./list/list.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {EmployeeService} from "./EmployeeService/employee-service";
import {SaveEmployeeComponent} from "./save-employee/save-employee.component";
import { LoginsComponent } from './logins/logins.component';
import {AuthService} from "./logins/auth.service";
import { HeroesComponent } from './heroes/heroes.component';
//配置路由
const appRoutes:Routes=[
 {path:'',component:LoginsComponent},
 {path:'s',component:HeroesComponent },
  {path:'list',component:ListComponent},
  {path:'op',component:SaveEmployeeComponent},
  //默认跳转路由
  /*{path:'',redirectTo:'',pathMatch:"full" },*/
  //任意路由(匹配不到默认就是login)
/*  {path:'**',component: LoginsComponent }*/
];


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    SaveEmployeeComponent,
    LoginsComponent,
    HeroesComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService,AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
