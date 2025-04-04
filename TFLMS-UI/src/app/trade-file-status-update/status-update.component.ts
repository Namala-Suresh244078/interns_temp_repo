import { Component, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-status-update',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,

  ],
  templateUrl: './status-update.component.html',
  styleUrls: ['./status-update.component.css']
})
export class StatusUpdateComponent {
  fileStatus: string = 'Pending';

  constructor(private dialog: MatDialog) {}

  openStatusDialog(): void {
    const dialogRef = this.dialog.open(StatusUpdateDialogComponent, {
      width: '400px',
      data: { currentStatus: this.fileStatus }
    });

    dialogRef.afterClosed().subscribe((result: string) => {
      if (result) {
        this.fileStatus = result;
      }
    });
  }
}

@Component({
  selector: 'app-status-update-dialog',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule
  ],
  template: `
    <h2 mat-dialog-title>Update File Status</h2>
    <mat-dialog-content>
      <mat-form-field appearance="fill" style="width: 100%;">
        <mat-label>Status</mat-label>
        <mat-select [(value)]="selectedStatus">
          <mat-option value="Pending">Pending</mat-option>
          <mat-option value="Processing">Processing</mat-option>
          <mat-option value="Completed">Completed</mat-option>
        </mat-select>
      </mat-form-field>
    </mat-dialog-content>
    <mat-dialog-actions align="end">
      <button mat-button mat-dialog-close>Cancel</button>
      <button mat-button [mat-dialog-close]="selectedStatus" cdkFocusInitial>Save</button>
    </mat-dialog-actions>
  `
})
export class StatusUpdateDialogComponent {
  selectedStatus: string;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
    this.selectedStatus = data.currentStatus;
  }
}
