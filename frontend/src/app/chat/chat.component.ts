import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-chat',
  template: `
    <div class="chat-container">
      <div *ngFor="let msg of messages">
        <div class="user-msg"><b>You:</b> {{msg.userMessage}}</div>
        <div class="ai-msg"><b>AI:</b> {{msg.aiResponse}}</div>
      </div>
      <form (ngSubmit)="sendMessage()">
        <input [(ngModel)]="userMessage" name="userMessage" required placeholder="Type your message..." />
        <button type="submit">Send</button>
      </form>
    </div>
  `,
  styles: [`.chat-container { max-width: 600px; margin: 20px auto; } .user-msg, .ai-msg { margin: 5px 0; }`]
})
export class ChatComponent {
  userMessage = '';
  messages: any[] = [];

  constructor(private http: HttpClient) {}

  sendMessage() {
    if (!this.userMessage.trim()) return;
    this.http.post<any>('/api/chat', this.userMessage, { responseType: 'json' as 'json' })
      .subscribe(res => {
        this.messages.push(res);
        this.userMessage = '';
      });
  }
}
