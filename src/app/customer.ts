import { Address } from "./address";


export interface Customer {
  customerId:string,
  firstName: string,
  lastName: string,
  age: number,
  address: Address,
  accountNumber: number,
  phoneNumber: number,
  aadharNumber: number,
  emailId: string,
  password: string,
  confirmpassword: string,
  nomineeName: string,
  relation: string
}