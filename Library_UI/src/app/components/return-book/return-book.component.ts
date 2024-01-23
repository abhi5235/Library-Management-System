import { Component } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent {
  issueData = {
    bookId: "",
    studentId: ""
  }

  bookId: any;
  studentId: any;
  bookfetched: any;

  constructor(private student: StudentService) {

  }
  returnBook() {
    console.log("button clicked");
    console.log(this.issueData);
    this.student.returnBook(this.issueData.studentId, this.issueData.bookId).subscribe(
      response => {
        this.bookfetched = response;
        console.log(this.bookfetched);
      },
      error => {
        console.log(error);
        alert(error);
      }
    )

  }
}
