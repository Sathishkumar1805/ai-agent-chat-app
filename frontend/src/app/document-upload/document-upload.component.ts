import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-document-upload',
  template: `
    <div class="upload-container">
      <form (ngSubmit)="upload()">
        <input type="text" [(ngModel)]="name" name="name" required placeholder="Document name" />
        <textarea [(ngModel)]="content" name="content" required placeholder="Paste document content..."></textarea>
        <button type="submit">Upload Document</button>
      </form>
      <div *ngIf="uploadedDoc">
        <b>Uploaded:</b> {{uploadedDoc.name}}
      </div>
    </div>
  `,
  styles: [`.upload-container { max-width: 600px; margin: 20px auto; } textarea { width: 100%; min-height: 80px; }`]
})
export class DocumentUploadComponent {
  name = '';
  content = '';
  uploadedDoc: any = null;

  constructor(private http: HttpClient) {}

  upload() {
    if (!this.name.trim() || !this.content.trim()) return;
    this.http.post<any>('/api/documents?name=' + encodeURIComponent(this.name), this.content, { responseType: 'json' as 'json' })
      .subscribe(res => {
        this.uploadedDoc = res;
        this.name = '';
        this.content = '';
      });
  }
}
