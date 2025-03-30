import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {CommonModule} from '@angular/common';
import {MatSelectModule} from '@angular/material/select';
import {MarFormFieldModule} from '@angular/material/form-field';
import {MatOptionModule} from '@angular/material/core';
import { StatusUpdateDialogComponent } from './status-update-dialog/status-update-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    StatusUpdateDialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatOptionModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    CommonModule
  ],
  bootstrap: [AppComponent]
})
export class StatusUpdateDialogModule { }
