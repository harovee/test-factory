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
        <td>{{ index + 1 }}</td>
        <td>{{ product.productName }}</td>
        <td>{{ product.brandName[0] }}</td>
        <td>{{ product.subCategory }}</td>
        <td>{{ product.originPrice }}</td>
        <td>{{ product.status }}</td>
        <td>
          <button
            class="btn btn-success"
            @click.prevent="showFormModal(product.id, 'detail')"
          >
            Detail
          </button>
          <button
            class="btn btn-warning"
            @click.prevent="showFormModal(product.id, 'update')"
          >
            Update
          </button>
          <button class="btn btn-danger" @click="deleteProduct">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
  <modal-update
    :show-modal="showModal"
    :product="selected"
    @isVisible="showModal = $event"
    v-if="selectedProduct && modalTyped === 'update'"
  >
  </modal-update>
  <modal-detail
    v-if="selectedProduct && modalTyped === 'detail'"
    :show-modal="showModal"
    :product="selected"
    @isVisible="showModal = $event"
  >
  </modal-detail>
</template>

<script>
import ProductService from "@/service/ProductService";
import ModalUpdate from "./modal/ModalUpdate.vue";
import ModalDetail from "./modal/ModalDetail.vue";

export default {
  name: "Product",
  components: { ModalUpdate, ModalDetail },

  data() {
    return {
      // showUpdate: false,
      // showDetail: false
      showModal: false,
      modalType: "",
      products: [],
      selectedProduct: null,
    };
  },

  inject: ["listStatuses"],

  computed: {
    brands() {
      return this.listBrands();
    },
    subCates() {
      return this.listSubCates();
    },
    statuses() {
      return this.listStatuses();
    },
    selected() {
      return this.selectedProduct;
    },
    modalTyped() {
      return this.modalType;
    },
  },

  mounted() {
    console.log(this.modalType);
  },

  methods: {
    getProduct() {
      ProductService.getProduct().then((response) => {
        this.products = response.data.content;
      });
    },

    showFormModal(id, modalType1) {
      this.showModal = false;
      ProductService.getProductById(id).then((response) => {
        this.selectedProduct = response.data;
        // console.log(response.data);
        this.modalType = modalType1;
        this.showModal = true;
      });
    },
  },

  created() {
    this.getProduct();
  },
};
</script>
