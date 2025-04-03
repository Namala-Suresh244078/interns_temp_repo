import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FileListComponent } from './trade-file-list/file-list.component'; 

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FileListComponent], 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'file-list-app';
}
