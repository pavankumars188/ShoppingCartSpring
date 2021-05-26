import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  public customerId:string='';

  public password:string='';
  public id:any;
  public pass:any;
  constructor(public restApi: CustomerserviceService,
    public router: Router) { }

  ngOnInit(): void {
  }
 login()
 {
   this.restApi.loginCustomer(this.customerId).subscribe(
     data=>{this.id=data.customerId;
     this.pass=data.password;
     if(this.id==this.customerId&&this.pass===this.password)
     {
     alert('welcome');
     }
    else{
      alert('wrong credentials');
    }}
     

   );
 }

}
