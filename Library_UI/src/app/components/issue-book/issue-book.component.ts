import { Component } from '@angular/core';
import { BookService } from 'src/app/bookServices/book.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-issue-book',
  templateUrl: './issue-book.component.html',
  styleUrls: ['./issue-book.component.css']
})
export class IssueBookComponent {
  issueData = {
    bookId: "",
    studentId: ""
  }

  bookId: any
  studentId: any
  bookfetched: any

  constructor(private student: StudentService) {

  }
  issueBookFormDB() {
    console.log("button clicked");
    console.log(this.issueData);
    this.student.issueBook(this.issueData.studentId, this.issueData.bookId).subscribe(
      response => {
        this.bookfetched = response;
        console.log(this.bookfetched);
      },
      error => {
        console.log(error.error.message);
        alert(error.error.message);
      }
    )

  }
}
