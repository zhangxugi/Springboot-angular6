import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  constructor() { }
  private flag:boolean = false;
  ngOnInit() {
  }
  info(){
    //console.log(event);
    this.flag=true;
  }
}
