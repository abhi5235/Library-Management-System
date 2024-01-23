import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ReturnBookComponent } from '../components/return-book/return-book.component';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseurl: string = "http://localhost:8091";
  constructor(private http: HttpClient) { }

  sendData(data: any) {
    return this.http.post(`${this.baseurl}/student`, data)
  }
  getData(id: any) {
    return this.http.get(`${this.baseurl}/student/${id}`)
  }
  issueBook(studentId:any,bookId:any){
    return this.http.get(`${this.baseurl}/student/issueBook?studentId=${studentId}&bookId=${bookId}`)
  }
  returnBook(studentId:any,bookId:any){
    return this.http.get(`${this.baseurl}/student/returnBook?studentId=${studentId}&bookId=${bookId}`)
  }
}
