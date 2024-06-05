<template>
  <div class="m-3">
    <h3>404 Not Found</h3>
    <p>존재하지 않는 요청 경로 : {{ currentRoute.path }}</p>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
const currentRoute = useRoute();
</script>
