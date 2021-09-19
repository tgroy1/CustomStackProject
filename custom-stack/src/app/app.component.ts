import { Component } from '@angular/core';
import { AppDataService } from './app-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  pageTitle: string = 'Custom Stack';
  newValue: string = '';
  showInputBox: boolean = false;
  showErrorMessage: boolean = false;
  successMessage: string = '';
  itemRetrieved: string = '';
  errorMessage: string = '';

  constructor(private dataService: AppDataService) { }

  showInput(): void {
    this.showInputBox = true;
    this.showErrorMessage = false;
    this.successMessage = '';
  }

  addItem(): void {
      this.showErrorMessage = false;
      this.successMessage = '';
      let num = Number(this.newValue);

      if (Number.isNaN(num) || this.newValue === '' || num > 100 || num < -100) {
        this.showErrorMessage = true;
        this.errorMessage = 'Please enter a valid number in the range -100 to 100';
        console.log('Invalid input');
        return;
      }

      this.dataService.pushItem(num).subscribe((data: any)=>{
        console.log(data);
        this.itemRetrieved = data;
        this.successMessage = 'Data entered successfully :';
      },
      error => {
        this.errorMessage = error.error;
        this.showErrorMessage = true;
        console.log(this.errorMessage);
      });
  }

  popItem(): void {
    this.showInputBox = false;
    this.showErrorMessage = false;
    this.successMessage = '';

    this.dataService.popItem().subscribe((data: any)=>{
      console.log(data);
      this.itemRetrieved = data;
      this.successMessage = 'Data popped successfully :';
    },
    error => {
      this.errorMessage = error.error;
      this.showErrorMessage = true;
      console.log(this.errorMessage);
    });
  }

  getItem(): void {
    this.showInputBox = false;
    this.showErrorMessage = false;
    this.successMessage = '';

    this.dataService.getItem().subscribe((data: any)=>{
      console.log(data);
      this.itemRetrieved = data;
      this.successMessage = 'Data retrieved successfully :';
    },
    error => {
      this.errorMessage = error.error;
      this.showErrorMessage = true;
      console.log(this.errorMessage);
    });


  }
}
