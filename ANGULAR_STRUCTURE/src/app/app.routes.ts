import { Routes } from '@angular/router';
import { FileUploadComponent } from './pages/file-upload/file-upload.component';
import { AppComponent } from './app.component';
export const routes: Routes = [
    { path: '', component: AppComponent }, 
  { path: 'file-upload', component: FileUploadComponent } 
];
