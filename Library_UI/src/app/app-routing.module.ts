import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { ButtonComponent } from './components/button/button.component';
import { GetDataComponent } from './components/get-data/get-data.component';
import { IssueBookComponent } from './components/issue-book/issue-book.component';
import { KnitComponent } from './components/knit/knit.component';
import { LibraryButtonComponent } from './components/library-button/library-button.component';
import { PostDataComponent } from './components/post-data/post-data.component';
import { ReturnBookComponent } from './components/return-book/return-book.component';
import { StudentDataComponent } from './components/student-data/student-data.component';

const routes: Routes = [
  {
    path: "showKnit",
    component: KnitComponent,
    pathMatch: "full"
  },
  {
    path: "showButton",
    component: ButtonComponent,
    pathMatch: "full"
  },
  {
    path: "admin",
    component: AdminComponent,
    pathMatch: "full"
  },
  {
    path:"showStudentData",
    component:StudentDataComponent,
    pathMatch:"full"
  },
  {
    path:"libraryButton",
    component:LibraryButtonComponent,
    pathMatch:"full"
  },
{
  path:"postData",
  component:PostDataComponent,
  pathMatch:"full"
},
{
  path:"getData",
  component:GetDataComponent,
  pathMatch:"full"
},
{
path:"issueBook",
component:IssueBookComponent,
pathMatch:"full"
},
{
  path:"returnBook",
  component:ReturnBookComponent,
  pathMatch:"full"
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
