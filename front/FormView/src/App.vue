<script setup>
import Form from './components/Form.vue';
import Data from './components/Data.vue';
</script>
<script>
   const api="http://localhost:8080/api/users";
</script>
<template>

<Form :api=api></Form>
<Data :api=api></Data>
</template>

<style scoped>


</style>
