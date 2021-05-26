import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { $ } from 'protractor';
import { CustomerserviceService } from '../customerservice.service';
@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public address:any={dNo:'',streetName:'',city:'',pincode:''}
  public student = false;
  public employee = false;
  public business = false;
  public selectedLevel:any;
  public id:any;
  public customerDetails:any = { customerId:'',firstName: '',lastName:'',age:'',accountNumber:'',phoneNumber:'',aadharNumber:'', emailId: '', password: '',confirmpassword: '',nomineeName:'',relation:'', address:this.address};
  constructor(public custserv: CustomerserviceService,
    public router: Router) { }
   
  ngOnInit(): void {
  }
  professions = [
    {name : "student" },
    {name : "employee"},
    {name : "business"},

  ];
  
  selected(){
    // alert(this.selectedLevel);
    if(this.selectedLevel == 'student'){
      this.student=true;
      this.employee=false;
      this.business=false;
      console.log(this.student);
    }
   else if(this.selectedLevel == 'employee'){
    this.business=false;
    this.employee=true;
    this.student=false;
    console.log(this.student);
   }
   else if(this.selectedLevel == 'business'){
     this.business=true;
     this.employee=false;
     this.student=false;
     console.log('student' +this.student );
     console.log('employee' +this.employee );
   }
   else{
     
   }
  }
  createCustomer(): void {
    this.customerDetails.customerId = 'L' + this.customerDetails.aadharNumber;
    this.custserv.loginCustomer(this.customerDetails.customerId).subscribe(data=>{
      this.id=data.customerId;
      if(this.id!="notfound")
      {
alert('customer already exists');
      }
      else{
        alert(this.customerDetails.customerId + 'This is your ID ....please remember this');
        this.custserv.createCustomer(this.customerDetails)
            .subscribe( data => {
              alert( data.firstName + ' your account created successfully.');
            
    
             
            });
      }
    })
  
      }

  


    

}