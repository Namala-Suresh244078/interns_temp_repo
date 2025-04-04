import { Component,Inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';



@Component({
  standalone: true,
  selector: 'app-status-update-dialog',
  imports: [CommonModule,
          MatDialogModule,
          MatFormFieldModule,
          FormsModule,
        MatSelectModule,
        MatButtonModule
],
  templateUrl: './status-update-dialog.component.html',
  styleUrl: './status-update-dialog.component.css'
})
export class StatusUpdateDialogComponent {
  statuses: string[] = ['Pending', 'In Progress', 'Completed', 'Failed'];
    selectedStatus: string = '';

    constructor(
      public dialogRef: MatDialogRef<StatusUpdateDialogComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any
    ) {}


        onCancel(): void{
          this.dialogRef.close();
          }
        onSave(): void{
          this.dialogRef.close(this.selectedStatus);}
        }
