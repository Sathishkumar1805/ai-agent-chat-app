import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>AI Agent Chat App</h1>
    <app-document-upload></app-document-upload>
    <app-chat></app-chat>
  `
})
export class AppComponent {}
