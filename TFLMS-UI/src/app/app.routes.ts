import { Routes } from '@angular/router';
import { HomeComponent } from './trade-file-pages/trade-file-home/home.component';
import { FileDetailsComponent } from './trade-file-pages/trade-file-details/file-details.component';
import { FileUploadComponent } from './trade-file-pages/trade-file-upload/file-upload.component';
import { StatusUpdateComponent } from './trade-file-status-update/status-update.component';
import { FileInfoComponent } from './trade-file-info/file-info.component';
import { FileInputComponent } from './trade-file-input/file-input.component';
import { FileListComponent } from './trade-file-list/file-list.component';
import { FileSearchComponent } from './trade-file-search/file-search.component';

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