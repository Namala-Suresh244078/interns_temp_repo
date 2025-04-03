import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {StatusUpdateDialogComponent} from './status-update-dialog/status-update-dialog.component';
import {StatusService} from './services/status.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  fileStatus:string='Pending';
  title = 'status-update-app';
constructor(public dialog: MatDialog) {}

  openStatusDialog(): void {
    const dialogRef = this.dialog.open(StatusUpdateDialogComponent, {
      width: '400px',
      data: { message: 'Update status' }
    });

    dialogRef.afterClosed().subscribe((result:any) => {
     console.log('Dialog closed with result:',result);
     if (result){

       this.fileStatus=result;}
    });
  }
}
