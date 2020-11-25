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

  key = "AIzaSyARJnJeSRuwWaW9Y4LMBnV8MqwaybrRKq0"
  sessiontoken = '1234567890'
  timezone; 

  predictions;

  timeOut;
  timeOutDuration = 500;

  getTimeZoneInfo(loc) {
    // https://maps.googleapis.com/maps/api/timezone/json?location=31.230416,121.473701&timestamp=1331161200&key=AIzaSyARJnJeSRuwWaW9Y4LMBnV8MqwaybrRKq0
    this.apiService.get('/timezone/json?location='+ encodeURI(loc.lat+","+loc.lng) + '&timestamp=1331161200&key='+this.key+'&sessiontoken='+this.sessiontoken)
      .subscribe(
        data => {
          this.timezone = data.timeZoneName + " @" + data.rawOffset/3600;
          return data;
        });
  }

  getPlaceInfo(predictions) {
    this.timezone = "";
    if (predictions.length > 0) {
      var placeId = predictions[0].place_id;
      // https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJMzz1sUBwsjURoWTDI5QSlQI&fields=geometry&key=AIzaSyARJnJeSRuwWaW9Y4LMBnV8MqwaybrRKq0
      this.apiService.get('/place/details/json?place_id='+ encodeURI(placeId) + '&fields=geometry&key='+this.key+'&sessiontoken='+this.sessiontoken)
      .subscribe(
        data => {
          var loc = data.geometry.location;
          this.getTimeZoneInfo(loc);
          return data;
        });
    }
  }

  onSearchChange(searchValue: string): void {  
    clearTimeout(this.timeOut);
    this.timeOut = setTimeout(() => {
      console.log('get ' + searchValue);
      this.apiService.get('/place/autocomplete/json?input='+ encodeURI(searchValue) + '&key='+this.key+'&sessiontoken='+this.sessiontoken)
      .subscribe(
        data => {
          this.predictions = data.predictions;
          this.getPlaceInfo(this.predictions);
          return data;
        });
    }, this.timeOutDuration);

    
  }
  time = new Observable<string>(observer => {
    setInterval(() => observer.next(new Date().toString()), 1000);
  });
}
