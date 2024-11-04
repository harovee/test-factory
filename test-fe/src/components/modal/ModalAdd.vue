<template>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" :class="{ show: showModal }"
                :style="{ display: showModal ? 'block' : 'none' }">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
                        </div>
                        <div class="modal-body">
                            <form action="#">
                                <div class="form-group mb-2">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" id="name" v-model="product.productName">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="color">Color</label>
                                    <input type="text" class="form-control" id="color" v-model="product.color">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="color">Quantity</label>
                                    <input type="number" class="form-control" id="quantity" v-model="product.quantity">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="sell-price">Sell Price</label>
                                    <input type="text" class="form-control" id="sell-price" v-model="product.sellPrice">
                                </div>
                                <div class="form-group mb-2 ">
                                    <label for="brand">Brand Name</label>
                                    <select id="brand" name="brand" class="form-control" v-model="product.brandId">
                                        <option v-for="brand in brands" :key="brand.id" :value="brand.id" >{{brand.brandName }}</option>
                                    </select>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="subcategory">Subcategory</label>
                                    <select name="subcategory" id="subcategory" class="form-control" v-model="product.subCategoryId">
                                        <option v-for="subcate in subCates" :key="subcate.id" :value="subcate.id" >{{ subcate.subCateName }}</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" @click="AddProduct">Save changes</button>
                            <button type="button" class="btn btn-secondary" @click.prevent="modalClose">Close</button>
                        </div>
                    </div>
                </div>
            </div>
</template>
<script>

 export default {
    props: { //tạo thuộc tính
        showModal: {
            type: Boolean,
            required: true
        }
    },
    
    inject: ["listBrands", "listSubCates"],

    computed: { //sau khi tiêm list, load lại nếu có thay đổi
        brands() { 
            return this.listBrands()
        },
        subCates() {
            return this.listSubCates()
        }
    },

    mounted() {
        // console.log(this.listBrands());
        // console.log(this.listSubCates());
    },

    data() {
        return {
            product: { // đúng convention của request be
                productName:"",
                brandId: null,
                subCategoryId: null,
                originPrice: 0,
                sellPrice: 0,
                color: "",
                quantity: 0
            }
        }
    },

    methods: {
        modalClose(){
            this.$emit("isVisible", false);
        }
    },
    
 }

</script>
