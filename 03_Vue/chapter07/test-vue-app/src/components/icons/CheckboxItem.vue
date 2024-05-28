<template>
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: "CheckboxItem",

  // name, checked 속성 추가
  props: {
    id: [Number, String],
    name: String,
    checked: {
      type: Boolean,
      required: false,
      default: false,
    },
  },

  data() {
    return {
      checked: false,
    };
  },
};
</script>
