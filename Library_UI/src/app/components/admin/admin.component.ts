import { Component } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  data = {
    studentId: "",
    name: "",
    emailId: "",
    phoneNumber: ""
  }
  constructor(private student: StudentService) {

  }
  dosubmitForm() {
    console.log("button clicked");
    console.log(this.data);
    this.student.sendData(this.data).subscribe(
      response=>{
        console.log(response);
        alert("Data Submitted");
      },
     error=>{
      console.log(error.error.message);
      alert(error.error.message)
     }      
    )
  }
}
