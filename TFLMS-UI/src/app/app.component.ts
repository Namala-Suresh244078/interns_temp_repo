import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FileUploadComponent } from './trade-file-pages/trade-file-upload/file-upload.component';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FileUploadComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'myapp';
}
