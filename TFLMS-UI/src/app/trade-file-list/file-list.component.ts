import { Component } from '@angular/core';

@Component({
  selector: 'app-file-list',
  templateUrl: './file-list.component.html',
  styleUrls: ['./file-list.component.css']
})
export class FileListComponent {
  files = [
    { id: 101, filename: 'trade_report_01.pdf', uploadDate: '2025-04-04', status: 'Completed', recordCount: 250 },
    { id: 102, filename: 'stock_prices.csv', uploadDate: '2025-04-03', status: 'Processing', recordCount: 180 },
    { id: 103, filename: 'market_data.xml', uploadDate: '2025-04-02', status: 'Failed', recordCount: 300 },
  ];
}