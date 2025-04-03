import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-file-list',
  standalone: true,
  imports: [CommonModule], 
  templateUrl: './file-list.component.html',
  styleUrls: ['./file-list.component.css']
})
export class FileListComponent {
  files = [
    { id: 1, filename: 'report1.pdf', uploadDate: '2024-03-20', status: 'Completed', recordCount: 120 },
    { id: 2, filename: 'data.xlsx', uploadDate: '2024-03-22', status: 'Pending', recordCount: 85 },
    { id: 3, filename: 'summary.docx', uploadDate: '2024-03-25', status: 'Completed', recordCount: 200 },
    { id: 4, filename: 'presentation.pptx', uploadDate: '2024-03-27', status: 'Failed', recordCount: 0 }
  ];
}
