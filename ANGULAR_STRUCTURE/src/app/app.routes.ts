import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FileDetailsComponent } from './pages/file-details/file-details.component';
import { FileUploadComponent } from './pages/file-upload/file-upload.component';
import { StatusUpdateComponent } from './status-update/status-update.component';
import { FileInfoComponent } from './file-info/file-info.component';
import { FileInputComponent } from './file-input/file-input.component';
import { FileListComponent } from './file-list/file-list.component';
import { FileSearchComponent } from './file-search/file-search.component';

export const routes: Routes = [
  // Page routes
  { 
    path: '', 
    component: HomeComponent, 
    title: 'Home' 
  },
  { 
    path: 'file-details', 
    component: FileDetailsComponent, 
    title: 'File Details' 
  },
  { 
    path: 'upload', 
    component: FileUploadComponent, 
    title: 'File Upload' 
  },
  
  // Standalone component routes
  { 
    path: 'file-info', 
    component: FileInfoComponent, 
    title: 'File Information' 
  },
  { 
    path: 'file-input', 
    component: FileInputComponent, 
    title: 'File Input' 
  },
  { 
    path: 'file-list', 
    component: FileListComponent, 
    title: 'File List' 
  },
  { 
    path: 'file-search', 
    component: FileSearchComponent, 
    title: 'File Search' 
  },
  { 
    path: 'status', 
    component: StatusUpdateComponent, 
    title: 'System Status' 
  },
  
  // Redirect unknown paths to home
  { 
    path: '**', 
    redirectTo: '' 
  }
];