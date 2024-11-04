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
        <th scope="col" colspan="3">Function</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(product, index) in products" :key="product.id">
        <td>{{index + 1}}</td>
        <td>{{product.productName}}</td>
        <td>{{product.brandName[0]}}</td>
        <td>{{product.subCategory}}</td>
        <td>{{product.originPrice}}</td>
        <td>{{product.status}}</td>
        <td>
          <button class="btn btn-success" @click="showDetail">Detail</button>
          <button class="btn btn-warning" @click.prevent="showUpdate = true">Update</button>
          <button class="btn btn-danger" @click="deleteProduct">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
  <modal-update
          :show-modal="showUpdate"
          @isVisible="showUpdate = $event">
  </modal-update>
</template>

<script>
import ProductService from '@/service/ProductService';
import ModalUpdate from './modal/ModalUpdate.vue';

  export default {
    components: {ModalUpdate},

    data() {
      return {
        showUpdate: false
      }
    },

    inject: [ "listStatuses"],

    computed: {
      brands() {
        return this.listBrands();
      },
      subCates() {
        return this.listSubCates();
      },
      statuses() {
        return this.listStatuses();
      }
    },

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

