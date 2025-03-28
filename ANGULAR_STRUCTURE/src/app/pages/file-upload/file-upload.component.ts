import { Component } from '@angular/core';
import { HttpClient, HttpEvent, HttpEventType } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http'; 

@Component({
  selector: 'app-file-upload',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './file-upload.component.html',
  styleUrl: './file-upload.component.css'
})
export class FileUploadComponent {
  selectedFile: File | null = null;
  uploadProgress: number = 0;
  isUploading: boolean = false;
  uploadedSize: string = "0 KB";
  totalSize: string = "0 KB";

  constructor(private http: HttpClient) {}

  formatSize(size: number): string {
    if (size < 1024) {
      return size + ' B';
    } else if (size < 1024 * 1024) {
      return (size / 1024).toFixed(2) + ' KB';
    } else {
      return (size / (1024 * 1024)).toFixed(2) + ' MB';
    }
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
      this.uploadProgress = 0; 
      this.uploadedSize = "0 KB"; 
      this.totalSize = this.formatSize(this.selectedFile.size);
    }
  }

  onUpload() {
    if (!this.selectedFile) {
      alert("Please select a file before uploading.");
      return;
    }

    this.isUploading = true;
    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.http.post('http://localhost:8080/api/upload', formData, {
      responseType: 'text',
      reportProgress: true,
      observe: 'events'
    }).subscribe((event: HttpEvent<any>) => {
      if (event.type === HttpEventType.UploadProgress ) {
        const total = event.total ?? this.selectedFile?.size ?? 1;
  this.uploadProgress = Math.round((event.loaded / total) * 100);
  this.uploadedSize = this.formatSize(event.loaded);
  this.totalSize = this.formatSize(total);
      } 

      if (event.type === HttpEventType.Response) {
        setTimeout(() => {
          this.isUploading = false;
          alert('Upload success!');
          this.uploadProgress = 0;
          this.uploadedSize = "0 KB";
        }, 500);
      }
    }, error => {
      this.isUploading = false;
      alert('Upload failed!');
      this.uploadProgress = 0;
      this.uploadedSize = "0 KB";
    });
  }
}
