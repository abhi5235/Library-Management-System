import { Component } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-data',
  templateUrl: './student-data.component.html',
  styleUrls: ['./student-data.component.css']
})
export class StudentDataComponent {

  studentfetched: any;

  studentId: any

  constructor(private student: StudentService) {

  }
  getStudentData() {
    console.log("button clicked");
    console.log(this.studentId);
    this.student.getData(this.studentId).subscribe(
      response => {
        this.studentfetched = response;
        console.log(this.studentfetched);
      },
      error => {
        console.log(error);
        alert("Data not available");
      }

    )
  }
}
