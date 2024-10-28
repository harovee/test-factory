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
                    <select class="form-select"
                        aria-label="Default select example">
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
            <button type="button" class="btn btn-success" @click.prevent="showModal">
                Add Product
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" :class="{ show: showForm }"
                :style="{ display: showForm ? 'block' : 'none' }">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
                        </div>
                        <div class="modal-body">
                            <form action="#">
                                <div class="form-group mb-2">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" id="name">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="color">Color</label>
                                    <input type="text" class="form-control" id="color">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="color">Quantity</label>
                                    <input type="number" class="form-control" id="quantity">
                                </div>
                                <div class="form-group mb-2">
                                    <label for="sell-price">Sell Price</label>
                                    <input type="text" class="form-control" id="sell-price">
                                </div>
                                <div class="form-group mb-2 ">
                                    <label for="brand">Brand Name</label>
                                    <select id="brand" name="brand" class="form-control">
                                        <option selected>Choose...</option>
                                        <option>...</option>
                                    </select>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="subcategory">Subcategory</label>
                                    <select name="subcategory" id="subcategory" class="form-control">
                                        <option selected>Choose...</option>
                                        <option>#</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success">Save changes</button>
                            <button type="button" class="btn btn-secondary" @click.prevent="closeModal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            showForm: false
        }
    },
    methods: {
        showModal() {
            this.showForm = true;
        },
        closeModal() {
            this.showForm = false;
        }
    }
}
</script>
