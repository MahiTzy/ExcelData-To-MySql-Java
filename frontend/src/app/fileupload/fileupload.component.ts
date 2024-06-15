import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fileupload',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './fileupload.component.html',
  styleUrl: './fileupload.component.css',
})
export class FileuploadComponent {
  constructor(private http: HttpClient) {}

  file: any;
  selectFile(event: any) {
    this.file = event.target.files[0];
    // console.log(this.file);
  }
  uploadFile() {
    let formData = new FormData();
    formData.append('file', this.file);
    this.http
      .post('http://localhost:8080/product/upload', formData, {
        observe: 'response',
        responseType: 'text',
      })
      .subscribe(
        (response) => {
          console.log('Raw response:', response);
        },
        (error) => {
          console.error('Error response:', error);
        }
      );
  }
}
