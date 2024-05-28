<script>
export default {
  name: "CheckboxItem2",
  // 내보낼 idol 속성
  props: ["idol"],
};
</script>

<template>
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>
