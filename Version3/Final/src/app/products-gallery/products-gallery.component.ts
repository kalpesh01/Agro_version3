import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products-gallery',
  templateUrl: './products-gallery.component.html',
  styleUrls: ['./products-gallery.component.css']
})
export class ProductsGalleryComponent implements OnInit {
  productList = [];

  constructor(private router: Router,
    private http: HttpClient) { }

  ngOnInit(): void {
    this.getProductsList();

  }

  // http://localhost:8080/api/product/GetFarmerDetails

  async getProductsList() {

    const url = 'http://localhost:8080/api/product/GetFarmerDetails';
    const myres: any = await this.http.get(url).toPromise();


    if (myres.length == 0) {
      // this.productList = myres;
      console.log("empty");
    } else {
      // console.log("data came here");
      // this.productList = myres;
      console.log(myres);
    }
  }


}
