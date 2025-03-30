import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private apiUrl = 'http://localhost:8080/status'; // Change this to your backend URL

  constructor(private http: HttpClient) {}

  // Method to get file status from backend
  getFileStatus(): Observable<string> {
    return this.http.get<string>(this.apiUrl);
  }

  // Method to update file status
  updateFileStatus(newStatus: string): Observable<void> {
    return this.http.post<void>(this.apiUrl, { status: newStatus });
  }
}
