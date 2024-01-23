import { Component } from '@angular/core';
import { BookService } from 'src/app/bookServices/book.service';

@Component({
  selector: 'app-post-data',
  templateUrl: './post-data.component.html',
  styleUrls: ['./post-data.component.css']
})
export class PostDataComponent {

  data={
    bookId:"",
    bookName:"",
    authorName:"",
    issuedTo:"",
    issuedDate:"",
    availability:""
  }
  constructor(private book:BookService){}
  dosubmitForm() {
    console.log("button clicked");
    console.log(this.data);
    this.book.sendData(this.data).subscribe(
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
