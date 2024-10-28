<template>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th scope="col">No</th>
        <th scope="col">Product Name</th>
        <th scope="col">Brand Name</th>
        <th scope="col">Subcategory</th>
        <th scope="col">Price</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="2">Function</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in products" :key="product.id">
        <td>Mark</td>
        <td>{{product.productName}}</td>
        <td>{{product.brandName[0]}}</td>
        <td>{{product.subCategory}}</td>
        <td>{{product.originPrice}}</td>
        <td>{{product.status}}</td>
        <td>
          <a href="#" class="btn btn-success">Detail</a>
          <a href="#" class="btn btn-warning">Update</a>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ProductService from '@/service/ProductService';

  export default {
    name: 'Product',
    data() {
      return {
        products : []
      }
    },
    methods: {
      getProduct(){
        ProductService.getProduct().then((response) =>{
          this.products = response.data.content;
        });
      }  
    },
    created() {
      this.getProduct();
    }
  }
</script>

