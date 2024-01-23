import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseurl: string = "http://localhost:8092";
  constructor(private http: HttpClient) { }

  sendData(data: any) {
    return this.http.post(`${this.baseurl}/book`, data)
  }
  getData(id: any) {
    return this.http.get(`${this.baseurl}/book/${id}`)
  }
}
