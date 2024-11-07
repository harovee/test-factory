<template>
  <div class="container">
    <search></search>
    <table-product></table-product>
  </div>
</template>

<script>

import Search from "./components/Search.vue";
import TableProduct from "./components/TableProduct.vue";
import BrandService from "./service/BrandService";
import SubcategoryService from "./service/SubcategoryService";
import StatusService from "./service/StatusService";
export default {
  name: "App",
  components: { Search, TableProduct },
  data() {
    return {
      listProduct: [],
      listBrand: [],
      listSubCate: [],
      listStatus: []
    };
  },

   mounted() {
     this.getBrands();
     this.getSubCategories();
     this.getStatusList();
  },

  provide() {
    //truyen gia tri cua cha sang lop con
    return {
      listProduct: () => this.listProduct,
      listBrands: () => this.listBrand,
      listSubCates: () => this.listSubCate,
      listStatuses: () => this.listStatus
    };
  },

  methods: {
    getBrands() {
      BrandService.getBrands().then((response) => {
        this.listBrand = response.data;
        // console.log(this.listBrand);
      }).catch(error => {
        console.error("Error fetching brands:", error);
      });
    },

    getSubCategories() {
      SubcategoryService.getSubCategories()
        .then((response) => {
          this.listSubCate = response.data;
          // console.log(response.data); 
        })
        .catch((error) => {
          console.error("Error fetching subcategories:", error);
        });
    },

    getStatusList() {
      StatusService.getStatusList()
      .then((response) => {
        this.listStatus = response.data;
      })
      .catch((error) => {
        console.error("Error fetching status list: ", error);
      })
    },
  },
};
</script>
