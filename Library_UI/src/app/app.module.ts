import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './components/admin/admin.component';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { KnitComponent } from './components/knit/knit.component';
import { ButtonComponent } from './components/button/button.component';
import { StudentDataComponent } from './components/student-data/student-data.component';
import { StudentService } from './services/student.service';
import { HttpClientModule } from '@angular/common/http';
import { LibraryButtonComponent } from './components/library-button/library-button.component';
import { PostDataComponent } from './components/post-data/post-data.component';
import { GetDataComponent } from './components/get-data/get-data.component';
import { IssueBookComponent } from './components/issue-book/issue-book.component';
import { ReturnBookComponent } from './components/return-book/return-book.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AdminComponent,
    KnitComponent,
    ButtonComponent,
    StudentDataComponent,
    LibraryButtonComponent,
    PostDataComponent,
    GetDataComponent,
    IssueBookComponent,
    ReturnBookComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    FormsModule,
    MatInputModule,
    HttpClientModule


  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
