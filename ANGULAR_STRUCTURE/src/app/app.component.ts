import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FileUploadComponent } from './pages/file-upload/file-upload.component';
import { FooterComponent } from './footer/footer.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FileUploadComponent,FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  template:`<app-footer></footer>`
})
export class AppComponent {
  title = 'myapp';
}
