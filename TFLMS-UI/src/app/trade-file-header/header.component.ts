
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentTime: string = '';
  isDarkMode: boolean = false;

  ngOnInit() {
    this.updateTime();
    setInterval(() => this.updateTime(), 1000);

    // Check localStorage for theme preference
    const savedTheme = localStorage.getItem('theme');
    this.isDarkMode = savedTheme === 'dark';
    this.applyTheme();
  }

  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
    localStorage.setItem('theme', this.isDarkMode ? 'dark' : 'light');
    this.applyTheme();
  }

  applyTheme() {
    document.body.classList.toggle('dark-theme', this.isDarkMode);
  }

  updateTime() {
    this.currentTime = new Date().toLocaleTimeString();
  }
}

