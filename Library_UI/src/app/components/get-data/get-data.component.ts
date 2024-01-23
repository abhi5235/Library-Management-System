import { Component } from '@angular/core';
import { BookService } from 'src/app/bookServices/book.service';

@Component({
  selector: 'app-get-data',
  templateUrl: './get-data.component.html',
  styleUrls: ['./get-data.component.css']
})
export class GetDataComponent {

  bookfetched:any;

  bookId:any

  constructor(private book:BookService){

  }
  getBookData(){
    console.log("button clicked");
    console.log(this.bookId);
    this.book.getData(this.bookId).subscribe(
      response=>{
        this.bookfetched=response;
        console.log(this.bookfetched)
      },
      error=>{
        console.log(error);
        alert("Data not available");
      }
    )
  }

}
