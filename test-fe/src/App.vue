
<template>
  <div class="container">
    <search></search>
  <table-product></table-product>
  </div>
</template>

<script>
import Search from './components/Search.vue';
import TableProduct from './components/TableProduct.vue';
export default {
  name: 'App',
  components: {Search, TableProduct}
}
</script>
