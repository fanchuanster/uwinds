import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { City } from './city';

import { ArticleListConfig, TagsService, UserService, ApiService } from '../core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(
    private router: Router,
    private tagsService: TagsService,
    private userService: UserService,
    private apiService: ApiService,
  ) {}

  res; 

  auto_list: City[];
  get(input) {
    console.log('get ' + input);
    this.apiService.get('/place/autocomplete/json?input='+ encodeURI(input) + '&key=AIzaSyARJnJeSRuwWaW9Y4LMBnV8MqwaybrRKq0&sessiontoken=1234567890')
    .subscribe(
      data => {
        this.res = data.predictions;
        console.log(data);
        return data;
      });
  }
  onSearchChange(searchValue: string): void {  
    console.log(searchValue);
    // console.log();
    this.get(searchValue);
  }
  time = new Observable<string>(observer => {
    setInterval(() => observer.next(new Date().toString()), 1000);
  });
}
