<template>
    <div class="mb-3">
        <form action="#">
            <div class="row">
                <div class="col">
                    <label for="">Name</label>
                    <input type="text" class="form-control" placeholder="Product name">
                </div>
                <div class="col">
                    <label for="">Price</label>
                    <input type="text" class="form-control" placeholder="Origin price">
                </div>
                <div class="col">
                    <label for="">Brand</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="">...</option>
                    </select>
                </div>
                <div class="col">
                    <label for="">Category</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="col">
                    <label for="">Status</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="col">
                    <a class="btn btn-success mt-4">Search</a>
                </div>
            </div>
        </form>
        <div class="my-4">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success" @click.prevent="showForm = true">
                Add Product
            </button>

            <modal-add 
            :show-modal="showForm" 
            @isVisible="showForm = $event">
            </modal-add>
        </div>
    </div>
</template>
<script>
import ModalAdd from './modal/ModalAdd.vue';

export default {
    components: { ModalAdd },
    data() {
        return {
            showForm: false
        }
    },
    methods: {
    },

    inject: ["listBrands", "listSubCates"],

    computed: {
        brands() {
            return this.listBrands()
        },
        subCates() {
            return this.listSubCates()
        }
    }
}
</script>
