import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppDataService {

  private PUSH_ITEM: string = 'http://localhost:8080/stack/push';
  private POP_ITEM: string = 'http://localhost:8080/stack/pop';
  private GET_ITEM: string = 'http://localhost:8080/stack/get';

  constructor(private httpClient: HttpClient) { }

  public pushItem(item: number){
    let url = this.PUSH_ITEM + '?item=' + item;
    return this.httpClient.post(url, null);
  }

  public popItem(){
    return this.httpClient.get(this.POP_ITEM);
  }

  public getItem(){
    return this.httpClient.get(this.GET_ITEM);
  }
}
